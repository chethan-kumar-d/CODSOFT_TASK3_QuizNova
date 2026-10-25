package com.example

import com.example.data.local.PreferencesAndSessionStore
import com.example.data.questions.QuestionBank
import com.example.domain.AnalyticsModeFilter
import com.example.domain.QuizAnalyticsEngine
import com.example.domain.QuizScoringEngine
import com.example.model.AnswerOutcome
import com.example.model.AttemptCompletionStatus
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizMode
import com.example.model.QuizScope
import com.example.ui.screens.buildPlainTextShareSummary
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.random.Random

class ExampleUnitTest {

    @Test
    fun questionBank_has1500UniqueValidQuestions_300PerCategory_100PerDifficulty_andPreservesOriginalIds() {
        val report = QuestionBank.validateQuestionBank()
        assertTrue(
            "Question bank validation failed: dupIds=${report.duplicateIds}, dupPrompts=${report.duplicatePrompts.take(5)}, " +
                "invalidOpts=${report.invalidOptionQuestions}, invalidCorrect=${report.invalidCorrectRefQuestions}, " +
                "blank=${report.blankFieldQuestions}",
            report.isValid
        )
        assertEquals(1500, report.totalQuestions)
        assertTrue(report.duplicateIds.isEmpty())
        assertTrue(report.duplicatePrompts.isEmpty())
        assertTrue(report.invalidOptionQuestions.isEmpty())
        assertTrue(report.invalidCorrectRefQuestions.isEmpty())
        assertTrue(report.blankFieldQuestions.isEmpty())

        for (category in QuizCategory.entries) {
            val categoryTotal = QuestionBank.getQuestionsForCategory(category).size
            assertEquals("Expected 300 questions for $category", 300, categoryTotal)

            for (difficulty in QuizDifficulty.entries) {
                val count = report.categoryDifficultyCounts[category to difficulty] ?: 0
                assertEquals(
                    "Expected 100 questions for $category - $difficulty",
                    100,
                    count
                )
            }
        }

        // Verify all 225 original question IDs (_01 to _15 in each bucket) are preserved for historical attempt compatibility
        val prefixes = listOf(
            "py_f", "py_a", "py_x",
            "jv_f", "jv_a", "jv_x",
            "sql_f", "sql_a", "sql_x",
            "cs_f", "cs_a", "cs_x",
            "lr_f", "lr_a", "lr_x"
        )
        for (prefix in prefixes) {
            for (i in 1..15) {
                val id = "%s_%02d".format(prefix, i)
                assertNotNull("Expected original question ID $id to be preserved", QuestionBank.getQuestionById(id))
            }
        }
    }

    @Test
    fun createQuizSession_excludesSeenQuestions_sharesSeenAcrossCategoryAndMixed_andPrioritizesRemainingUnseenOnNewCycle() {
        val pythonAppliedPool = QuestionBank.getMatchingQuestions(QuizScope.PYTHON, QuizDifficulty.APPLIED)
        assertEquals(100, pythonAppliedPool.size)

        // Mark 90 Python Applied questions as seen
        val seenIds = pythonAppliedPool.take(90).map { it.id }.toSet()
        val remainingUnseenIds = pythonAppliedPool.drop(90).map { it.id }.toSet()
        assertEquals(10, remainingUnseenIds.size)

        // A 10-question Python Applied quiz must select exclusively the 10 remaining unseen questions
        val session = QuestionBank.createQuizSession(
            scope = QuizScope.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.PRACTICE,
            requestedCount = 10,
            seenQuestionIds = seenIds,
            random = Random(123)
        )
        val selectedIds = session.questions.map { it.questionId }.toSet()
        assertEquals(10, selectedIds.size)
        assertEquals(remainingUnseenIds, selectedIds)

        // Mixed Applied pool (500 total) must also exclude those 90 seen Python Applied questions
        val unseenMixedApplied = QuestionBank.getUnseenMatchingQuestions(
            scope = QuizScope.MIXED,
            difficulty = QuizDifficulty.APPLIED,
            seenQuestionIds = seenIds
        )
        assertEquals(410, unseenMixedApplied.size)
        assertTrue(unseenMixedApplied.none { it.id in seenIds })

        // When starting a new cycle with 3 leftover unseen questions prioritized for a 10-question quiz,
        // all 3 prioritized unseen questions must be included alongside 7 fresh questions from the reset pool
        val prioritizedThree = pythonAppliedPool.takeLast(3).map { it.id }.toSet()
        val newCycleSession = QuestionBank.createQuizSession(
            scope = QuizScope.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.PRACTICE,
            requestedCount = 10,
            seenQuestionIds = emptySet(),
            prioritizeQuestionIds = prioritizedThree,
            random = Random(456)
        )
        val newCycleIds = newCycleSession.questions.map { it.questionId }.toSet()
        assertEquals(10, newCycleIds.size)
        assertTrue(newCycleIds.containsAll(prioritizedThree))
    }

    @Test
    fun createQuizSession_shufflesOptionsAndPreservesCorrectOptionMappingWithoutRepeats() {
        for (seed in 1..10) {
            val session = QuestionBank.createQuizSession(
                scope = QuizScope.MIXED,
                difficulty = QuizDifficulty.APPLIED,
                mode = QuizMode.PRACTICE,
                requestedCount = 15,
                random = Random(seed)
            )
            assertEquals(15, session.questions.size)
            // Never repeat a question within one attempt
            val distinctIds = session.questions.map { it.questionId }.toSet()
            assertEquals(15, distinctIds.size)

            // Every shuffled question still maps its correctOptionId to the exact original correct option text
            session.questions.forEach { sq ->
                val q = QuestionBank.getQuestionById(sq.questionId)
                assertNotNull(q)
                assertEquals(4, sq.shuffledOptionIds.toSet().size)
                assertTrue(q!!.correctOptionId in sq.shuffledOptionIds)
            }
        }
    }

    @Test
    fun scoringEngine_locksAnswerAfterSubmit_preventsDuplicateSubmission_andTreatsSelectedUnsubmittedAsUnanswered() {
        var session = QuestionBank.createQuizSession(
            scope = QuizScope.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.CHALLENGE,
            requestedCount = 5,
            random = Random(42)
        )

        // Q1: Select and submit the correct option
        val q1 = QuestionBank.getQuestionById(session.questions[0].questionId)!!
        session = QuizScoringEngine.selectOption(session, q1.correctOptionId)
        assertFalse(session.questions[0].isSubmitted)
        session = QuizScoringEngine.submitCurrentAnswer(session)
        assertTrue(session.questions[0].isSubmitted)
        assertEquals(q1.correctOptionId, session.questions[0].submittedOptionId)

        // Attempt to change selection or re-submit after submission -> locked!
        val wrongOptionQ1 = q1.options.first { it.id != q1.correctOptionId }.id
        val afterLockedSelect = QuizScoringEngine.selectOption(session, wrongOptionQ1)
        assertEquals(session, afterLockedSelect)
        val afterDuplicateSubmit = QuizScoringEngine.submitCurrentAnswer(session)
        assertEquals(session, afterDuplicateSubmit)

        // Advance to Q2: Select an incorrect option and submit
        session = QuizScoringEngine.advanceToNextQuestion(session)
        assertEquals(1, session.currentIndex)
        val q2 = QuestionBank.getQuestionById(session.questions[1].questionId)!!
        val wrongOptionQ2 = q2.options.first { it.id != q2.correctOptionId }.id
        session = QuizScoringEngine.selectOption(session, wrongOptionQ2)
        session = QuizScoringEngine.submitCurrentAnswer(session)

        // Advance to Q3: Select the correct option, but DO NOT tap Submit!
        session = QuizScoringEngine.advanceToNextQuestion(session)
        assertEquals(2, session.currentIndex)
        val q3 = QuestionBank.getQuestionById(session.questions[2].questionId)!!
        session = QuizScoringEngine.selectOption(session, q3.correctOptionId)
        assertFalse(session.questions[2].isSubmitted)
        assertNull(session.questions[2].submittedOptionId)

        // Finalize session (e.g., Challenge focus loss)
        val (_, summary) = QuizScoringEngine.evaluateSession(
            session = session,
            completionStatus = AttemptCompletionStatus.AUTO_SUBMITTED_FOCUS_LOSS
        )

        assertEquals(5, summary.totalQuestions)
        assertEquals(1, summary.correctCount)
        assertEquals(1, summary.incorrectCount)
        assertEquals(3, summary.unansweredCount) // Q3 (selected but unsubmitted), Q4, Q5
        assertEquals(20, summary.percentage) // 1 / 5 = 20%
        assertEquals(AnswerOutcome.CORRECT, summary.answers[0].outcome)
        assertEquals(AnswerOutcome.INCORRECT, summary.answers[1].outcome)
        assertEquals(AnswerOutcome.UNANSWERED, summary.answers[2].outcome)
    }

    @Test
    fun sessionPayloadSerialization_roundTripsAllSessionQuestionStates() {
        var session = QuestionBank.createQuizSession(
            scope = QuizScope.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            mode = QuizMode.PRACTICE,
            requestedCount = 5,
            random = Random(99)
        )
        val q1 = QuestionBank.getQuestionById(session.questions[0].questionId)!!
        session = QuizScoringEngine.selectOption(session, q1.correctOptionId)
        session = QuizScoringEngine.submitCurrentAnswer(session)
        session = QuizScoringEngine.advanceToNextQuestion(session)
        val q2 = QuestionBank.getQuestionById(session.questions[1].questionId)!!
        session = QuizScoringEngine.selectOption(session, q2.options.first().id)

        val encoded = PreferencesAndSessionStore.encodeQuestionsPayload(session.questions)
        val decoded = PreferencesAndSessionStore.decodeQuestionsPayload(encoded)

        assertEquals(session.questions, decoded)
    }

    @Test
    fun analyticsEngine_attributesMixedQuizQuestionsToActualCategories_andComputesOverallAccuracy() {
        // Create a Mixed Quiz session of 5 questions
        var mixedSession = QuestionBank.createQuizSession(
            scope = QuizScope.MIXED,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.PRACTICE,
            requestedCount = 5,
            random = Random(7)
        )
        // Answer first 3 correctly, leave 2 unanswered
        for (i in 0 until 3) {
            val q = QuestionBank.getQuestionById(mixedSession.questions[i].questionId)!!
            mixedSession = QuizScoringEngine.selectOption(mixedSession, q.correctOptionId)
            mixedSession = QuizScoringEngine.submitCurrentAnswer(mixedSession)
            if (i < 2) {
                mixedSession = QuizScoringEngine.advanceToNextQuestion(mixedSession)
            }
        }
        val (_, mixedSummary) = QuizScoringEngine.evaluateSession(
            session = mixedSession,
            completionStatus = AttemptCompletionStatus.COMPLETED_NORMALLY
        )

        val snapshot = QuizAnalyticsEngine.computeAnalytics(
            attempts = listOf(mixedSummary),
            filter = AnalyticsModeFilter.ALL
        )

        assertEquals(1, snapshot.totalFinalizedAttempts)
        assertEquals(5, snapshot.totalQuestionsAnsweredOrUnanswered)
        assertEquals(3, snapshot.totalCorrectAnswers)
        assertEquals(2, snapshot.totalUnansweredQuestions)
        assertEquals(60, snapshot.overallAccuracyPercentage)
        assertEquals(60, snapshot.bestScorePercentage)

        // Sum of per-category questions across the 5 categories must equal the 5 questions of the Mixed Quiz
        val attributedCategoryTotal = snapshot.categoryStats.sumOf { it.totalQuestions }
        val attributedCategoryCorrect = snapshot.categoryStats.sumOf { it.correctCount }
        assertEquals(5, attributedCategoryTotal)
        assertEquals(3, attributedCategoryCorrect)

        // Verify Share summary text
        val shareText = buildPlainTextShareSummary(mixedSummary)
        assertTrue(shareText.contains("QuizNova"))
        assertTrue(shareText.contains("3 / 5 (60%)"))
    }
}
