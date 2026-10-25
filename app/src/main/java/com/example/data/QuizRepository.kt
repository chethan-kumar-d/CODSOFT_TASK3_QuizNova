package com.example.data

import com.example.data.local.PreferencesAndSessionStore
import com.example.data.local.QuizAnswerRecordEntity
import com.example.data.local.QuizAttemptEntity
import com.example.data.local.QuizDao
import com.example.data.questions.QuestionBank
import com.example.domain.QuizScoringEngine
import com.example.model.ActiveQuizSession
import com.example.model.AnswerOutcome
import com.example.model.AttemptCompletionStatus
import com.example.model.EvaluatedAnswerRecord
import com.example.model.FinalizedAttemptSummary
import com.example.model.QuizDifficulty
import com.example.model.QuizMode
import com.example.model.QuizScope
import com.example.model.ThemePreference
import com.example.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class QuizRepository(
    private val quizDao: QuizDao,
    private val sessionStore: PreferencesAndSessionStore
) {
    private val finalizationMutex = Mutex()
    private val finalizedSessionIds = mutableSetOf<String>()

    val userPreferencesFlow: Flow<UserPreferences> = sessionStore.userPreferencesFlow
    val seenQuestionIdsFlow: Flow<Set<String>> = sessionStore.seenQuestionIdsFlow
    val activeSessionFlow: Flow<ActiveQuizSession?> = sessionStore.activeSessionFlow

    val allFinalizedAttemptsFlow: Flow<List<FinalizedAttemptSummary>> = combine(
        quizDao.observeAllAttempts(),
        quizDao.observeAllAnswerRecords()
    ) { attemptEntities, recordEntities ->
        val recordsByAttempt = recordEntities.groupBy { it.attemptId }
        attemptEntities.map { entity ->
            mapEntityToSummary(entity, recordsByAttempt[entity.attemptId].orEmpty())
        }
    }

    suspend fun getAttemptSummaryById(attemptId: String): FinalizedAttemptSummary? {
        val entity = quizDao.getAttemptById(attemptId) ?: return null
        val records = quizDao.getAnswerRecordsForAttempt(attemptId)
        return mapEntityToSummary(entity, records)
    }

    suspend fun getSeenQuestionIdsSnapshot(): Set<String> =
        sessionStore.getSeenQuestionIdsSnapshot()

    suspend fun markQuestionSeen(questionId: String) {
        sessionStore.markQuestionSeen(questionId)
    }

    suspend fun markQuestionsSeen(questionIds: Collection<String>) {
        sessionStore.markQuestionsSeen(questionIds)
    }

    /**
     * Resets seen-question records for the given scope and difficulty pool only,
     * preserving all attempt history, scores, and user preferences.
     */
    suspend fun resetSeenQuestionsForPool(
        scope: QuizScope,
        difficulty: QuizDifficulty
    ): Set<String> {
        val poolQuestionIds = QuestionBank
            .getMatchingQuestions(scope, difficulty)
            .map { it.id }
            .toSet()
        sessionStore.resetSeenQuestionsForPool(poolQuestionIds)
        return sessionStore.getSeenQuestionIdsSnapshot()
    }

    suspend fun getActiveSessionSnapshot(): ActiveQuizSession? =
        sessionStore.getActiveSessionSnapshot()

    suspend fun saveActiveSession(session: ActiveQuizSession) {
        if (!session.isFinalized && session.sessionId !in finalizedSessionIds) {
            sessionStore.saveActiveSession(session)
        }
    }

    suspend fun abandonActiveSession() {
        sessionStore.clearActiveSession()
    }

    /**
     * Atomically evaluates, persists to Room (at most once per attemptId), and clears the active session.
     * Safe against concurrent or duplicate finalization calls.
     */
    suspend fun finalizeAndPersistSession(
        session: ActiveQuizSession,
        completionStatus: AttemptCompletionStatus,
        completedAtEpochMillis: Long = System.currentTimeMillis()
    ): FinalizedAttemptSummary = finalizationMutex.withLock {
        val existingInDb = getAttemptSummaryById(session.sessionId)
        if (existingInDb != null) {
            finalizedSessionIds.add(session.sessionId)
            sessionStore.clearActiveSession()
            return@withLock existingInDb
        }

        val (_, summary) = QuizScoringEngine.evaluateSession(
            session = session,
            completionStatus = completionStatus,
            completedAtEpochMillis = completedAtEpochMillis
        )

        val attemptEntity = QuizAttemptEntity(
            attemptId = summary.attemptId,
            scopeId = summary.scope.id,
            difficultyId = summary.difficulty.id,
            modeId = summary.mode.id,
            totalQuestions = summary.totalQuestions,
            correctCount = summary.correctCount,
            incorrectCount = summary.incorrectCount,
            unansweredCount = summary.unansweredCount,
            percentage = summary.percentage,
            startedAtEpochMillis = summary.startedAtEpochMillis,
            completedAtEpochMillis = summary.completedAtEpochMillis,
            completionStatusId = summary.completionStatus.id
        )

        val recordEntities = summary.answers.map { ans ->
            QuizAnswerRecordEntity(
                attemptId = summary.attemptId,
                questionIndex = ans.questionIndex,
                questionId = ans.question.id,
                categoryId = ans.question.category.id,
                shuffledOptionIdsCsv = ans.shuffledOptionIds.joinToString(","),
                selectedOptionId = ans.selectedOptionId,
                submittedOptionId = ans.submittedOptionId,
                correctOptionId = ans.correctOptionId,
                outcomeId = ans.outcome.name
            )
        }

        quizDao.saveFinalizedAttemptOnce(attemptEntity, recordEntities)
        finalizedSessionIds.add(summary.attemptId)
        sessionStore.clearActiveSession()
        summary
    }

    suspend fun clearAllHistory() {
        quizDao.clearAllAttempts()
        finalizedSessionIds.clear()
    }

    suspend fun setThemePreference(theme: ThemePreference) {
        sessionStore.setThemePreference(theme)
    }

    suspend fun setReduceMotion(reduceMotion: Boolean) {
        sessionStore.setReduceMotion(reduceMotion)
    }

    private fun mapEntityToSummary(
        entity: QuizAttemptEntity,
        records: List<QuizAnswerRecordEntity>
    ): FinalizedAttemptSummary {
        val evaluatedAnswers = records
            .sortedBy { it.questionIndex }
            .mapNotNull { rec ->
                val question = QuestionBank.getQuestionById(rec.questionId) ?: return@mapNotNull null
                val outcome = runCatching { AnswerOutcome.valueOf(rec.outcomeId) }
                    .getOrDefault(AnswerOutcome.UNANSWERED)
                EvaluatedAnswerRecord(
                    questionIndex = rec.questionIndex,
                    question = question,
                    shuffledOptionIds = rec.shuffledOptionIdsCsv.split(",").filter { it.isNotBlank() },
                    selectedOptionId = rec.selectedOptionId,
                    submittedOptionId = rec.submittedOptionId,
                    correctOptionId = rec.correctOptionId,
                    outcome = outcome
                )
            }

        return FinalizedAttemptSummary(
            attemptId = entity.attemptId,
            scope = QuizScope.fromId(entity.scopeId),
            difficulty = QuizDifficulty.fromId(entity.difficultyId),
            mode = QuizMode.fromId(entity.modeId),
            totalQuestions = entity.totalQuestions,
            correctCount = entity.correctCount,
            incorrectCount = entity.incorrectCount,
            unansweredCount = entity.unansweredCount,
            percentage = entity.percentage,
            startedAtEpochMillis = entity.startedAtEpochMillis,
            completedAtEpochMillis = entity.completedAtEpochMillis,
            completionStatus = AttemptCompletionStatus.fromId(entity.completionStatusId),
            answers = evaluatedAnswers
        )
    }
}
