package com.example

import android.content.Context
import android.view.WindowManager
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToNode
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.QuizRepository
import com.example.data.local.PreferencesAndSessionStore
import com.example.data.local.QuizDatabase
import com.example.data.questions.QuestionBank
import com.example.domain.QuizScoringEngine
import com.example.model.AttemptCompletionStatus
import com.example.model.QuizDifficulty
import com.example.model.QuizMode
import com.example.model.QuizScope
import com.example.model.ThemePreference
import com.example.viewmodel.QuizNovaScreen
import com.example.viewmodel.QuizNovaViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import java.io.File

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var database: QuizDatabase
    private lateinit var tempFile: File

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, QuizDatabase::class.java)
            .allowMainThreadQueries()
            .setQueryExecutor { it.run() }
            .setTransactionExecutor { it.run() }
            .build()
        tempFile = File.createTempFile("quiznova_test_prefs_${System.nanoTime()}", ".preferences_pb")
    }

    @After
    fun tearDown() {
        Shadows.shadowOf(android.os.Looper.getMainLooper()).idle()
        database.close()
        if (::tempFile.isInitialized && tempFile.exists()) {
            tempFile.delete()
        }
    }

    private fun createIsolatedRepository(): Pair<QuizRepository, PreferencesAndSessionStore> {
        val ds = PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.Unconfined + SupervisorJob()),
            produceFile = { tempFile }
        )
        val store = PreferencesAndSessionStore(ds)
        return QuizRepository(database.quizDao(), store) to store
    }

    @Test
    fun repository_savesFinalizedAttemptExactlyOnce_andPreventsDuplicates() = runBlocking {
        val (repo, _) = createIsolatedRepository()
        var session = QuestionBank.createQuizSession(
            scope = QuizScope.JAVA,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.PRACTICE,
            requestedCount = 5
        )
        val q0 = QuestionBank.getQuestionById(session.questions[0].questionId)!!
        session = QuizScoringEngine.selectOption(session, q0.correctOptionId)
        session = QuizScoringEngine.submitCurrentAnswer(session)

        val firstSummary = repo.finalizeAndPersistSession(
            session = session,
            completionStatus = AttemptCompletionStatus.COMPLETED_NORMALLY
        )
        val duplicateSummary = repo.finalizeAndPersistSession(
            session = session,
            completionStatus = AttemptCompletionStatus.AUTO_SUBMITTED_FOCUS_LOSS
        )

        assertEquals(firstSummary.attemptId, duplicateSummary.attemptId)
        assertEquals(AttemptCompletionStatus.COMPLETED_NORMALLY, duplicateSummary.completionStatus)

        val storedAttempts = repo.allFinalizedAttemptsFlow.first()
        assertEquals(1, storedAttempts.size)
        assertEquals(1, storedAttempts.first().correctCount)
        assertEquals(4, storedAttempts.first().unansweredCount)
        assertNull(repo.getActiveSessionSnapshot())
    }

    @Test
    fun repetitionControl_marksSeenOnlyWhenDisplayed_sharesAcrossMixed_persistsAcrossRestarts_andHandlesPoolExhaustionAndNewCycle() = runBlocking {
        val (repo, store) = createIsolatedRepository()
        val vm = QuizNovaViewModel(repo)
        vm.performStartupSessionCheck()

        // 1. Start a 5-question Python Applied Practice quiz
        vm.openQuizSetup(
            scope = QuizScope.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.PRACTICE
        )
        assertEquals(100, vm.uiState.value.unseenMatchingPoolSize)
        vm.updateSetupQuestionCount(5)
        vm.requestStartFromSetup(isInMultiWindowMode = false)
        assertTrue(vm.currentScreen.value is QuizNovaScreen.ActiveQuiz)

        val active = vm.uiState.value.activeSession!!
        assertEquals(5, active.questions.size)
        val q0Id = active.questions[0].questionId
        val q1Id = active.questions[1].questionId
        val q2Id = active.questions[2].questionId
        val q3Id = active.questions[3].questionId
        val q4Id = active.questions[4].questionId

        // ONLY Q0 (index 0) is displayed initially -> only Q0 is marked seen!
        assertEquals(setOf(q0Id), vm.uiState.value.seenQuestionIds)
        assertFalse(q1Id in vm.uiState.value.seenQuestionIds)
        assertFalse(q2Id in vm.uiState.value.seenQuestionIds)

        // Submit Q0 and advance to Q1 -> now Q0 and Q1 are marked seen, while Q2..Q4 remain unseen
        val q0Obj = QuestionBank.getQuestionById(q0Id)!!
        vm.selectOption(q0Obj.correctOptionId)
        vm.submitCurrentAnswer()
        vm.nextQuestionOrFinish()
        assertEquals(setOf(q0Id, q1Id), vm.uiState.value.seenQuestionIds)
        assertFalse(q2Id in vm.uiState.value.seenQuestionIds)
        assertFalse(q3Id in vm.uiState.value.seenQuestionIds)
        assertFalse(q4Id in vm.uiState.value.seenQuestionIds)

        // Abandon the Practice quiz after viewing Q1 -> Q2, Q3, Q4 were never displayed and stay unseen!
        vm.requestAbandonOrExitQuiz()
        vm.confirmAbandonOrEndQuiz()
        assertEquals(setOf(q0Id, q1Id), store.getSeenQuestionIdsSnapshot())

        // 2. Simulate app restart by creating a new ViewModel over the same repository/DataStore
        val vmAfterRestart = QuizNovaViewModel(repo)
        vmAfterRestart.performStartupSessionCheck()
        assertEquals(setOf(q0Id, q1Id), vmAfterRestart.uiState.value.seenQuestionIds)

        // Verify Mixed Quiz shares the exact same seen-question records (500 total Applied - 2 seen = 498 unseen)
        vmAfterRestart.openQuizSetup(
            scope = QuizScope.MIXED,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.PRACTICE
        )
        assertEquals(498, vmAfterRestart.uiState.value.unseenMatchingPoolSize)

        // 3. Test Pool Exhaustion -> Offer Shorter Quiz or Start New Cycle
        // Mark 96 of the 100 Python Applied questions as seen (4 unseen remain), plus 1 Java Applied question
        val pythonAppliedIds = QuestionBank.getMatchingQuestions(QuizScope.PYTHON, QuizDifficulty.APPLIED).map { it.id }
        val javaAppliedId = QuestionBank.getMatchingQuestions(QuizScope.JAVA, QuizDifficulty.APPLIED).first().id
        val ninetySixSeen = pythonAppliedIds.take(96).toSet()
        val fourRemainingUnseen = pythonAppliedIds.drop(96).toSet()
        store.resetSeenQuestionsForPool(pythonAppliedIds.toSet())
        store.markQuestionsSeen(ninetySixSeen + javaAppliedId)

        // Also record a completed attempt and custom preferences to verify new cycle never deletes them
        val sampleSession = QuestionBank.createQuizSession(
            scope = QuizScope.SQL,
            difficulty = QuizDifficulty.FOUNDATION,
            mode = QuizMode.PRACTICE,
            requestedCount = 5
        )
        repo.finalizeAndPersistSession(sampleSession, AttemptCompletionStatus.COMPLETED_NORMALLY)
        vmAfterRestart.setThemePreference(ThemePreference.LIGHT)
        vmAfterRestart.setReduceMotion(true)
        vmAfterRestart.performStartupSessionCheck()

        // Request a 10-question Python Applied quiz when only 4 unseen remain -> must show PoolExhaustionPrompt!
        vmAfterRestart.openQuizSetup(
            scope = QuizScope.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.PRACTICE
        )
        assertEquals(4, vmAfterRestart.uiState.value.unseenMatchingPoolSize)
        vmAfterRestart.updateSetupQuestionCount(10)
        vmAfterRestart.requestStartFromSetup(isInMultiWindowMode = false)

        // Must NOT start quiz silently; must populate poolExhaustionPrompt
        assertTrue(vmAfterRestart.currentScreen.value is QuizNovaScreen.Setup)
        val prompt = vmAfterRestart.uiState.value.poolExhaustionPrompt
        assertNotNull(prompt)
        assertEquals(4, prompt!!.unseenCount)
        assertEquals(10, prompt.requestedCount)

        // Option A: Choose Shorter Quiz (4 questions) -> launches a 4-question quiz with the 4 unseen questions
        vmAfterRestart.confirmShorterQuizFromExhaustion()
        assertNull(vmAfterRestart.uiState.value.poolExhaustionPrompt)
        assertTrue(vmAfterRestart.currentScreen.value is QuizNovaScreen.ActiveQuiz)
        val shorterSession = vmAfterRestart.uiState.value.activeSession!!
        assertEquals(4, shorterSession.questions.size)
        assertEquals(fourRemainingUnseen, shorterSession.questions.map { it.questionId }.toSet())

        // Abandon the shorter quiz after viewing its first question (so 3 unseen remain in Python Applied)
        vmAfterRestart.confirmAbandonOrEndQuiz()
        assertEquals(3, QuestionBank.getUnseenMatchingQuestions(
            QuizScope.PYTHON,
            QuizDifficulty.APPLIED,
            vmAfterRestart.uiState.value.seenQuestionIds
        ).size)

        // Now request a 10-question Python Applied quiz again (3 unseen remain) and choose Start New Cycle
        vmAfterRestart.openQuizSetup(
            scope = QuizScope.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.PRACTICE
        )
        vmAfterRestart.updateSetupQuestionCount(10)
        vmAfterRestart.requestStartFromSetup(isInMultiWindowMode = false)
        assertNotNull(vmAfterRestart.uiState.value.poolExhaustionPrompt)
        assertEquals(3, vmAfterRestart.uiState.value.poolExhaustionPrompt!!.unseenCount)

        val remainingThreeBeforeReset = QuestionBank.getUnseenMatchingQuestions(
            QuizScope.PYTHON,
            QuizDifficulty.APPLIED,
            vmAfterRestart.uiState.value.seenQuestionIds
        ).map { it.id }.toSet()

        // Option B: Confirm Start New Cycle -> resets Python Applied rotation, prioritizes the 3 remaining unseen,
        // starts the 10-question quiz, and preserves history, scores, preferences, and other categories' seen IDs!
        vmAfterRestart.confirmStartNewCycleFromExhaustion()
        assertNull(vmAfterRestart.uiState.value.poolExhaustionPrompt)
        assertTrue(vmAfterRestart.currentScreen.value is QuizNovaScreen.ActiveQuiz)
        val newCycleSession = vmAfterRestart.uiState.value.activeSession!!
        assertEquals(10, newCycleSession.questions.size)
        assertTrue(newCycleSession.questions.map { it.questionId }.toSet().containsAll(remainingThreeBeforeReset))

        // Only the first displayed question of the new Python Applied cycle + the unrelated Java Applied question are seen now
        val firstNewCycleQ = newCycleSession.questions.first().questionId
        assertEquals(setOf(firstNewCycleQ, javaAppliedId), vmAfterRestart.uiState.value.seenQuestionIds)

        // Verify history, scores, and preferences were preserved intact
        Shadows.shadowOf(android.os.Looper.getMainLooper()).idle()
        assertEquals(1, repo.allFinalizedAttemptsFlow.first().size)
        assertEquals(1, vmAfterRestart.uiState.value.historyAttempts.size)
        assertEquals(ThemePreference.LIGHT, vmAfterRestart.uiState.value.userPreferences.themePreference)
        assertTrue(vmAfterRestart.uiState.value.userPreferences.reduceMotion)
    }

    @Test
    fun challengeMode_rotationDoesNotAutoSubmit_butFocusLossAutoSubmitsWithSelectedUnsubmittedAsZero() = runBlocking {
        val (repo, _) = createIsolatedRepository()
        val vm = QuizNovaViewModel(repo)
        vm.performStartupSessionCheck()

        // Configure Challenge Mode
        vm.openQuizSetup(
            scope = QuizScope.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.CHALLENGE
        )
        vm.updateSetupQuestionCount(5)

        // Multi-window mode must reject starting Challenge
        vm.requestStartFromSetup(isInMultiWindowMode = true)
        assertNotNull(vm.uiState.value.setupConfig.multiWindowRejectionMessage)
        assertTrue(vm.currentScreen.value is QuizNovaScreen.Setup)

        // Normal full-screen Challenge start -> shows consent dialog, then confirm
        vm.requestStartFromSetup(isInMultiWindowMode = false)
        assertTrue(vm.uiState.value.setupConfig.showChallengeConsentDialog)
        vm.confirmBeginChallenge(isInMultiWindowMode = false)
        assertTrue(vm.currentScreen.value is QuizNovaScreen.ActiveQuiz)

        // Arm Challenge monitoring once screen is visible and focused
        vm.onChallengeQuizVisibleAndFocused()
        assertTrue(vm.uiState.value.activeSession?.challengeArmed == true)

        // Submit Q1 correctly
        val s1 = vm.uiState.value.activeSession!!
        val q1 = QuestionBank.getQuestionById(s1.questions[0].questionId)!!
        vm.selectOption(q1.correctOptionId)
        vm.submitCurrentAnswer()
        vm.nextQuestionOrFinish()

        // On Q2: select correct option, but DO NOT tap Submit
        val s2 = vm.uiState.value.activeSession!!
        val q2 = QuestionBank.getQuestionById(s2.questions[1].questionId)!!
        vm.selectOption(q2.correctOptionId)
        assertFalse(vm.uiState.value.activeSession!!.questions[1].isSubmitted)

        // Simulate device rotation (isChangingConfigurations = true) -> MUST NOT auto-submit!
        vm.onChallengeFocusOrForegroundLost(isChangingConfigurations = true)
        assertTrue(vm.currentScreen.value is QuizNovaScreen.ActiveQuiz)
        assertNotNull(vm.uiState.value.activeSession)

        // Simulate genuine focus loss / backgrounding (isChangingConfigurations = false) -> auto-submits once!
        vm.onChallengeFocusOrForegroundLost(isChangingConfigurations = false)
        Shadows.shadowOf(android.os.Looper.getMainLooper()).idle()
        assertTrue(vm.currentScreen.value is QuizNovaScreen.Results)
        assertNull(vm.uiState.value.activeSession)

        val result = vm.uiState.value.latestResultSummary
        assertNotNull(result)
        assertEquals(AttemptCompletionStatus.AUTO_SUBMITTED_FOCUS_LOSS, result!!.completionStatus)
        assertEquals(
            "Automatically submitted because the app lost focus.",
            result.completionStatus.bannerMessage
        )
        assertEquals(1, result.correctCount) // Q1 only; Q2 was selected but not submitted
        assertEquals(4, result.unansweredCount)
        assertEquals(20, result.percentage)
    }

    @Test
    fun interruptedChallengeOnNextLaunch_isFinalizedAsEnded_whilePracticeSessionIsRestoredWithExactOrder() = runBlocking {
        val (repo, store) = createIsolatedRepository()

        // 1. Save an unfinalized Challenge session to DataStore (simulating unexpected process termination)
        val challengeSession = QuestionBank.createQuizSession(
            scope = QuizScope.SQL,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.CHALLENGE,
            requestedCount = 5
        )
        store.saveActiveSession(challengeSession)

        // Creating a new ViewModel on launch must finalize the interrupted Challenge
        val vmAfterChallengeKill = QuizNovaViewModel(repo)
        vmAfterChallengeKill.performStartupSessionCheck()
        val interruptedBanner = vmAfterChallengeKill.uiState.value.interruptedChallengeBannerAttempt
        assertNotNull(interruptedBanner)
        assertEquals(AttemptCompletionStatus.ENDED_INTERRUPTED_SESSION, interruptedBanner!!.completionStatus)
        assertNull(vmAfterChallengeKill.uiState.value.activeSession)
        assertEquals(1, repo.allFinalizedAttemptsFlow.first().size)

        // 2. Save an active Practice session to DataStore (simulating app switch / recreation)
        var practiceSession = QuestionBank.createQuizSession(
            scope = QuizScope.COMPUTER_FUNDAMENTALS,
            difficulty = QuizDifficulty.FOUNDATION,
            mode = QuizMode.PRACTICE,
            requestedCount = 5
        )
        val originalQuestionOrder = practiceSession.questions.map { it.questionId }
        val originalOptionOrders = practiceSession.questions.map { it.shuffledOptionIds }
        val q0 = QuestionBank.getQuestionById(practiceSession.questions[0].questionId)!!
        practiceSession = QuizScoringEngine.selectOption(practiceSession, q0.correctOptionId)
        practiceSession = QuizScoringEngine.submitCurrentAnswer(practiceSession)
        practiceSession = QuizScoringEngine.advanceToNextQuestion(practiceSession)
        store.saveActiveSession(practiceSession)

        val vmRestoredPractice = QuizNovaViewModel(repo)
        assertTrue(vmRestoredPractice.currentScreen.value is QuizNovaScreen.Welcome)
        vmRestoredPractice.performStartupSessionCheck()
        val restored = vmRestoredPractice.uiState.value.activeSession
        assertNotNull(restored)
        assertEquals(practiceSession.sessionId, restored!!.sessionId)
        assertEquals(1, restored.currentIndex)
        assertEquals(1, restored.submittedCount)
        assertEquals(originalQuestionOrder, restored.questions.map { it.questionId })
        assertEquals(originalOptionOrders, restored.questions.map { it.shuffledOptionIds })

        // Verify resuming an active quiz after Activity recreation restores directly to ActiveQuiz without showing Welcome
        vmRestoredPractice.onActivityRestored(welcomeCompleted = true, wasInActiveQuiz = true)
        assertTrue(vmRestoredPractice.currentScreen.value is QuizNovaScreen.ActiveQuiz)
        // Re-running startup check must not interrupt the active quiz or revert to Welcome
        vmRestoredPractice.performStartupSessionCheck()
        assertTrue(vmRestoredPractice.currentScreen.value is QuizNovaScreen.ActiveQuiz)
    }

    @Test
    fun fullCuj_homeToSetup_practiceQuiz_results_review_andFlagSecureScope() {
        composeTestRule.waitForIdle()
        val activity = composeTestRule.activity

        // 0. Verify Welcome screen appears first on a fresh app launch without bottom nav or categories
        composeTestRule.onNodeWithTag("welcome_screen").assertIsDisplayed()
        composeTestRule.onNodeWithTag("welcome_app_title").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithText("Challenge your mind.").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithText("Learn. Practice. Improve.").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithTag("welcome_get_started_button").performScrollTo().assertIsDisplayed()
        composeTestRule.onAllNodes(hasTestTag("nav_tab_home")).fetchSemanticsNodes().let { nodes ->
            assertTrue("Expected no bottom navigation on Welcome screen", nodes.isEmpty())
        }
        composeTestRule.onAllNodes(hasText("Categories")).fetchSemanticsNodes().let { nodes ->
            assertTrue("Expected no category list on Welcome screen", nodes.isEmpty())
        }

        // Tap Get Started to enter the Home dashboard
        composeTestRule.onNodeWithTag("welcome_get_started_button").performScrollTo().performClick()
        composeTestRule.waitForIdle()
        assertTrue(activity.viewModel.currentScreen.value is QuizNovaScreen.Home)

        // 1. Verify redesigned Home screen starts at top with hero visible, concise empty state, 4 bottom tabs, and no FLAG_SECURE
        composeTestRule.onNodeWithText("Challenge your mind.").assertIsDisplayed()
        composeTestRule.onNodeWithTag("start_quiz_button").assertIsDisplayed()
        composeTestRule.onNodeWithTag("random_quiz_button").assertIsDisplayed()
        composeTestRule.onNodeWithTag("home_lazy_column")
            .performScrollToNode(hasText("Complete a quiz to see your progress."))
        composeTestRule.onNodeWithText("Complete a quiz to see your progress.").assertIsDisplayed()
        composeTestRule.onNodeWithTag("home_lazy_column")
            .performScrollToNode(hasTestTag("configure_mixed_quiz_button"))
        composeTestRule.onNodeWithText("Categories").assertIsDisplayed()
        composeTestRule.onNodeWithTag("configure_mixed_quiz_button").assertIsDisplayed()
        composeTestRule.onNodeWithTag("nav_tab_home").assertIsDisplayed()
        composeTestRule.onNodeWithTag("nav_tab_progress").assertIsDisplayed()
        composeTestRule.onNodeWithTag("nav_tab_history").assertIsDisplayed()
        composeTestRule.onNodeWithTag("nav_tab_settings").assertIsDisplayed()

        val homeFlags = activity.window.attributes.flags
        assertEquals(0, homeFlags and WindowManager.LayoutParams.FLAG_SECURE)

        // 2. Navigate to Setup and verify compact sections (Category, Difficulty, Questions 5/10/15, unseen badge, Mode)
        composeTestRule.onNodeWithTag("home_lazy_column")
            .performScrollToNode(hasTestTag("start_quiz_button"))
        composeTestRule.onNodeWithTag("start_quiz_button").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("quiz_setup_screen").assertIsDisplayed()
        composeTestRule.onNodeWithTag("setup_unseen_pool_badge").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithText("Learn at your own pace.").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithText("Leaving the app ends the attempt.").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithTag("setup_count_5").performScrollTo().performClick()
        composeTestRule.onNodeWithTag("launch_configured_quiz_button").performScrollTo().performClick()
        composeTestRule.waitForIdle()

        // 3. Complete all 5 questions in Practice Mode
        for (step in 1..5) {
            composeTestRule.onNodeWithText("Question $step of 5").performScrollTo().assertIsDisplayed()
            // Submit button must be disabled before selecting an option
            composeTestRule.onNodeWithTag("submit_answer_button").performScrollTo().assertIsNotEnabled()

            // Select Option A
            composeTestRule.onNodeWithTag("option_card_0").performScrollTo().performClick()
            composeTestRule.waitForIdle()
            composeTestRule.onNodeWithTag("submit_answer_button").performScrollTo().assertIsEnabled()

            // Tap Submit
            composeTestRule.onNodeWithTag("submit_answer_button").performScrollTo().performClick()
            composeTestRule.waitForIdle()

            // Immediate feedback & explanation card is displayed
            composeTestRule.onNodeWithTag("answer_feedback_card").performScrollTo().assertIsDisplayed()

            val nextTag = if (step == 5) "view_results_button" else "next_question_button"
            composeTestRule.onNodeWithTag(nextTag).performScrollTo().performClick()
            composeTestRule.waitForIdle()
        }

        // 4. Verify Results screen & Review Answers
        composeTestRule.onNodeWithTag("results_screen").assertIsDisplayed()
        composeTestRule.onNodeWithTag("review_answers_button").performScrollTo().performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("answer_review_screen").assertIsDisplayed()
        composeTestRule.onNodeWithTag("review_back_button").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("results_home_button").performScrollTo().performClick()
        composeTestRule.waitForIdle()

        // 5. Verify Settings & Privacy expandable sections and compact About section
        composeTestRule.onNodeWithTag("nav_tab_settings").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("settings_privacy_screen").assertIsDisplayed()
        composeTestRule.onNodeWithTag("settings_privacy_screen")
            .performScrollToNode(hasTestTag("privacy_section_limitations"))
        composeTestRule.onNodeWithTag("privacy_section_limitations").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText(
            "Screenshots are restricted during Challenge mode where supported",
            substring = true
        ).assertIsDisplayed()
        composeTestRule.onNodeWithTag("settings_privacy_screen")
            .performScrollToNode(hasText("Developed by Chethan Kumar D"))
        composeTestRule.onNodeWithText("Developed by Chethan Kumar D").assertIsDisplayed()

        // 6. Verify FLAG_SECURE is applied ONLY during active Challenge quiz and removed afterward
        activity.viewModel.openQuizSetup(
            scope = QuizScope.PYTHON,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.CHALLENGE
        )
        activity.viewModel.confirmBeginChallenge(isInMultiWindowMode = false)
        composeTestRule.waitForIdle()
        val challengeFlags = activity.window.attributes.flags
        assertTrue(
            "Expected FLAG_SECURE during active Challenge quiz",
            (challengeFlags and WindowManager.LayoutParams.FLAG_SECURE) != 0
        )

        // End Challenge -> navigates to Results -> FLAG_SECURE must be removed!
        activity.viewModel.confirmAbandonOrEndQuiz()
        composeTestRule.waitForIdle()
        val resultsFlags = activity.window.attributes.flags
        assertEquals(
            "Expected FLAG_SECURE to be cleared on Results screen",
            0,
            resultsFlags and WindowManager.LayoutParams.FLAG_SECURE
        )
    }

    @Test
    @Config(sdk = [36], qualifiers = "w320dp-h640dp", fontScale = 1.3f)
    fun compactPhoneAndLargeFontScale_rendersHeroSetupAndCategoriesCleanly() {
        composeTestRule.waitForIdle()

        // Verify Welcome screen renders cleanly on 320dp narrow screen with 1.3x font scale
        composeTestRule.onNodeWithTag("welcome_screen").assertIsDisplayed()
        composeTestRule.onNodeWithTag("welcome_app_title").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithText("Challenge your mind.").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithText("Learn. Practice. Improve.").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithTag("welcome_get_started_button").performScrollTo().performClick()
        composeTestRule.waitForIdle()

        // Verify Home hero actions and Mixed Quiz button display cleanly on 320dp narrow screen with 1.3x font scale
        composeTestRule.onNodeWithText("Challenge your mind.").assertIsDisplayed()
        composeTestRule.onNodeWithTag("start_quiz_button").assertIsDisplayed()
        composeTestRule.onNodeWithTag("random_quiz_button").assertIsDisplayed()
        composeTestRule.onNodeWithTag("home_lazy_column")
            .performScrollToNode(hasTestTag("configure_mixed_quiz_button"))
        composeTestRule.onNodeWithTag("configure_mixed_quiz_button").assertIsDisplayed()

        // Open Setup and verify "5", "10", "15" question count buttons are displayed
        composeTestRule.onNodeWithTag("home_lazy_column")
            .performScrollToNode(hasTestTag("start_quiz_button"))
        composeTestRule.onNodeWithTag("start_quiz_button").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("setup_count_5").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithTag("setup_count_10").performScrollTo().assertIsDisplayed()
        composeTestRule.onNodeWithTag("setup_count_15").performScrollTo().assertIsDisplayed()
    }
}
