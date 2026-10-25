package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.ThemePreference
import com.example.model.UserPreferences
import com.example.ui.components.DimensionalButton
import com.example.ui.components.DimensionalCard
import com.example.ui.theme.CoralError
import com.example.ui.theme.CoralErrorBright
import com.example.ui.theme.ElectricViolet
import com.example.ui.theme.ElectricVioletBright
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.LuminousCyan
import com.example.ui.theme.LuminousCyanBright
import com.example.ui.theme.WarmAmberAccent

@Composable
fun SettingsAndPrivacyScreen(
    preferences: UserPreferences,
    totalRecordedAttempts: Int,
    showClearHistoryDialog: Boolean,
    onSelectTheme: (ThemePreference) -> Unit,
    onToggleReduceMotion: (Boolean) -> Unit,
    onRequestClearHistory: () -> Unit,
    onConfirmClearHistory: () -> Unit,
    onDismissClearHistory: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expandLocalData by rememberSaveable { mutableStateOf(false) }
    var expandChallengeIntegrity by rememberSaveable { mutableStateOf(false) }
    var expandLimitations by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 680.dp)
                .testTag("settings_privacy_screen"),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item(key = "settings_header") {
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            // 1. Appearance & Motion
            item(key = "appearance_card") {
                DimensionalCard(accentColor = ElectricViolet) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Palette,
                                contentDescription = null,
                                tint = ElectricVioletBright,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Appearance",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            ThemePreference.entries.forEach { theme ->
                                val selected = preferences.themePreference == theme
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .minimumInteractiveComponentSize()
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(
                                            if (selected) {
                                                Brush.horizontalGradient(listOf(ElectricViolet, LuminousCyan))
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
                                        .clickable(role = Role.RadioButton) { onSelectTheme(theme) }
                                        .padding(vertical = 10.dp, horizontal = 6.dp)
                                        .testTag("theme_option_${theme.id}"),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = theme.label,
                                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                                        color = if (selected) Color.White else MaterialTheme.colorScheme.onSurface,
                                        maxLines = 1
                                    )
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 12.dp),
                                verticalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                Text(
                                    text = "Reduce Motion",
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Minimize animations and floating effects.",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Switch(
                                checked = preferences.reduceMotion,
                                onCheckedChange = onToggleReduceMotion,
                                modifier = Modifier.testTag("reduce_motion_switch")
                            )
                        }
                    }
                }
            }

            // 2. Local Data Management
            item(key = "storage_management_card") {
                DimensionalCard(accentColor = CoralErrorBright) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Storage,
                                contentDescription = null,
                                tint = CoralErrorBright,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Local Data",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        Text(
                            text = "$totalRecordedAttempts saved attempt(s) on this device.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        DimensionalButton(
                            text = stringResource(R.string.action_clear_history),
                            icon = Icons.Default.DeleteForever,
                            onClick = onRequestClearHistory,
                            enabled = totalRecordedAttempts > 0,
                            primaryColor = CoralError,
                            secondaryColor = WarmAmberAccent,
                            modifier = Modifier.fillMaxWidth(),
                            testTag = "clear_history_button"
                        )
                    }
                }
            }

            // 3. Privacy & Challenge Mode (Expandable Sections)
            item(key = "privacy_explanation_card") {
                DimensionalCard(
                    accentColor = LuminousCyan,
                    testTag = "privacy_explanation_card"
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.PrivacyTip,
                                contentDescription = null,
                                tint = LuminousCyanBright,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Privacy & Challenge Mode",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        ExpandablePrivacyRow(
                            title = "Offline & Local Storage",
                            body = "QuizNova works offline without accounts, ads, or cloud servers. Your quiz attempts, scores, and preferences are stored only on this device. Clearing history or uninstalling the app removes local records.",
                            expanded = expandLocalData,
                            onToggle = { expandLocalData = !expandLocalData },
                            testTag = "privacy_section_local_storage"
                        )

                        ExpandablePrivacyRow(
                            title = "Challenge Mode Rules",
                            body = "In Challenge mode, keep QuizNova in the foreground until you finish. Leaving the app or losing window focus automatically ends and submits the attempt once using answers already submitted. Unanswered questions receive zero marks.",
                            expanded = expandChallengeIntegrity,
                            onToggle = { expandChallengeIntegrity = !expandChallengeIntegrity },
                            testTag = "privacy_section_challenge_rules"
                        )

                        ExpandablePrivacyRow(
                            title = "Screenshots & Limitations",
                            body = "Screenshots are restricted during Challenge mode where supported, and unrestricted on Home, Results, and Progress. Focus-based submission may also react to legitimate interruptions (such as calls, notifications, or system panels) and cannot guarantee complete cheat prevention or block external devices. QuizNova never requests accessibility, device admin, or usage-monitoring permissions.",
                            expanded = expandLimitations,
                            onToggle = { expandLimitations = !expandLimitations },
                            testTag = "privacy_section_limitations"
                        )
                    }
                }
            }

            // 4. Compact About Section
            item(key = "about_author_card") {
                DimensionalCard(
                    accentColor = EmeraldSuccess,
                    testTag = "author_credit_card"
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "QuizNova",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Programming & Aptitude",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "Developed by Chethan Kumar D",
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                            color = LuminousCyanBright
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }

    if (showClearHistoryDialog) {
        AlertDialog(
            onDismissRequest = onDismissClearHistory,
            title = {
                Text(
                    text = "Clear History?",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            },
            text = {
                Text(
                    text = "Delete all $totalRecordedAttempts saved attempt(s) from this device? This cannot be undone.",
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            confirmButton = {
                TextButton(
                    onClick = onConfirmClearHistory,
                    modifier = Modifier.testTag("confirm_clear_history_button")
                ) {
                    Text(
                        text = "Clear History",
                        color = CoralErrorBright,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismissClearHistory,
                    modifier = Modifier.testTag("cancel_clear_history_button")
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun ExpandablePrivacyRow(
    title: String,
    body: String,
    expanded: Boolean,
    onToggle: () -> Unit,
    testTag: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f))
            .clickable(role = Role.Button, onClick = onToggle)
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .testTag(testTag),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = if (expanded) "Collapse" else "Expand",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        AnimatedVisibility(visible = expanded) {
            Text(
                text = body,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
