package com.example.data.questions

import com.example.model.ActiveQuizSession
import com.example.model.ActiveSessionQuestion
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizMode
import com.example.model.QuizQuestion
import com.example.model.QuizScope
import java.util.UUID
import kotlin.random.Random

data class QuestionBankValidationReport(
    val isValid: Boolean,
    val totalQuestions: Int,
    val categoryCounts: Map<QuizCategory, Int>,
    val categoryDifficultyCounts: Map<Pair<QuizCategory, QuizDifficulty>, Int>,
    val duplicateIds: List<String>,
    val duplicatePrompts: List<String>,
    val invalidOptionQuestions: List<String>,
    val invalidCorrectRefQuestions: List<String>,
    val blankFieldQuestions: List<String>
)

object QuestionBank {

    val allQuestions: List<QuizQuestion> by lazy {
        PythonQuestions.questions +
            PythonExtraQuestions.questions +
            JavaQuestions.questions +
            JavaExtraQuestions.questions +
            SqlQuestions.questions +
            SqlExtraQuestions.questions +
            ComputerFundamentalsQuestions.questions +
            ComputerFundamentalsExtraQuestions.questions +
            LogicalReasoningQuestions.questions +
            LogicalReasoningExtraQuestions.questions
    }

    private val questionById: Map<String, QuizQuestion> by lazy {
        allQuestions.associateBy { it.id }
    }

    fun getQuestionById(id: String): QuizQuestion? = questionById[id]

    fun getQuestionsForCategory(category: QuizCategory): List<QuizQuestion> =
        allQuestions.filter { it.category == category }

    fun getMatchingQuestions(scope: QuizScope, difficulty: QuizDifficulty): List<QuizQuestion> {
        return allQuestions.filter { q ->
            q.difficulty == difficulty && (scope.category == null || q.category == scope.category)
        }
    }

    fun getUnseenMatchingQuestions(
        scope: QuizScope,
        difficulty: QuizDifficulty,
        seenQuestionIds: Set<String>
    ): List<QuizQuestion> {
        if (seenQuestionIds.isEmpty()) return getMatchingQuestions(scope, difficulty)
        return allQuestions.filter { q ->
            q.difficulty == difficulty &&
                (scope.category == null || q.category == scope.category) &&
                q.id !in seenQuestionIds
        }
    }

    fun getAvailableQuestionCounts(scope: QuizScope, difficulty: QuizDifficulty): List<Int> {
        val available = getMatchingQuestions(scope, difficulty).size
        return listOf(5, 10, 15).filter { it <= available }
    }

    fun createQuizSession(
        scope: QuizScope,
        difficulty: QuizDifficulty,
        mode: QuizMode,
        requestedCount: Int,
        seenQuestionIds: Set<String> = emptySet(),
        prioritizeQuestionIds: Set<String> = emptySet(),
        random: Random = Random.Default,
        nowEpochMillis: Long = System.currentTimeMillis()
    ): ActiveQuizSession {
        val unseenPool = getUnseenMatchingQuestions(scope, difficulty, seenQuestionIds)
        require(unseenPool.isNotEmpty()) {
            "No unseen questions available for scope=${scope.id}, difficulty=${difficulty.id}"
        }
        val count = requestedCount.coerceAtMost(unseenPool.size)

        val prioritized = if (prioritizeQuestionIds.isNotEmpty()) {
            unseenPool.filter { it.id in prioritizeQuestionIds }.shuffled(random).take(count)
        } else {
            emptyList()
        }
        val remainingNeeded = (count - prioritized.size).coerceAtLeast(0)
        val prioritizedIds = prioritized.map { it.id }.toSet()
        val candidatePool = if (prioritizedIds.isEmpty()) {
            unseenPool
        } else {
            unseenPool.filter { it.id !in prioritizedIds }
        }

        val additionalSelected = if (remainingNeeded == 0) {
            emptyList()
        } else if (scope == QuizScope.MIXED && remainingNeeded >= QuizCategory.entries.size) {
            val byCategory = candidatePool.groupBy { it.category }
                .mapValues { (_, list) -> list.shuffled(random).toMutableList() }
            val picked = mutableListOf<QuizQuestion>()
            val categories = QuizCategory.entries.shuffled(random)
            while (picked.size < remainingNeeded) {
                var addedInRound = false
                for (cat in categories) {
                    val catList = byCategory[cat]
                    if (!catList.isNullOrEmpty() && picked.size < remainingNeeded) {
                        picked.add(catList.removeAt(0))
                        addedInRound = true
                    }
                }
                if (!addedInRound) break
            }
            picked
        } else {
            candidatePool.shuffled(random).take(remainingNeeded)
        }

        val selectedQuestions = (prioritized + additionalSelected)
            .distinctBy { it.id }
            .shuffled(random)

        val sessionQuestions = selectedQuestions.map { q ->
            ActiveSessionQuestion(
                questionId = q.id,
                shuffledOptionIds = q.options.map { it.id }.shuffled(random),
                selectedOptionId = null,
                submittedOptionId = null,
                isSubmitted = false
            )
        }

        return ActiveQuizSession(
            sessionId = UUID.randomUUID().toString(),
            scope = scope,
            difficulty = difficulty,
            mode = mode,
            questions = sessionQuestions,
            currentIndex = 0,
            startedAtEpochMillis = nowEpochMillis,
            challengeArmed = false,
            isFinalized = false
        )
    }

    fun validateQuestionBank(): QuestionBankValidationReport {
        val duplicateIds = allQuestions
            .groupBy { it.id }
            .filter { it.value.size > 1 }
            .keys
            .toList()

        val duplicatePrompts = allQuestions
            .groupBy { "${it.prompt.trim().lowercase()}::${it.codeSnippet?.trim()?.lowercase().orEmpty()}" }
            .filter { it.value.size > 1 }
            .map { it.value.first().id }

        val invalidOptionQuestions = mutableListOf<String>()
        val invalidCorrectRefQuestions = mutableListOf<String>()
        val blankFieldQuestions = mutableListOf<String>()

        for (q in allQuestions) {
            if (q.id.isBlank() || q.prompt.isBlank() || q.explanation.isBlank()) {
                blankFieldQuestions.add(q.id)
            }
            val optionIds = q.options.map { it.id.trim() }
            val optionTexts = q.options.map { it.text.trim() }
            if (q.options.size != 4 ||
                optionIds.toSet().size != 4 ||
                optionTexts.toSet().size != 4 ||
                optionTexts.any { it.isBlank() }
            ) {
                invalidOptionQuestions.add(q.id)
            }
            if (q.correctOptionId !in optionIds) {
                invalidCorrectRefQuestions.add(q.id)
            }
        }

        val categoryCounts = QuizCategory.entries.associateWith { cat ->
            allQuestions.count { it.category == cat }
        }

        val counts = mutableMapOf<Pair<QuizCategory, QuizDifficulty>, Int>()
        for (cat in QuizCategory.entries) {
            for (diff in QuizDifficulty.entries) {
                counts[cat to diff] = allQuestions.count { it.category == cat && it.difficulty == diff }
            }
        }

        val allBucketsHaveAtLeast100 = counts.values.all { it >= 100 }
        val allCategoriesHaveAtLeast300 = categoryCounts.values.all { it >= 300 }
        val isValid = allQuestions.size >= 1500 &&
            allCategoriesHaveAtLeast300 &&
            allBucketsHaveAtLeast100 &&
            duplicateIds.isEmpty() &&
            duplicatePrompts.isEmpty() &&
            invalidOptionQuestions.isEmpty() &&
            invalidCorrectRefQuestions.isEmpty() &&
            blankFieldQuestions.isEmpty()

        return QuestionBankValidationReport(
            isValid = isValid,
            totalQuestions = allQuestions.size,
            categoryCounts = categoryCounts,
            categoryDifficultyCounts = counts,
            duplicateIds = duplicateIds,
            duplicatePrompts = duplicatePrompts,
            invalidOptionQuestions = invalidOptionQuestions,
            invalidCorrectRefQuestions = invalidCorrectRefQuestions,
            blankFieldQuestions = blankFieldQuestions
        )
    }
}
