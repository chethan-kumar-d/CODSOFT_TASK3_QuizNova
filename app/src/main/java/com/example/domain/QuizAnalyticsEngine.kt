package com.example.domain

import com.example.model.AnswerOutcome
import com.example.model.AttemptCompletionStatus
import com.example.model.FinalizedAttemptSummary
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizMode
import com.example.model.QuizScope
import kotlin.math.roundToInt

enum class AnalyticsModeFilter(val id: String, val label: String) {
    ALL("ALL", "All Modes"),
    PRACTICE("PRACTICE", "Practice"),
    CHALLENGE("CHALLENGE", "Challenge")
}

data class CategoryAccuracyStat(
    val category: QuizCategory,
    val totalQuestions: Int,
    val correctCount: Int,
    val incorrectCount: Int,
    val unansweredCount: Int,
    val accuracyPercentage: Int
)

data class RecentAttemptPoint(
    val attemptId: String,
    val label: String,
    val scope: QuizScope,
    val difficulty: QuizDifficulty,
    val mode: QuizMode,
    val percentage: Int,
    val correctCount: Int,
    val totalQuestions: Int,
    val completedAtEpochMillis: Long,
    val completionStatus: AttemptCompletionStatus
)

data class ProgressAnalyticsSnapshot(
    val filter: AnalyticsModeFilter,
    val totalFinalizedAttempts: Int,
    val totalQuestionsAnsweredOrUnanswered: Int,
    val totalCorrectAnswers: Int,
    val totalIncorrectAnswers: Int,
    val totalUnansweredQuestions: Int,
    val overallAccuracyPercentage: Int,
    val bestScorePercentage: Int,
    val practiceAttemptsCount: Int,
    val challengeAttemptsCount: Int,
    val categoryStats: List<CategoryAccuracyStat>,
    val recentPerformance: List<RecentAttemptPoint>,
    val recentTrendAccessibleSummary: String
)

object QuizAnalyticsEngine {

    /**
     * Computes genuine progress analytics from finalized attempts and their per-question records.
     * - Overall accuracy = total correct / total questions across included finalized attempts
     *   (unanswered questions count as 0 marks in the numerator and are included in the denominator).
     * - For Mixed quizzes, each question's answer is attributed to its actual [QuizCategory].
     */
    fun computeAnalytics(
        attempts: List<FinalizedAttemptSummary>,
        filter: AnalyticsModeFilter = AnalyticsModeFilter.ALL
    ): ProgressAnalyticsSnapshot {
        val practiceCount = attempts.count { it.mode == QuizMode.PRACTICE }
        val challengeCount = attempts.count { it.mode == QuizMode.CHALLENGE }

        val filteredAttempts = when (filter) {
            AnalyticsModeFilter.ALL -> attempts
            AnalyticsModeFilter.PRACTICE -> attempts.filter { it.mode == QuizMode.PRACTICE }
            AnalyticsModeFilter.CHALLENGE -> attempts.filter { it.mode == QuizMode.CHALLENGE }
        }.sortedByDescending { it.completedAtEpochMillis }

        val totalAttempts = filteredAttempts.size
        val totalQuestions = filteredAttempts.sumOf { it.totalQuestions }
        val totalCorrect = filteredAttempts.sumOf { it.correctCount }
        val totalIncorrect = filteredAttempts.sumOf { it.incorrectCount }
        val totalUnanswered = filteredAttempts.sumOf { it.unansweredCount }

        val overallAccuracy = if (totalQuestions > 0) {
            ((totalCorrect.toDouble() / totalQuestions.toDouble()) * 100.0).roundToInt()
        } else {
            0
        }

        val bestScore = filteredAttempts.maxOfOrNull { it.percentage } ?: 0

        // Attribute every question record (including questions from Mixed quizzes) to its actual category
        val allAnswerRecords = filteredAttempts.flatMap { it.answers }
        val recordsByCategory = allAnswerRecords.groupBy { it.question.category }

        val categoryStats = QuizCategory.entries.map { category ->
            val records = recordsByCategory[category].orEmpty()
            val catTotal = records.size
            val catCorrect = records.count { it.outcome == AnswerOutcome.CORRECT }
            val catIncorrect = records.count { it.outcome == AnswerOutcome.INCORRECT }
            val catUnanswered = records.count { it.outcome == AnswerOutcome.UNANSWERED }
            val catAccuracy = if (catTotal > 0) {
                ((catCorrect.toDouble() / catTotal.toDouble()) * 100.0).roundToInt()
            } else {
                0
            }
            CategoryAccuracyStat(
                category = category,
                totalQuestions = catTotal,
                correctCount = catCorrect,
                incorrectCount = catIncorrect,
                unansweredCount = catUnanswered,
                accuracyPercentage = catAccuracy
            )
        }

        val recentChronological = filteredAttempts
            .take(8)
            .reversed()
            .mapIndexed { idx, attempt ->
                RecentAttemptPoint(
                    attemptId = attempt.attemptId,
                    label = "#${idx + 1}",
                    scope = attempt.scope,
                    difficulty = attempt.difficulty,
                    mode = attempt.mode,
                    percentage = attempt.percentage,
                    correctCount = attempt.correctCount,
                    totalQuestions = attempt.totalQuestions,
                    completedAtEpochMillis = attempt.completedAtEpochMillis,
                    completionStatus = attempt.completionStatus
                )
            }

        val accessibleSummary = if (recentChronological.isEmpty()) {
            "No completed attempts recorded for ${filter.label.lowercase()} yet."
        } else {
            val parts = recentChronological.joinToString("; ") { pt ->
                "${pt.scope.displayName} (${pt.mode.title}): ${pt.percentage}% (${pt.correctCount}/${pt.totalQuestions})"
            }
            "Recent ${recentChronological.size} attempts from oldest to newest: $parts."
        }

        return ProgressAnalyticsSnapshot(
            filter = filter,
            totalFinalizedAttempts = totalAttempts,
            totalQuestionsAnsweredOrUnanswered = totalQuestions,
            totalCorrectAnswers = totalCorrect,
            totalIncorrectAnswers = totalIncorrect,
            totalUnansweredQuestions = totalUnanswered,
            overallAccuracyPercentage = overallAccuracy,
            bestScorePercentage = bestScore,
            practiceAttemptsCount = practiceCount,
            challengeAttemptsCount = challengeCount,
            categoryStats = categoryStats,
            recentPerformance = recentChronological,
            recentTrendAccessibleSummary = accessibleSummary
        )
    }
}
