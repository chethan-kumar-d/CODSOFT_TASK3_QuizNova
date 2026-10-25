package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.components.DimensionalButton
import com.example.ui.screens.AnswerReviewScreen
import com.example.ui.screens.AttemptDetailScreen
import com.example.ui.screens.AttemptHistoryScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.ProgressDashboardScreen
import com.example.ui.screens.QuizSessionScreen
import com.example.ui.screens.QuizSetupScreen
import com.example.ui.screens.ResultsScreen
import com.example.ui.screens.SettingsAndPrivacyScreen
import com.example.ui.screens.WelcomeScreen
import com.example.ui.theme.ElectricViolet
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.LocalQuizNovaTokens
import com.example.ui.theme.LuminousCyan
import com.example.ui.theme.LuminousCyanBright
import com.example.ui.theme.WarmAmberAccent
import com.example.viewmodel.PoolExhaustionPrompt
import com.example.viewmodel.QuizNovaScreen
import com.example.viewmodel.QuizNovaViewModel

private data class TopLevelDestination(
    val id: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screen: QuizNovaScreen,
    val testTag: String
)

private val topLevelDestinations = listOf(
    TopLevelDestination(
        id = "home",
        label = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        screen = QuizNovaScreen.Home,
        testTag = "nav_tab_home"
    ),
    TopLevelDestination(
        id = "progress",
        label = "Progress",
        selectedIcon = Icons.Filled.Analytics,
        unselectedIcon = Icons.Outlined.Analytics,
        screen = QuizNovaScreen.Progress,
        testTag = "nav_tab_progress"
    ),
    TopLevelDestination(
        id = "history",
        label = "History",
        selectedIcon = Icons.Filled.History,
        unselectedIcon = Icons.Outlined.History,
        screen = QuizNovaScreen.History,
        testTag = "nav_tab_history"
    ),
    TopLevelDestination(
        id = "settings",
        label = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        screen = QuizNovaScreen.SettingsPrivacy,
        testTag = "nav_tab_settings"
    )
)

@Composable
fun QuizNovaApp(
    viewModel: QuizNovaViewModel,
    isInMultiWindowMode: Boolean = false
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val tokens = LocalQuizNovaTokens.current
    val currentScreen = uiState.currentScreen

    // Show bottom/rail navigation on the four primary destinations (never on Welcome)
    val showTopLevelNav = when (currentScreen) {
        is QuizNovaScreen.Home,
        is QuizNovaScreen.Progress,
        is QuizNovaScreen.History,
        is QuizNovaScreen.SettingsPrivacy -> true
        else -> false
    }

    // BackHandler on secondary top-level tabs and Setup returns to Home.
    // Note: Home and Welcome have NO BackHandler so pressing Back on Home exits the app normally
    // rather than returning to Welcome.
    if (currentScreen is QuizNovaScreen.Setup ||
        currentScreen is QuizNovaScreen.Progress ||
        currentScreen is QuizNovaScreen.History ||
        currentScreen is QuizNovaScreen.SettingsPrivacy
    ) {
        BackHandler {
            viewModel.navigateTo(QuizNovaScreen.Home)
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isWideScreen = maxWidth >= 640.dp

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            contentWindowInsets = WindowInsets.safeDrawing,
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = {
                if (showTopLevelNav && !isWideScreen) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        tonalElevation = 6.dp
                    ) {
                        topLevelDestinations.forEach { dest ->
                            val isSelected = isDestinationSelected(currentScreen, dest.screen)
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = {
                                    viewModel.navigateTo(dest.screen)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (isSelected) dest.selectedIcon else dest.unselectedIcon,
                                        contentDescription = dest.label
                                    )
                                },
                                label = {
                                    Text(
                                        text = dest.label,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                        )
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = if (tokens.isDark) LuminousCyanBright else ElectricViolet,
                                    selectedTextColor = if (tokens.isDark) LuminousCyanBright else ElectricViolet,
                                    indicatorColor = ElectricViolet.copy(alpha = 0.20f)
                                ),
                                modifier = Modifier.testTag(dest.testTag)
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (showTopLevelNav && isWideScreen) {
                    NavigationRail(
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        topLevelDestinations.forEach { dest ->
                            val isSelected = isDestinationSelected(currentScreen, dest.screen)
                            NavigationRailItem(
                                selected = isSelected,
                                onClick = {
                                    viewModel.navigateTo(dest.screen)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (isSelected) dest.selectedIcon else dest.unselectedIcon,
                                        contentDescription = dest.label
                                    )
                                },
                                label = {
                                    Text(
                                        text = dest.label,
                                        maxLines = 1,
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                },
                                colors = NavigationRailItemDefaults.colors(
                                    selectedIconColor = if (tokens.isDark) LuminousCyanBright else ElectricViolet,
                                    selectedTextColor = if (tokens.isDark) LuminousCyanBright else ElectricViolet,
                                    indicatorColor = ElectricViolet.copy(alpha = 0.20f)
                                ),
                                modifier = Modifier.testTag(dest.testTag)
                            )
                        }
                    }
                }

                Box(modifier = Modifier.weight(1f).fillMaxSize()) {
                    Crossfade(
                        targetState = currentScreen,
                        animationSpec = if (tokens.reduceMotion) tween(0) else tween(180),
                        label = "screen_transition"
                    ) { screen ->
                        when (screen) {
                            is QuizNovaScreen.Welcome -> {
                                WelcomeScreen(
                                    onGetStarted = viewModel::completeWelcome
                                )
                            }

                            is QuizNovaScreen.Home -> {
                                HomeScreen(
                                    activeSession = uiState.activeSession,
                                    analyticsSnapshot = uiState.analyticsSnapshot,
                                    interruptedChallengeAttempt = uiState.interruptedChallengeBannerAttempt,
                                    onDismissInterruptedBanner = viewModel::dismissInterruptedChallengeBanner,
                                    onViewAttemptResults = { attemptId ->
                                        viewModel.navigateTo(QuizNovaScreen.Results(attemptId))
                                    },
                                    onStartQuizSetup = { scope ->
                                        viewModel.openQuizSetup(scope = scope)
                                    },
                                    onStartRandomQuiz = viewModel::startQuickRandomMixedQuiz,
                                    onResumePracticeQuiz = viewModel::resumeActivePracticeSession,
                                    onOpenProgress = { viewModel.navigateTo(QuizNovaScreen.Progress) },
                                    onOpenHistory = { viewModel.navigateTo(QuizNovaScreen.History) }
                                )
                            }

                            is QuizNovaScreen.Setup -> {
                                QuizSetupScreen(
                                    config = uiState.setupConfig,
                                    unseenMatchingPoolSize = uiState.unseenMatchingPoolSize,
                                    isInMultiWindowMode = isInMultiWindowMode,
                                    onSelectScope = viewModel::updateSetupScope,
                                    onSelectDifficulty = viewModel::updateSetupDifficulty,
                                    onSelectCount = viewModel::updateSetupQuestionCount,
                                    onSelectMode = viewModel::updateSetupMode,
                                    onRequestStart = viewModel::requestStartFromSetup,
                                    onConfirmBeginChallenge = viewModel::confirmBeginChallenge,
                                    onSwitchToPracticeAndBegin = viewModel::switchToPracticeAndBegin,
                                    onDismissChallengeConsent = viewModel::dismissChallengeConsentDialog,
                                    onBack = { viewModel.navigateTo(QuizNovaScreen.Home) }
                                )
                            }

                            is QuizNovaScreen.ActiveQuiz -> {
                                val session = uiState.activeSession
                                val question = uiState.currentQuestion
                                if (session != null && question != null) {
                                    QuizSessionScreen(
                                        session = session,
                                        question = question,
                                        showAbandonDialog = uiState.showAbandonQuizDialog,
                                        onChallengeScreenFocused = viewModel::onChallengeQuizVisibleAndFocused,
                                        onQuestionDisplayed = viewModel::onQuestionDisplayed,
                                        onSelectOption = viewModel::selectOption,
                                        onSubmitAnswer = viewModel::submitCurrentAnswer,
                                        onNextOrFinish = viewModel::nextQuestionOrFinish,
                                        onRequestAbandon = viewModel::requestAbandonOrExitQuiz,
                                        onConfirmAbandon = viewModel::confirmAbandonOrEndQuiz,
                                        onDismissAbandon = viewModel::dismissAbandonQuizDialog
                                    )
                                }
                            }

                            is QuizNovaScreen.Results -> {
                                val summary = viewModel.resolveAttemptById(screen.attemptId)
                                if (summary != null) {
                                    ResultsScreen(
                                        summary = summary,
                                        onReviewAnswers = {
                                            viewModel.navigateTo(
                                                QuizNovaScreen.AnswerReview(
                                                    attemptId = summary.attemptId,
                                                    fromHistory = false
                                                )
                                            )
                                        },
                                        onTryAgain = {
                                            viewModel.retryAttempt(summary, isInMultiWindowMode)
                                        },
                                        onGoHome = {
                                            viewModel.navigateTo(QuizNovaScreen.Home)
                                        }
                                    )
                                } else {
                                    viewModel.navigateTo(QuizNovaScreen.Home)
                                }
                            }

                            is QuizNovaScreen.AnswerReview -> {
                                val summary = viewModel.resolveAttemptById(screen.attemptId)
                                if (summary != null) {
                                    AnswerReviewScreen(
                                        summary = summary,
                                        onBack = {
                                            if (screen.fromHistory) {
                                                viewModel.navigateTo(QuizNovaScreen.AttemptDetail(screen.attemptId))
                                            } else {
                                                viewModel.navigateTo(QuizNovaScreen.Results(screen.attemptId))
                                            }
                                        }
                                    )
                                } else {
                                    viewModel.navigateTo(QuizNovaScreen.Home)
                                }
                            }

                            is QuizNovaScreen.Progress -> {
                                ProgressDashboardScreen(
                                    snapshot = uiState.analyticsSnapshot,
                                    onSelectFilter = viewModel::setAnalyticsFilter,
                                    onOpenAttemptDetail = { attemptId ->
                                        viewModel.navigateTo(QuizNovaScreen.AttemptDetail(attemptId))
                                    },
                                    onStartQuiz = { viewModel.openQuizSetup() }
                                )
                            }

                            is QuizNovaScreen.History -> {
                                AttemptHistoryScreen(
                                    attempts = uiState.historyAttempts,
                                    selectedFilter = uiState.historyFilter,
                                    onSelectFilter = viewModel::setHistoryFilter,
                                    onOpenAttemptDetail = { attemptId ->
                                        viewModel.navigateTo(QuizNovaScreen.AttemptDetail(attemptId))
                                    },
                                    onStartQuiz = { viewModel.openQuizSetup() }
                                )
                            }

                            is QuizNovaScreen.AttemptDetail -> {
                                val summary = viewModel.resolveAttemptById(screen.attemptId)
                                if (summary != null) {
                                    AttemptDetailScreen(
                                        summary = summary,
                                        onOpenFullReview = {
                                            viewModel.navigateTo(
                                                QuizNovaScreen.AnswerReview(
                                                    attemptId = summary.attemptId,
                                                    fromHistory = true
                                                )
                                            )
                                        },
                                        onRetryAttempt = {
                                            viewModel.retryAttempt(summary, isInMultiWindowMode)
                                        },
                                        onBack = {
                                            viewModel.navigateTo(QuizNovaScreen.History)
                                        }
                                    )
                                } else {
                                    viewModel.navigateTo(QuizNovaScreen.History)
                                }
                            }

                            is QuizNovaScreen.SettingsPrivacy -> {
                                SettingsAndPrivacyScreen(
                                    preferences = uiState.userPreferences,
                                    totalRecordedAttempts = uiState.historyAttempts.size,
                                    showClearHistoryDialog = uiState.showClearHistoryDialog,
                                    onSelectTheme = viewModel::setThemePreference,
                                    onToggleReduceMotion = viewModel::setReduceMotion,
                                    onRequestClearHistory = viewModel::requestClearHistory,
                                    onConfirmClearHistory = viewModel::confirmClearHistory,
                                    onDismissClearHistory = viewModel::dismissClearHistoryDialog
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    val exhaustionPrompt = uiState.poolExhaustionPrompt
    if (exhaustionPrompt != null) {
        PoolExhaustionDialog(
            prompt = exhaustionPrompt,
            onConfirmShorterQuiz = viewModel::confirmShorterQuizFromExhaustion,
            onConfirmStartNewCycle = viewModel::confirmStartNewCycleFromExhaustion,
            onDismiss = viewModel::dismissPoolExhaustionPrompt
        )
    }
}

@Composable
private fun PoolExhaustionDialog(
    prompt: PoolExhaustionPrompt,
    onConfirmShorterQuiz: () -> Unit,
    onConfirmStartNewCycle: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = Icons.Default.Autorenew,
                contentDescription = null,
                tint = LuminousCyanBright
            )
        },
        title = {
            Text(
                text = if (prompt.unseenCount > 0) {
                    "Unseen Questions Running Low"
                } else {
                    "All Questions Completed in This Cycle"
                },
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.testTag("pool_exhaustion_dialog_title")
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = if (prompt.unseenCount > 0) {
                        "Only ${prompt.unseenCount} unseen ${if (prompt.unseenCount == 1) "question remains" else "questions remain"} in ${prompt.scope.displayName} (${prompt.difficulty.title}), and you requested ${prompt.requestedCount}. You can take a shorter quiz with the remaining unseen questions, or start a new rotation cycle."
                    } else {
                        "You have viewed all ${prompt.totalPoolSize} questions in ${prompt.scope.displayName} (${prompt.difficulty.title}). Start a new rotation cycle to continue practicing this pool."
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.testTag("pool_exhaustion_dialog_message")
                )
                Text(
                    text = "Starting a new cycle only resets question rotation for this pool. Your attempt history, scores, and preferences are preserved.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        confirmButton = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (prompt.unseenCount > 0) {
                    DimensionalButton(
                        text = "Shorter Quiz (${prompt.unseenCount} ${if (prompt.unseenCount == 1) "Question" else "Questions"})",
                        icon = Icons.Default.PlayArrow,
                        onClick = onConfirmShorterQuiz,
                        primaryColor = EmeraldSuccess,
                        secondaryColor = LuminousCyan,
                        modifier = Modifier.fillMaxWidth(),
                        testTag = "exhaustion_shorter_quiz_button"
                    )
                }
                DimensionalButton(
                    text = "Start New Cycle (${prompt.requestedCount} Questions)",
                    icon = Icons.Default.Autorenew,
                    onClick = onConfirmStartNewCycle,
                    primaryColor = ElectricViolet,
                    secondaryColor = WarmAmberAccent,
                    modifier = Modifier.fillMaxWidth(),
                    testTag = "exhaustion_new_cycle_button"
                )
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .testTag("exhaustion_cancel_button")
                ) {
                    Text("Cancel")
                }
            }
        }
    )
}

private fun isDestinationSelected(current: QuizNovaScreen, dest: QuizNovaScreen): Boolean {
    return when {
        current is QuizNovaScreen.Home && dest is QuizNovaScreen.Home -> true
        current is QuizNovaScreen.Progress && dest is QuizNovaScreen.Progress -> true
        (current is QuizNovaScreen.History || current is QuizNovaScreen.AttemptDetail) && dest is QuizNovaScreen.History -> true
        current is QuizNovaScreen.SettingsPrivacy && dest is QuizNovaScreen.SettingsPrivacy -> true
        else -> false
    }
}
