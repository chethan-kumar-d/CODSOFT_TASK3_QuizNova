package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.QuizDifficulty
import com.example.model.QuizMode
import com.example.model.QuizScope
import com.example.ui.components.CategoryDimensionalBadge
import com.example.ui.components.DimensionalButton
import com.example.ui.components.DimensionalCard
import com.example.ui.theme.CoralError
import com.example.ui.theme.ElectricViolet
import com.example.ui.theme.ElectricVioletBright
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.LocalQuizNovaTokens
import com.example.ui.theme.LuminousCyan
import com.example.ui.theme.LuminousCyanBright
import com.example.ui.theme.WarmAmberAccent
import com.example.viewmodel.QuizSetupConfig

@Composable
fun QuizSetupScreen(
    config: QuizSetupConfig,
    unseenMatchingPoolSize: Int = config.matchingPoolSize,
    isInMultiWindowMode: Boolean,
    onSelectScope: (QuizScope) -> Unit,
    onSelectDifficulty: (QuizDifficulty) -> Unit,
    onSelectCount: (Int) -> Unit,
    onSelectMode: (QuizMode) -> Unit,
    onRequestStart: (Boolean) -> Unit,
    onConfirmBeginChallenge: (Boolean) -> Unit,
    onSwitchToPracticeAndBegin: () -> Unit,
    onDismissChallengeConsent: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tokens = LocalQuizNovaTokens.current
    val availableCounts = config.availableQuestionCounts
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 680.dp)
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .testTag("quiz_setup_screen"),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Top Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.testTag("setup_back_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = "Quiz Setup",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            // 1. Category Section
            DimensionalCard(accentColor = ElectricViolet) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Category",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        QuizScope.entries.forEach { scope ->
                            val selected = config.scope == scope
                            val accent = scope.category?.let { Color(it.primaryHex) } ?: ElectricVioletBright
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .minimumInteractiveComponentSize()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(
                                        if (selected) accent.copy(alpha = 0.14f)
                                        else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
                                    )
                                    .border(
                                        width = if (selected) 1.5.dp else 1.dp,
                                        color = if (selected) accent else MaterialTheme.colorScheme.outline.copy(alpha = 0.25f),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clickable(role = Role.RadioButton) { onSelectScope(scope) }
                                    .padding(horizontal = 12.dp, vertical = 10.dp)
                                    .testTag("setup_scope_${scope.id}"),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                CategoryDimensionalBadge(category = scope.category, size = 36.dp)
                                Text(
                                    text = scope.displayName,
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )
                                if (selected) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Selected",
                                        tint = accent,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 2. Difficulty Section (Foundation, Applied, Advanced + short explanation for selected only)
            DimensionalCard(accentColor = LuminousCyan) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Difficulty",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                        val stackVertically = maxWidth < 340.dp
                        if (stackVertically) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                QuizDifficulty.entries.forEach { diff ->
                                    DifficultyChoicePill(
                                        diff = diff,
                                        selected = config.difficulty == diff,
                                        onClick = { onSelectDifficulty(diff) },
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        } else {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                QuizDifficulty.entries.forEach { diff ->
                                    DifficultyChoicePill(
                                        diff = diff,
                                        selected = config.difficulty == diff,
                                        onClick = { onSelectDifficulty(diff) },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                        }
                    }

                    Text(
                        text = config.difficulty.detail,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.testTag("selected_difficulty_explanation")
                    )
                }
            }

            // 3. Questions Section ("5", "10", "15" with equal widths, consistent heights, centred text)
            DimensionalCard(accentColor = ElectricVioletBright) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Questions",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "$unseenMatchingPoolSize / ${config.matchingPoolSize} unseen",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                            color = if (tokens.isDark) LuminousCyanBright else ElectricViolet,
                            modifier = Modifier.testTag("setup_unseen_pool_badge")
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        availableCounts.forEach { count ->
                            val selected = config.questionCount == count
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .minimumInteractiveComponentSize()
                                    .defaultMinSize(minHeight = 48.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(
                                        if (selected) {
                                            Brush.horizontalGradient(
                                                listOf(ElectricViolet, LuminousCyan)
                                            )
                                        } else {
                                            Brush.horizontalGradient(
                                                listOf(
                                                    MaterialTheme.colorScheme.surfaceVariant,
                                                    MaterialTheme.colorScheme.surfaceVariant
                                                )
                                            )
                                        }
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = if (selected) Color.White.copy(alpha = 0.35f)
                                        else MaterialTheme.colorScheme.outline.copy(alpha = 0.25f),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clickable(role = Role.RadioButton) { onSelectCount(count) }
                                    .padding(vertical = 12.dp, horizontal = 8.dp)
                                    .testTag("setup_count_$count"),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$count",
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = if (selected) Color.White else MaterialTheme.colorScheme.onSurface,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }

            // 4. Mode Section (Concise descriptions for Practice & Challenge)
            DimensionalCard(
                accentColor = if (config.mode == QuizMode.CHALLENGE) WarmAmberAccent else EmeraldSuccess
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Mode",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        QuizMode.entries.forEach { mode ->
                            val selected = config.mode == mode
                            val modeColor = if (mode == QuizMode.PRACTICE) EmeraldSuccess else WarmAmberAccent
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .minimumInteractiveComponentSize()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(
                                        if (selected) modeColor.copy(alpha = 0.14f)
                                        else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
                                    )
                                    .border(
                                        width = if (selected) 1.5.dp else 1.dp,
                                        color = if (selected) modeColor else MaterialTheme.colorScheme.outline.copy(alpha = 0.25f),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clickable(role = Role.RadioButton) { onSelectMode(mode) }
                                    .padding(12.dp)
                                    .testTag("setup_mode_${mode.id}"),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Icon(
                                    imageVector = if (mode == QuizMode.PRACTICE) Icons.Default.School else Icons.Default.Security,
                                    contentDescription = null,
                                    tint = modeColor,
                                    modifier = Modifier.size(22.dp)
                                )
                                Column(
                                    modifier = Modifier.weight(1f),
                                    verticalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    Text(
                                        text = mode.title,
                                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = mode.summary,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                                if (selected) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Selected",
                                        tint = modeColor,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                        }
                    }

                    // Multi-window rejection banner if applicable
                    if (config.multiWindowRejectionMessage != null) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(CoralError.copy(alpha = 0.14f))
                                .border(1.dp, CoralError.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                                .padding(12.dp)
                                .testTag("multiwindow_rejection_card"),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Warning,
                                    contentDescription = null,
                                    tint = CoralError,
                                    modifier = Modifier.size(18.dp)
                                )
                                Text(
                                    text = "Multi-Window Detected",
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = CoralError
                                )
                            }
                            Text(
                                text = config.multiWindowRejectionMessage,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            TextButton(
                                onClick = onSwitchToPracticeAndBegin,
                                modifier = Modifier.testTag("multiwindow_switch_to_practice_button")
                            ) {
                                Text("Switch to Practice Mode")
                            }
                        }
                    }
                }
            }

            // 5. Launch Action
            val buttonText = if (config.mode == QuizMode.CHALLENGE) {
                stringResource(R.string.action_begin_challenge)
            } else {
                stringResource(R.string.action_begin_practice)
            }
            DimensionalButton(
                text = buttonText,
                icon = if (config.mode == QuizMode.CHALLENGE) Icons.Default.Lock else Icons.Default.PlayArrow,
                onClick = { onRequestStart(isInMultiWindowMode) },
                primaryColor = if (config.mode == QuizMode.CHALLENGE) WarmAmberAccent else ElectricViolet,
                secondaryColor = if (config.mode == QuizMode.CHALLENGE) CoralError else LuminousCyan,
                modifier = Modifier.fillMaxWidth(),
                testTag = "launch_configured_quiz_button"
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }

    // Challenge Consent Dialog (immediately before starting Challenge)
    if (config.showChallengeConsentDialog) {
        AlertDialog(
            onDismissRequest = onDismissChallengeConsent,
            icon = {
                Icon(
                    imageVector = Icons.Default.Security,
                    contentDescription = null,
                    tint = WarmAmberAccent
                )
            },
            title = {
                Text(
                    text = "Start Challenge Mode?",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = stringResource(R.string.challenge_integrity_notice),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.testTag("challenge_consent_notice_text")
                    )
                    Text(
                        text = stringResource(R.string.challenge_screenshot_notice),
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
                    DimensionalButton(
                        text = "Begin Challenge",
                        icon = Icons.Default.Lock,
                        onClick = { onConfirmBeginChallenge(isInMultiWindowMode) },
                        primaryColor = WarmAmberAccent,
                        secondaryColor = CoralError,
                        modifier = Modifier.fillMaxWidth(),
                        testTag = "confirm_begin_challenge_button"
                    )
                    DimensionalButton(
                        text = "Use Practice Mode",
                        icon = Icons.Default.School,
                        onClick = onSwitchToPracticeAndBegin,
                        primaryColor = ElectricViolet,
                        secondaryColor = LuminousCyan,
                        modifier = Modifier.fillMaxWidth(),
                        testTag = "consent_switch_practice_button"
                    )
                    TextButton(
                        onClick = onDismissChallengeConsent,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("Cancel")
                    }
                }
            }
        )
    }
}

@Composable
private fun DifficultyChoicePill(
    diff: QuizDifficulty,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val diffAccent = when (diff) {
        QuizDifficulty.FOUNDATION -> EmeraldSuccess
        QuizDifficulty.APPLIED -> LuminousCyanBright
        QuizDifficulty.ADVANCED -> WarmAmberAccent
    }
    Box(
        modifier = modifier
            .minimumInteractiveComponentSize()
            .defaultMinSize(minHeight = 48.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (selected) diffAccent.copy(alpha = 0.16f)
                else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
            )
            .border(
                width = if (selected) 1.5.dp else 1.dp,
                color = if (selected) diffAccent else MaterialTheme.colorScheme.outline.copy(alpha = 0.25f),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(role = Role.RadioButton, onClick = onClick)
            .padding(vertical = 12.dp, horizontal = 8.dp)
            .testTag("setup_difficulty_${diff.id}"),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = diff.title,
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
            color = if (selected) diffAccent else MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}
