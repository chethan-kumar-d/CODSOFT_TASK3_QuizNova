package com.example

import android.content.res.Configuration
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.QuizNovaApp
import com.example.ui.theme.QuizNovaTheme
import com.example.viewmodel.QuizNovaScreen
import com.example.viewmodel.QuizNovaViewModel

class MainActivity : ComponentActivity() {

    val viewModel: QuizNovaViewModel by viewModels {
        QuizNovaViewModel.provideFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            viewModel.onActivityRestored(
                welcomeCompleted = savedInstanceState.getBoolean(KEY_WELCOME_COMPLETED, false),
                wasInActiveQuiz = savedInstanceState.getBoolean(KEY_WAS_IN_ACTIVE_QUIZ, false)
            )
        }
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            // Apply FLAG_SECURE strictly while an active Challenge quiz is displayed;
            // remove it immediately when leaving so Home, Results, and Progress can be recorded.
            LaunchedEffect(uiState.shouldApplyFlagSecure) {
                if (uiState.shouldApplyFlagSecure) {
                    window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
                } else {
                    window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
                }
            }

            QuizNovaTheme(
                themePreference = uiState.userPreferences.themePreference,
                reduceMotionPreference = uiState.userPreferences.reduceMotion
            ) {
                QuizNovaApp(
                    viewModel = viewModel,
                    isInMultiWindowMode = isInMultiWindowMode
                )
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_WELCOME_COMPLETED, viewModel.hasCompletedWelcome)
        outState.putBoolean(
            KEY_WAS_IN_ACTIVE_QUIZ,
            viewModel.currentScreen.value is QuizNovaScreen.ActiveQuiz
        )
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            viewModel.onChallengeQuizVisibleAndFocused()
        } else {
            viewModel.onChallengeFocusOrForegroundLost(
                isChangingConfigurations = isChangingConfigurations
            )
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.onChallengeFocusOrForegroundLost(
            isChangingConfigurations = isChangingConfigurations
        )
    }

    override fun onMultiWindowModeChanged(isInMultiWindowMode: Boolean, newConfig: Configuration) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig)
        if (isInMultiWindowMode) {
            viewModel.onChallengeFocusOrForegroundLost(
                isChangingConfigurations = isChangingConfigurations
            )
        }
    }

    companion object {
        private const val KEY_WELCOME_COMPLETED = "quiznova_welcome_completed"
        private const val KEY_WAS_IN_ACTIVE_QUIZ = "quiznova_was_in_active_quiz"
    }
}
