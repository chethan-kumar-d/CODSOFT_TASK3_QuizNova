package com.example.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.QuizRepository
import com.example.data.local.PreferencesAndSessionStore
import com.example.data.local.QuizDatabase
import com.example.data.questions.QuestionBank
import com.example.domain.AnalyticsModeFilter
import com.example.domain.ProgressAnalyticsSnapshot
import com.example.domain.QuizAnalyticsEngine
import com.example.domain.QuizScoringEngine
import com.example.model.ActiveQuizSession
import com.example.model.AttemptCompletionStatus
import com.example.model.FinalizedAttemptSummary
import com.example.model.QuizDifficulty
import com.example.model.QuizMode
import com.example.model.QuizQuestion
import com.example.model.QuizScope
import com.example.model.ThemePreference
import com.example.model.UserPreferences
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed interface QuizNovaScreen {
    data object Welcome : QuizNovaScreen
    data object Home : QuizNovaScreen
    data object Setup : QuizNovaScreen
    data object ActiveQuiz : QuizNovaScreen
    data class Results(val attemptId: String) : QuizNovaScreen
    data class AnswerReview(val attemptId: String, val fromHistory: Boolean = false) : QuizNovaScreen
    data object Progress : QuizNovaScreen
    data object History : QuizNovaScreen
    data class AttemptDetail(val attemptId: String) : QuizNovaScreen
    data object SettingsPrivacy : QuizNovaScreen
}

data class PoolExhaustionPrompt(
    val scope: QuizScope,
    val difficulty: QuizDifficulty,
    val mode: QuizMode,
    val requestedCount: Int,
    val unseenCount: Int,
    val totalPoolSize: Int
)

data class QuizSetupConfig(
    val scope: QuizScope = QuizScope.PYTHON,
    val difficulty: QuizDifficulty = QuizDifficulty.APPLIED,
    val questionCount: Int = 10,
    val mode: QuizMode = QuizMode.PRACTICE,
    val showChallengeConsentDialog: Boolean = false,
    val multiWindowRejectionMessage: String? = null
) {
    val availableQuestionCounts: List<Int>
        get() = QuestionBank.getAvailableQuestionCounts(scope, difficulty)

    val matchingPoolSize: Int
        get() = QuestionBank.getMatchingQuestions(scope, difficulty).size
}

data class QuizNovaUiState(
    val isInitialized: Boolean = false,
    val currentScreen: QuizNovaScreen = QuizNovaScreen.Welcome,
    val setupConfig: QuizSetupConfig = QuizSetupConfig(),
    val unseenMatchingPoolSize: Int = 100,
    val seenQuestionIds: Set<String> = emptySet(),
    val poolExhaustionPrompt: PoolExhaustionPrompt? = null,
    val activeSession: ActiveQuizSession? = null,
    val currentQuestion: QuizQuestion? = null,
    val latestResultSummary: FinalizedAttemptSummary? = null,
    val historyAttempts: List<FinalizedAttemptSummary> = emptyList(),
    val analyticsFilter: AnalyticsModeFilter = AnalyticsModeFilter.ALL,
    val historyFilter: AnalyticsModeFilter = AnalyticsModeFilter.ALL,
    val analyticsSnapshot: ProgressAnalyticsSnapshot = QuizAnalyticsEngine.computeAnalytics(emptyList()),
    val userPreferences: UserPreferences = UserPreferences(),
    val showAbandonQuizDialog: Boolean = false,
    val showClearHistoryDialog: Boolean = false,
    val interruptedChallengeBannerAttempt: FinalizedAttemptSummary? = null
) {
    val shouldApplyFlagSecure: Boolean
        get() = currentScreen is QuizNovaScreen.ActiveQuiz &&
            activeSession?.mode == QuizMode.CHALLENGE &&
            activeSession.isFinalized == false
}

class QuizNovaViewModel(
    private val repository: QuizRepository
) : ViewModel() {

    private val _currentScreen = MutableStateFlow<QuizNovaScreen>(QuizNovaScreen.Welcome)
    private val _setupConfig = MutableStateFlow(QuizSetupConfig())
    private val _seenQuestionIds = MutableStateFlow<Set<String>>(emptySet())
    private val _poolExhaustionPrompt = MutableStateFlow<PoolExhaustionPrompt?>(null)
    private val _activeSession = MutableStateFlow<ActiveQuizSession?>(null)
    private val _latestResultSummary = MutableStateFlow<FinalizedAttemptSummary?>(null)
    private val _historyAttempts = MutableStateFlow<List<FinalizedAttemptSummary>>(emptyList())
    private val _analyticsFilter = MutableStateFlow(AnalyticsModeFilter.ALL)
    private val _historyFilter = MutableStateFlow(AnalyticsModeFilter.ALL)
    private val _userPreferences = MutableStateFlow(UserPreferences())
    private val _showAbandonQuizDialog = MutableStateFlow(false)
    private val _showClearHistoryDialog = MutableStateFlow(false)
    private val _interruptedChallengeBannerAttempt = MutableStateFlow<FinalizedAttemptSummary?>(null)
    private val _isInitialized = MutableStateFlow(false)

    private var _hasCompletedWelcome: Boolean = false
    private var _restoreToActiveQuizRequested: Boolean = false

    val hasCompletedWelcome: Boolean
        get() = _hasCompletedWelcome

    private val _uiState = MutableStateFlow(QuizNovaUiState())
    val uiState: StateFlow<QuizNovaUiState> = _uiState.asStateFlow()
    val currentScreen: StateFlow<QuizNovaScreen> = _currentScreen.asStateFlow()

    init {
        syncUiState()
        viewModelScope.launch {
            repository.allFinalizedAttemptsFlow.collect { attempts ->
                _historyAttempts.value = attempts
                syncUiState()
            }
        }
        viewModelScope.launch {
            repository.userPreferencesFlow.collect { prefs ->
                _userPreferences.value = prefs
                syncUiState()
            }
        }
        viewModelScope.launch {
            repository.seenQuestionIdsFlow.collect { seenIds ->
                _seenQuestionIds.value = seenIds
                syncUiState()
            }
        }
        viewModelScope.launch {
            performStartupSessionCheck()
        }
    }

    private fun syncUiState() {
        val session = _activeSession.value
        val currentQuestion = session?.currentQuestionState?.questionId?.let {
            QuestionBank.getQuestionById(it)
        }
        val attempts = _historyAttempts.value
        val aFilter = _analyticsFilter.value
        val config = _setupConfig.value
        val seenIds = _seenQuestionIds.value
        val unseenCount = QuestionBank.getUnseenMatchingQuestions(
            scope = config.scope,
            difficulty = config.difficulty,
            seenQuestionIds = seenIds
        ).size

        _uiState.value = QuizNovaUiState(
            isInitialized = _isInitialized.value,
            currentScreen = _currentScreen.value,
            setupConfig = config,
            unseenMatchingPoolSize = unseenCount,
            seenQuestionIds = seenIds,
            poolExhaustionPrompt = _poolExhaustionPrompt.value,
            activeSession = session,
            currentQuestion = currentQuestion,
            latestResultSummary = _latestResultSummary.value,
            historyAttempts = attempts,
            analyticsFilter = aFilter,
            historyFilter = _historyFilter.value,
            analyticsSnapshot = QuizAnalyticsEngine.computeAnalytics(attempts, aFilter),
            userPreferences = _userPreferences.value,
            showAbandonQuizDialog = _showAbandonQuizDialog.value,
            showClearHistoryDialog = _showClearHistoryDialog.value,
            interruptedChallengeBannerAttempt = _interruptedChallengeBannerAttempt.value
        )
    }

    suspend fun performStartupSessionCheck() {
        val persistedSeen = repository.getSeenQuestionIdsSnapshot()
        if (persistedSeen.isNotEmpty()) {
            _seenQuestionIds.update { it + persistedSeen }
        }

        // Never interrupt an already-active in-memory quiz session
        val existingInMemory = _activeSession.value
        if (existingInMemory != null && !existingInMemory.isFinalized && _currentScreen.value is QuizNovaScreen.ActiveQuiz) {
            _isInitialized.value = true
            syncUiState()
            return
        }

        val savedSession = repository.getActiveSessionSnapshot()
        if (savedSession != null && !savedSession.isFinalized) {
            if (savedSession.mode == QuizMode.CHALLENGE) {
                // An interrupted Challenge that was not cleanly finalized is treated as ended on next launch
                val summary = withContext(NonCancellable) {
                    repository.finalizeAndPersistSession(
                        session = savedSession,
                        completionStatus = AttemptCompletionStatus.ENDED_INTERRUPTED_SESSION
                    )
                }
                _activeSession.value = null
                _latestResultSummary.value = summary
                _interruptedChallengeBannerAttempt.value = summary
                _historyAttempts.update { list ->
                    if (list.any { it.attemptId == summary.attemptId }) list else listOf(summary) + list
                }
            } else {
                // Practice session is preserved and can be resumed without loss
                if (_activeSession.value == null) {
                    _activeSession.value = savedSession
                }
                if (_restoreToActiveQuizRequested) {
                    _hasCompletedWelcome = true
                    _currentScreen.value = QuizNovaScreen.ActiveQuiz
                    _restoreToActiveQuizRequested = false
                    val displayedId = savedSession.currentQuestionState?.questionId
                    if (!displayedId.isNullOrBlank()) {
                        _seenQuestionIds.update { it + displayedId }
                        repository.markQuestionSeen(displayedId)
                    }
                }
            }
        }
        _isInitialized.value = true
        syncUiState()
    }

    fun completeWelcome() {
        _hasCompletedWelcome = true
        if (_currentScreen.value is QuizNovaScreen.Welcome) {
            _currentScreen.value = QuizNovaScreen.Home
        }
        syncUiState()
    }

    fun onActivityRestored(welcomeCompleted: Boolean, wasInActiveQuiz: Boolean) {
        if (wasInActiveQuiz) {
            _hasCompletedWelcome = true
            val session = _activeSession.value
            if (session != null && !session.isFinalized && session.mode == QuizMode.PRACTICE) {
                _currentScreen.value = QuizNovaScreen.ActiveQuiz
                recordQuestionDisplayed(session.currentQuestionState?.questionId)
            } else {
                _restoreToActiveQuizRequested = true
                if (_currentScreen.value is QuizNovaScreen.Welcome) {
                    _currentScreen.value = QuizNovaScreen.Home
                }
            }
            syncUiState()
        } else if (welcomeCompleted) {
            _hasCompletedWelcome = true
            if (_currentScreen.value is QuizNovaScreen.Welcome) {
                _currentScreen.value = QuizNovaScreen.Home
            }
            syncUiState()
        }
    }

    fun dismissInterruptedChallengeBanner() {
        _interruptedChallengeBannerAttempt.value = null
        syncUiState()
    }

    fun navigateTo(screen: QuizNovaScreen) {
        if (screen !is QuizNovaScreen.Welcome) {
            _hasCompletedWelcome = true
        }
        _showAbandonQuizDialog.value = false
        _showClearHistoryDialog.value = false
        _poolExhaustionPrompt.value = null
        _currentScreen.value = screen
        syncUiState()
    }

    fun openQuizSetup(
        scope: QuizScope = _setupConfig.value.scope,
        difficulty: QuizDifficulty = QuizDifficulty.APPLIED,
        mode: QuizMode = QuizMode.PRACTICE
    ) {
        _hasCompletedWelcome = true
        val validCounts = QuestionBank.getAvailableQuestionCounts(scope, difficulty)
        val defaultCount = if (10 in validCounts) 10 else (validCounts.firstOrNull() ?: 5)
        _setupConfig.value = QuizSetupConfig(
            scope = scope,
            difficulty = difficulty,
            questionCount = defaultCount,
            mode = mode,
            showChallengeConsentDialog = false,
            multiWindowRejectionMessage = null
        )
        _poolExhaustionPrompt.value = null
        _currentScreen.value = QuizNovaScreen.Setup
        syncUiState()
    }

    fun startQuickRandomMixedQuiz() {
        _hasCompletedWelcome = true
        startNewSessionInternal(
            scope = QuizScope.MIXED,
            difficulty = QuizDifficulty.APPLIED,
            mode = QuizMode.PRACTICE,
            questionCount = 10
        )
    }

    fun resumeActivePracticeSession() {
        val session = _activeSession.value ?: return
        if (session.mode == QuizMode.PRACTICE && !session.isFinalized) {
            _hasCompletedWelcome = true
            _currentScreen.value = QuizNovaScreen.ActiveQuiz
            recordQuestionDisplayed(session.currentQuestionState?.questionId)
            syncUiState()
        }
    }

    fun updateSetupScope(scope: QuizScope) {
        _setupConfig.update { current ->
            val validCounts = QuestionBank.getAvailableQuestionCounts(scope, current.difficulty)
            val adjustedCount = if (current.questionCount in validCounts) {
                current.questionCount
            } else {
                validCounts.lastOrNull() ?: 5
            }
            current.copy(
                scope = scope,
                questionCount = adjustedCount,
                multiWindowRejectionMessage = null
            )
        }
        _poolExhaustionPrompt.value = null
        syncUiState()
    }

    fun updateSetupDifficulty(difficulty: QuizDifficulty) {
        _setupConfig.update { current ->
            val validCounts = QuestionBank.getAvailableQuestionCounts(current.scope, difficulty)
            val adjustedCount = if (current.questionCount in validCounts) {
                current.questionCount
            } else {
                validCounts.lastOrNull() ?: 5
            }
            current.copy(
                difficulty = difficulty,
                questionCount = adjustedCount,
                multiWindowRejectionMessage = null
            )
        }
        _poolExhaustionPrompt.value = null
        syncUiState()
    }

    fun updateSetupQuestionCount(count: Int) {
        _setupConfig.update { current ->
            val validCounts = QuestionBank.getAvailableQuestionCounts(current.scope, current.difficulty)
            if (count in validCounts) {
                current.copy(questionCount = count, multiWindowRejectionMessage = null)
            } else {
                current
            }
        }
        _poolExhaustionPrompt.value = null
        syncUiState()
    }

    fun updateSetupMode(mode: QuizMode) {
        _setupConfig.update { current ->
            current.copy(
                mode = mode,
                showChallengeConsentDialog = false,
                multiWindowRejectionMessage = null
            )
        }
        _poolExhaustionPrompt.value = null
        syncUiState()
    }

    fun requestStartFromSetup(isInMultiWindowMode: Boolean = false) {
        val config = _setupConfig.value
        if (config.mode == QuizMode.CHALLENGE) {
            if (isInMultiWindowMode) {
                _setupConfig.update {
                    it.copy(
                        showChallengeConsentDialog = false,
                        multiWindowRejectionMessage = "Challenge mode cannot start in split-screen or multi-window mode because window focus is shared. Please maximize QuizNova to full screen or switch to Practice mode."
                    )
                }
                syncUiState()
                return
            }
            _setupConfig.update {
                it.copy(showChallengeConsentDialog = true, multiWindowRejectionMessage = null)
            }
            syncUiState()
        } else {
            startNewSessionInternal(
                scope = config.scope,
                difficulty = config.difficulty,
                mode = QuizMode.PRACTICE,
                questionCount = config.questionCount
            )
        }
    }

    fun dismissChallengeConsentDialog() {
        _setupConfig.update { it.copy(showChallengeConsentDialog = false) }
        syncUiState()
    }

    fun switchToPracticeAndBegin() {
        val config = _setupConfig.value
        _setupConfig.update {
            it.copy(
                mode = QuizMode.PRACTICE,
                showChallengeConsentDialog = false,
                multiWindowRejectionMessage = null
            )
        }
        startNewSessionInternal(
            scope = config.scope,
            difficulty = config.difficulty,
            mode = QuizMode.PRACTICE,
            questionCount = config.questionCount
        )
    }

    fun confirmBeginChallenge(isInMultiWindowMode: Boolean = false) {
        val config = _setupConfig.value
        if (isInMultiWindowMode) {
            _setupConfig.update {
                it.copy(
                    showChallengeConsentDialog = false,
                    multiWindowRejectionMessage = "Challenge mode cannot start in split-screen or multi-window mode. Please maximize QuizNova to full screen or switch to Practice mode."
                )
            }
            syncUiState()
            return
        }
        _setupConfig.update {
            it.copy(showChallengeConsentDialog = false, multiWindowRejectionMessage = null)
        }
        startNewSessionInternal(
            scope = config.scope,
            difficulty = config.difficulty,
            mode = QuizMode.CHALLENGE,
            questionCount = config.questionCount
        )
    }

    /**
     * Checks unseen question availability before launching a session.
     * Never silently repeats questions or resets rotation records: if fewer unseen questions
     * remain than requestedCount, presents PoolExhaustionPrompt so the user can choose a shorter
     * quiz or explicitly start a new cycle.
     */
    private fun startNewSessionInternal(
        scope: QuizScope,
        difficulty: QuizDifficulty,
        mode: QuizMode,
        questionCount: Int
    ) {
        val seenIds = _seenQuestionIds.value
        val unseenPool = QuestionBank.getUnseenMatchingQuestions(
            scope = scope,
            difficulty = difficulty,
            seenQuestionIds = seenIds
        )
        val totalPoolSize = QuestionBank.getMatchingQuestions(scope, difficulty).size

        if (unseenPool.size < questionCount) {
            _poolExhaustionPrompt.value = PoolExhaustionPrompt(
                scope = scope,
                difficulty = difficulty,
                mode = mode,
                requestedCount = questionCount,
                unseenCount = unseenPool.size,
                totalPoolSize = totalPoolSize
            )
            syncUiState()
            return
        }

        launchSessionWithSeenSet(
            scope = scope,
            difficulty = difficulty,
            mode = mode,
            questionCount = questionCount,
            seenIds = seenIds,
            prioritizeIds = emptySet()
        )
    }

    private fun launchSessionWithSeenSet(
        scope: QuizScope,
        difficulty: QuizDifficulty,
        mode: QuizMode,
        questionCount: Int,
        seenIds: Set<String>,
        prioritizeIds: Set<String>
    ) {
        val session = QuestionBank.createQuizSession(
            scope = scope,
            difficulty = difficulty,
            mode = mode,
            requestedCount = questionCount,
            seenQuestionIds = seenIds,
            prioritizeQuestionIds = prioritizeIds
        )
        _activeSession.value = session
        _showAbandonQuizDialog.value = false
        _poolExhaustionPrompt.value = null
        _currentScreen.value = QuizNovaScreen.ActiveQuiz

        // Mark ONLY the first displayed question (index 0) as seen when the session opens
        val firstDisplayedId = session.currentQuestionState?.questionId
        if (!firstDisplayedId.isNullOrBlank()) {
            _seenQuestionIds.update { it + firstDisplayedId }
        }
        syncUiState()
        viewModelScope.launch {
            if (!firstDisplayedId.isNullOrBlank()) {
                repository.markQuestionSeen(firstDisplayedId)
            }
            repository.saveActiveSession(session)
        }
    }

    /**
     * Starts a shorter quiz using only the remaining unseen questions in the selected pool.
     */
    fun confirmShorterQuizFromExhaustion() {
        val prompt = _poolExhaustionPrompt.value ?: return
        if (prompt.unseenCount <= 0) return
        _poolExhaustionPrompt.value = null
        launchSessionWithSeenSet(
            scope = prompt.scope,
            difficulty = prompt.difficulty,
            mode = prompt.mode,
            questionCount = prompt.unseenCount,
            seenIds = _seenQuestionIds.value,
            prioritizeIds = emptySet()
        )
    }

    /**
     * Explicitly starts a new rotation cycle for the selected scope & difficulty pool after user
     * permission, prioritizing any remaining unseen questions first and preserving all history,
     * scores, and preferences.
     */
    fun confirmStartNewCycleFromExhaustion() {
        val prompt = _poolExhaustionPrompt.value ?: return
        _poolExhaustionPrompt.value = null

        val remainingUnseenIds = QuestionBank
            .getUnseenMatchingQuestions(prompt.scope, prompt.difficulty, _seenQuestionIds.value)
            .map { it.id }
            .toSet()

        val poolQuestionIds = QuestionBank
            .getMatchingQuestions(prompt.scope, prompt.difficulty)
            .map { it.id }
            .toSet()

        val updatedSeenIds = _seenQuestionIds.value - poolQuestionIds
        _seenQuestionIds.value = updatedSeenIds

        val session = QuestionBank.createQuizSession(
            scope = prompt.scope,
            difficulty = prompt.difficulty,
            mode = prompt.mode,
            requestedCount = prompt.requestedCount,
            seenQuestionIds = updatedSeenIds,
            prioritizeQuestionIds = remainingUnseenIds
        )
        _activeSession.value = session
        _showAbandonQuizDialog.value = false
        _currentScreen.value = QuizNovaScreen.ActiveQuiz

        val firstDisplayedId = session.currentQuestionState?.questionId
        if (!firstDisplayedId.isNullOrBlank()) {
            _seenQuestionIds.update { it + firstDisplayedId }
        }
        syncUiState()

        viewModelScope.launch {
            repository.resetSeenQuestionsForPool(prompt.scope, prompt.difficulty)
            if (!firstDisplayedId.isNullOrBlank()) {
                repository.markQuestionSeen(firstDisplayedId)
            }
            repository.saveActiveSession(session)
        }
    }

    fun dismissPoolExhaustionPrompt() {
        _poolExhaustionPrompt.value = null
        syncUiState()
    }

    /**
     * Marks a question seen when it is actually displayed on screen.
     */
    fun onQuestionDisplayed(questionId: String) {
        recordQuestionDisplayed(questionId)
    }

    private fun recordQuestionDisplayed(questionId: String?) {
        if (questionId.isNullOrBlank()) return
        if (questionId !in _seenQuestionIds.value) {
            _seenQuestionIds.update { it + questionId }
            syncUiState()
        }
        viewModelScope.launch {
            repository.markQuestionSeen(questionId)
        }
    }

    /**
     * Called only after the user has tapped Begin Challenge AND the ActiveQuiz screen
     * is visible and has window focus.
     */
    fun onChallengeQuizVisibleAndFocused() {
        val current = _activeSession.value ?: return
        if (_currentScreen.value !is QuizNovaScreen.ActiveQuiz) return
        if (current.mode == QuizMode.CHALLENGE && !current.isFinalized && !current.challengeArmed) {
            val armed = QuizScoringEngine.armChallengeMonitoring(current)
            _activeSession.value = armed
            syncUiState()
            viewModelScope.launch {
                repository.saveActiveSession(armed)
            }
        }
    }

    /**
     * Triggered when the Activity loses window focus, enters background (`ON_STOP`), or enters
     * multi-window mode during an active, armed Challenge session (and not due to configuration change).
     */
    fun onChallengeFocusOrForegroundLost(isChangingConfigurations: Boolean) {
        if (isChangingConfigurations) return
        val session = _activeSession.value ?: return
        if (_currentScreen.value !is QuizNovaScreen.ActiveQuiz) return
        if (session.mode != QuizMode.CHALLENGE || !session.challengeArmed || session.isFinalized) {
            return
        }

        finalizeSessionImmediateAndPersist(
            session = session,
            completionStatus = AttemptCompletionStatus.AUTO_SUBMITTED_FOCUS_LOSS
        )
    }

    private fun finalizeSessionImmediateAndPersist(
        session: ActiveQuizSession,
        completionStatus: AttemptCompletionStatus
    ) {
        val now = System.currentTimeMillis()
        val (markedFinalized, optimisticSummary) = QuizScoringEngine.evaluateSession(
            session = session,
            completionStatus = completionStatus,
            completedAtEpochMillis = now
        )
        _activeSession.value = null
        _showAbandonQuizDialog.value = false
        _latestResultSummary.value = optimisticSummary
        _historyAttempts.update { list ->
            listOf(optimisticSummary) + list.filterNot { it.attemptId == optimisticSummary.attemptId }
        }
        _currentScreen.value = QuizNovaScreen.Results(optimisticSummary.attemptId)
        syncUiState()

        viewModelScope.launch(NonCancellable) {
            val persisted = repository.finalizeAndPersistSession(
                session = markedFinalized,
                completionStatus = completionStatus,
                completedAtEpochMillis = now
            )
            _latestResultSummary.value = persisted
            syncUiState()
        }
    }

    fun selectOption(optionId: String) {
        val session = _activeSession.value ?: return
        val updated = QuizScoringEngine.selectOption(session, optionId)
        if (updated != session) {
            _activeSession.value = updated
            syncUiState()
            viewModelScope.launch {
                repository.saveActiveSession(updated)
            }
        }
    }

    fun submitCurrentAnswer() {
        val session = _activeSession.value ?: return
        val updated = QuizScoringEngine.submitCurrentAnswer(session)
        if (updated != session) {
            _activeSession.value = updated
            syncUiState()
            viewModelScope.launch {
                repository.saveActiveSession(updated)
            }
        }
    }

    fun nextQuestionOrFinish() {
        val session = _activeSession.value ?: return
        val currentQ = session.currentQuestionState ?: return
        if (!currentQ.isSubmitted) return

        if (session.currentIndex < session.questions.lastIndex) {
            val advanced = QuizScoringEngine.advanceToNextQuestion(session)
            _activeSession.value = advanced
            val newlyDisplayedId = advanced.currentQuestionState?.questionId
            if (!newlyDisplayedId.isNullOrBlank()) {
                _seenQuestionIds.update { it + newlyDisplayedId }
            }
            syncUiState()
            viewModelScope.launch {
                if (!newlyDisplayedId.isNullOrBlank()) {
                    repository.markQuestionSeen(newlyDisplayedId)
                }
                repository.saveActiveSession(advanced)
            }
        } else {
            finalizeSessionImmediateAndPersist(
                session = session,
                completionStatus = AttemptCompletionStatus.COMPLETED_NORMALLY
            )
        }
    }

    fun requestAbandonOrExitQuiz() {
        val session = _activeSession.value
        if (session != null && !session.isFinalized) {
            _showAbandonQuizDialog.value = true
        } else {
            _currentScreen.value = QuizNovaScreen.Home
        }
        syncUiState()
    }

    fun dismissAbandonQuizDialog() {
        _showAbandonQuizDialog.value = false
        syncUiState()
    }

    fun confirmAbandonOrEndQuiz() {
        val session = _activeSession.value
        _showAbandonQuizDialog.value = false
        if (session == null) {
            _currentScreen.value = QuizNovaScreen.Home
            syncUiState()
            return
        }
        if (session.mode == QuizMode.CHALLENGE) {
            // In Challenge mode, ending early finalizes and submits the attempt with current submitted answers
            finalizeSessionImmediateAndPersist(
                session = session,
                completionStatus = AttemptCompletionStatus.COMPLETED_NORMALLY
            )
        } else {
            // In Practice mode, confirming abandon discards the active session without recording a completed attempt
            _activeSession.value = null
            _currentScreen.value = QuizNovaScreen.Home
            syncUiState()
            viewModelScope.launch {
                repository.abandonActiveSession()
            }
        }
    }

    fun retryAttempt(attempt: FinalizedAttemptSummary, isInMultiWindowMode: Boolean = false) {
        if (attempt.mode == QuizMode.CHALLENGE) {
            // Require explicit Challenge consent again before starting a fresh Challenge attempt
            _setupConfig.value = QuizSetupConfig(
                scope = attempt.scope,
                difficulty = attempt.difficulty,
                questionCount = attempt.totalQuestions,
                mode = QuizMode.CHALLENGE,
                showChallengeConsentDialog = !isInMultiWindowMode,
                multiWindowRejectionMessage = if (isInMultiWindowMode) {
                    "Challenge mode cannot start in split-screen or multi-window mode. Please maximize QuizNova to full screen or switch to Practice mode."
                } else null
            )
            _currentScreen.value = QuizNovaScreen.Setup
            syncUiState()
        } else {
            startNewSessionInternal(
                scope = attempt.scope,
                difficulty = attempt.difficulty,
                mode = QuizMode.PRACTICE,
                questionCount = attempt.totalQuestions
            )
        }
    }

    fun setAnalyticsFilter(filter: AnalyticsModeFilter) {
        _analyticsFilter.value = filter
        syncUiState()
    }

    fun setHistoryFilter(filter: AnalyticsModeFilter) {
        _historyFilter.value = filter
        syncUiState()
    }

    fun requestClearHistory() {
        _showClearHistoryDialog.value = true
        syncUiState()
    }

    fun dismissClearHistoryDialog() {
        _showClearHistoryDialog.value = false
        syncUiState()
    }

    fun confirmClearHistory() {
        _showClearHistoryDialog.value = false
        _latestResultSummary.value = null
        _interruptedChallengeBannerAttempt.value = null
        _historyAttempts.value = emptyList()
        syncUiState()
        viewModelScope.launch {
            repository.clearAllHistory()
        }
    }

    fun setThemePreference(theme: ThemePreference) {
        _userPreferences.update { it.copy(themePreference = theme) }
        syncUiState()
        viewModelScope.launch {
            repository.setThemePreference(theme)
        }
    }

    fun setReduceMotion(reduceMotion: Boolean) {
        _userPreferences.update { it.copy(reduceMotion = reduceMotion) }
        syncUiState()
        viewModelScope.launch {
            repository.setReduceMotion(reduceMotion)
        }
    }

    fun resolveAttemptById(attemptId: String): FinalizedAttemptSummary? {
        val latest = _latestResultSummary.value
        if (latest != null && latest.attemptId == attemptId) return latest
        return _historyAttempts.value.find { it.attemptId == attemptId }
    }

    companion object {
        fun provideFactory(context: Context): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val db = QuizDatabase.getInstance(context)
                    val store = PreferencesAndSessionStore(context)
                    val repo = QuizRepository(db.quizDao(), store)
                    return QuizNovaViewModel(repo) as T
                }
            }
    }
}
