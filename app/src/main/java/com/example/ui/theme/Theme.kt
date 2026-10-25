package com.example.ui.theme

import android.provider.Settings
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.model.ThemePreference

private val QuizNovaDarkColorScheme = darkColorScheme(
    primary = LuminousCyanBright,
    onPrimary = MidnightNavyDeep,
    primaryContainer = ElectricVioletDeep,
    onPrimaryContainer = StarlightTextPrimary,
    secondary = ElectricVioletBright,
    onSecondary = Color.White,
    secondaryContainer = MidnightNavyCardTop,
    onSecondaryContainer = StarlightTextPrimary,
    tertiary = WarmAmberAccent,
    onTertiary = MidnightNavyDeep,
    background = MidnightNavyDeep,
    onBackground = StarlightTextPrimary,
    surface = MidnightNavySurface,
    onSurface = StarlightTextPrimary,
    surfaceVariant = MidnightNavyElevated,
    onSurfaceVariant = StarlightTextSecondary,
    outline = MidnightNavyBorder,
    error = CoralErrorBright
)

private val QuizNovaLightColorScheme = lightColorScheme(
    primary = ElectricViolet,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFEDE9FE),
    onPrimaryContainer = ElectricVioletDeep,
    secondary = LuminousCyanDeep,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFCFFAFE),
    onSecondaryContainer = Color(0xFF083344),
    tertiary = Color(0xFFD97706),
    onTertiary = Color.White,
    background = DaylightBackground,
    onBackground = DaylightTextPrimary,
    surface = DaylightSurface,
    onSurface = DaylightTextPrimary,
    surfaceVariant = DaylightSurfaceElevated,
    onSurfaceVariant = DaylightTextSecondary,
    outline = DaylightBorder,
    error = CoralError
)

data class QuizNovaDesignTokens(
    val isDark: Boolean,
    val reduceMotion: Boolean
)

val LocalQuizNovaTokens = staticCompositionLocalOf {
    QuizNovaDesignTokens(isDark = true, reduceMotion = false)
}

@Composable
fun QuizNovaTheme(
    themePreference: ThemePreference = ThemePreference.DARK,
    reduceMotionPreference: Boolean = false,
    content: @Composable () -> Unit
) {
    val systemDark = isSystemInDarkTheme()
    val useDark = when (themePreference) {
        ThemePreference.SYSTEM -> systemDark
        ThemePreference.DARK -> true
        ThemePreference.LIGHT -> false
    }

    val context = LocalContext.current
    val systemAnimationsDisabled = remember(context) {
        runCatching {
            val scale = Settings.Global.getFloat(
                context.contentResolver,
                Settings.Global.ANIMATOR_DURATION_SCALE,
                1f
            )
            scale == 0f
        }.getOrDefault(false)
    }

    val effectiveReduceMotion = reduceMotionPreference || systemAnimationsDisabled
    val colorScheme = if (useDark) QuizNovaDarkColorScheme else QuizNovaLightColorScheme
    val tokens = QuizNovaDesignTokens(
        isDark = useDark,
        reduceMotion = effectiveReduceMotion
    )

    CompositionLocalProvider(LocalQuizNovaTokens provides tokens) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
