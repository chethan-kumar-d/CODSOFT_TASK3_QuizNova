package com.example.domain

import com.example.data.questions.QuestionBank
import com.example.model.ActiveQuizSession
import com.example.model.AnswerOutcome
import com.example.model.AttemptCompletionStatus
import com.example.model.EvaluatedAnswerRecord
import com.example.model.FinalizedAttemptSummary
import com.example.model.QuizMode
import com.example.model.QuizQuestion
import kotlin.math.roundToInt

object QuizScoringEngine {

    /**
     * Selects an option for the current question without submitting it.
     * Ignored if the session is already finalized or the current question is already submitted.
     */
    fun selectOption(session: ActiveQuizSession, optionId: String): ActiveQuizSession {
        if (session.isFinalized) return session
        val current = session.currentQuestionState ?: return session
        if (current.isSubmitted) return session
        if (optionId !in current.shuffledOptionIds) return session

        val updatedQuestions = session.questions.toMutableList()
        updatedQuestions[session.currentIndex] = current.copy(selectedOptionId = optionId)
        return session.copy(questions = updatedQuestions)
    }

    /**
     * Explicitly submits the currently selected option for the current question.
     * Idempotent: if already submitted or no option selected, returns the session unchanged.
     */
    fun submitCurrentAnswer(session: ActiveQuizSession): ActiveQuizSession {
        if (session.isFinalized) return session
        val current = session.currentQuestionState ?: return session
        if (current.isSubmitted) return session
        val selected = current.selectedOptionId ?: return session

        val updatedQuestions = session.questions.toMutableList()
        updatedQuestions[session.currentIndex] = current.copy(
            submittedOptionId = selected,
            isSubmitted = true
        )
        return session.copy(questions = updatedQuestions)
    }

    /**
     * Advances to the next question if the current question has been submitted
     * and there is a subsequent question.
     */
    fun advanceToNextQuestion(session: ActiveQuizSession): ActiveQuizSession {
        if (session.isFinalized) return session
        val current = session.currentQuestionState ?: return session
        if (!current.isSubmitted) return session
        if (session.currentIndex >= session.questions.lastIndex) return session

        return session.copy(currentIndex = session.currentIndex + 1)
    }

    /**
     * Marks a Challenge session as armed once the Challenge screen is visible and focused.
     */
    fun armChallengeMonitoring(session: ActiveQuizSession): ActiveQuizSession {
        if (session.mode != QuizMode.CHALLENGE || session.isFinalized || session.challengeArmed) {
            return session
        }
        return session.copy(challengeArmed = true)
    }

    /**
     * Evaluates and finalizes an active quiz session into a [FinalizedAttemptSummary].
     * Any option that was selected but NOT explicitly submitted is treated as UNANSWERED (0 marks).
     */
    fun evaluateSession(
        session: ActiveQuizSession,
        completionStatus: AttemptCompletionStatus,
        completedAtEpochMillis: Long = System.currentTimeMillis(),
        questionResolver: (String) -> QuizQuestion? = QuestionBank::getQuestionById
    ): Pair<ActiveQuizSession, FinalizedAttemptSummary> {
        val finalizedSession = session.copy(isFinalized = true, challengeArmed = false)

        val evaluatedAnswers = finalizedSession.questions.mapIndexedNotNull { index, sq ->
            val question = questionResolver(sq.questionId) ?: return@mapIndexedNotNull null
            val submittedId = if (sq.isSubmitted) sq.submittedOptionId else null
            val outcome = when {
                submittedId == null -> AnswerOutcome.UNANSWERED
                submittedId == question.correctOptionId -> AnswerOutcome.CORRECT
                else -> AnswerOutcome.INCORRECT
            }
            EvaluatedAnswerRecord(
                questionIndex = index,
                question = question,
                shuffledOptionIds = sq.shuffledOptionIds,
                selectedOptionId = sq.selectedOptionId,
                submittedOptionId = submittedId,
                correctOptionId = question.correctOptionId,
                outcome = outcome
            )
        }

        val total = evaluatedAnswers.size
        val correct = evaluatedAnswers.count { it.outcome == AnswerOutcome.CORRECT }
        val incorrect = evaluatedAnswers.count { it.outcome == AnswerOutcome.INCORRECT }
        val unanswered = evaluatedAnswers.count { it.outcome == AnswerOutcome.UNANSWERED }
        val percentage = if (total > 0) {
            ((correct.toDouble() / total.toDouble()) * 100.0).roundToInt()
        } else {
            0
        }

        val summary = FinalizedAttemptSummary(
            attemptId = finalizedSession.sessionId,
            scope = finalizedSession.scope,
            difficulty = finalizedSession.difficulty,
            mode = finalizedSession.mode,
            totalQuestions = total,
            correctCount = correct,
            incorrectCount = incorrect,
            unansweredCount = unanswered,
            percentage = percentage,
            startedAtEpochMillis = finalizedSession.startedAtEpochMillis,
            completedAtEpochMillis = completedAtEpochMillis,
            completionStatus = completionStatus,
            answers = evaluatedAnswers
        )

        return finalizedSession to summary
    }
}
