package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.FactCheck
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.domain.AnalyticsModeFilter
import com.example.domain.CategoryAccuracyStat
import com.example.domain.ProgressAnalyticsSnapshot
import com.example.model.AttemptCompletionStatus
import com.example.model.FinalizedAttemptSummary
import com.example.model.QuizMode
import com.example.ui.components.CategoryDimensionalBadge
import com.example.ui.components.DimensionalButton
import com.example.ui.components.DimensionalCard
import com.example.ui.theme.CoralErrorBright
import com.example.ui.theme.ElectricViolet
import com.example.ui.theme.ElectricVioletBright
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.LuminousCyan
import com.example.ui.theme.LuminousCyanBright
import com.example.ui.theme.WarmAmberAccent
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private fun formatEpochMillis(epochMillis: Long): String {
    if (epochMillis <= 0L) return "Unknown date"
    val formatter = SimpleDateFormat("MMM d, yyyy • HH:mm", Locale.US)
    return formatter.format(Date(epochMillis))
}

@Composable
fun ModeFilterRow(
    selectedFilter: AnalyticsModeFilter,
    onSelectFilter: (AnalyticsModeFilter) -> Unit,
    testTagPrefix: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AnalyticsModeFilter.entries.forEach { filter ->
            val selected = selectedFilter == filter
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
                    .clickable(role = Role.Tab) { onSelectFilter(filter) }
                    .padding(vertical = 10.dp, horizontal = 8.dp)
                    .testTag("${testTagPrefix}_${filter.id}"),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = filter.label,
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                    color = if (selected) Color.White else MaterialTheme.colorScheme.onSurface,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
fun ProgressDashboardScreen(
    snapshot: ProgressAnalyticsSnapshot,
    onSelectFilter: (AnalyticsModeFilter) -> Unit,
    onOpenAttemptDetail: (String) -> Unit,
    onStartQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 680.dp)
                .testTag("progress_dashboard_screen"),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item(key = "progress_header") {
                Text(
                    text = "Progress",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            item(key = "progress_filter") {
                ModeFilterRow(
                    selectedFilter = snapshot.filter,
                    onSelectFilter = onSelectFilter,
                    testTagPrefix = "analytics_filter"
                )
            }

            if (snapshot.totalFinalizedAttempts == 0) {
                item(key = "progress_empty_state") {
                    DimensionalCard(
                        accentColor = LuminousCyan,
                        testTag = "progress_empty_state_card"
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Analytics,
                                contentDescription = null,
                                tint = LuminousCyanBright,
                                modifier = Modifier.size(38.dp)
                            )
                            Text(
                                text = "Complete a quiz to see your progress.",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Center
                            )
                            DimensionalButton(
                                text = "Start Quiz",
                                icon = Icons.Default.PlayArrow,
                                onClick = onStartQuiz,
                                modifier = Modifier.fillMaxWidth(),
                                testTag = "empty_progress_start_quiz_button"
                            )
                        }
                    }
                }
            } else {
                // 1. Top KPI Summary Card
                item(key = "kpi_summary") {
                    DimensionalCard(
                        accentColor = ElectricVioletBright,
                        testTag = "analytics_kpi_card"
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            KpiStatBox(
                                title = "Attempts",
                                value = "${snapshot.totalFinalizedAttempts}",
                                color = ElectricVioletBright,
                                modifier = Modifier.weight(1f),
                                testTag = "analytics_attempts_count"
                            )
                            KpiStatBox(
                                title = "Accuracy",
                                value = "${snapshot.overallAccuracyPercentage}%",
                                color = LuminousCyanBright,
                                modifier = Modifier.weight(1f),
                                testTag = "analytics_overall_accuracy"
                            )
                            KpiStatBox(
                                title = "Best",
                                value = "${snapshot.bestScorePercentage}%",
                                color = EmeraldSuccess,
                                modifier = Modifier.weight(1f),
                                testTag = "analytics_best_score"
                            )
                        }
                    }
                }

                // 2. Category Performance Breakdown
                item(key = "category_breakdown") {
                    DimensionalCard(
                        accentColor = LuminousCyan,
                        testTag = "analytics_category_breakdown_card"
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text(
                                text = "Category Accuracy",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            snapshot.categoryStats.forEach { stat ->
                                CategoryBarRow(stat = stat)
                            }
                        }
                    }
                }

                // 3. Recent Performance Trend
                item(key = "recent_trend") {
                    DimensionalCard(
                        accentColor = EmeraldSuccess,
                        testTag = "analytics_recent_trend_card"
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text(
                                text = "Recent Scores",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(132.dp)
                                    .semantics {
                                        contentDescription = snapshot.recentTrendAccessibleSummary
                                    },
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                snapshot.recentPerformance.forEach { pt ->
                                    val barColor = when {
                                        pt.percentage >= 80 -> EmeraldSuccess
                                        pt.percentage >= 50 -> LuminousCyanBright
                                        else -> WarmAmberAccent
                                    }
                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxHeight()
                                            .clickable { onOpenAttemptDetail(pt.attemptId) },
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Bottom
                                    ) {
                                        Text(
                                            text = "${pt.percentage}%",
                                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                            color = barColor
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(0.72f)
                                                .fillMaxHeight(
                                                    (pt.percentage / 100f).coerceIn(0.08f, 0.78f)
                                                )
                                                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                                .background(barColor)
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = pt.scope.category?.badgeCode ?: "MIX",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                            }

                            Text(
                                text = snapshot.recentTrendAccessibleSummary,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.testTag("recent_trend_accessible_text")
                            )
                        }
                    }
                }
            }

            item(key = "progress_bottom_spacer") {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun KpiStatBox(
    title: String,
    value: String,
    color: Color,
    modifier: Modifier = Modifier,
    testTag: String
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color.copy(alpha = 0.12f))
            .padding(vertical = 10.dp, horizontal = 6.dp)
            .testTag(testTag),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = color
        )
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}

@Composable
private fun CategoryBarRow(stat: CategoryAccuracyStat) {
    val primary = Color(stat.category.primaryHex)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("category_bar_${stat.category.id}"),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stat.category.title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = if (stat.totalQuestions > 0) {
                    "${stat.accuracyPercentage}% (${stat.correctCount}/${stat.totalQuestions})"
                } else {
                    "—"
                },
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = if (stat.totalQuestions > 0) primary else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        LinearProgressIndicator(
            progress = {
                if (stat.totalQuestions > 0) (stat.accuracyPercentage / 100f).coerceIn(0f, 1f) else 0f
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(CircleShape),
            color = primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

@Composable
fun AttemptHistoryScreen(
    attempts: List<FinalizedAttemptSummary>,
    selectedFilter: AnalyticsModeFilter,
    onSelectFilter: (AnalyticsModeFilter) -> Unit,
    onOpenAttemptDetail: (String) -> Unit,
    onStartQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    val filteredAttempts = remember(attempts, selectedFilter) {
        when (selectedFilter) {
            AnalyticsModeFilter.ALL -> attempts
            AnalyticsModeFilter.PRACTICE -> attempts.filter { it.mode == QuizMode.PRACTICE }
            AnalyticsModeFilter.CHALLENGE -> attempts.filter { it.mode == QuizMode.CHALLENGE }
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 680.dp)
                .testTag("attempt_history_screen"),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(key = "history_header") {
                Text(
                    text = "History",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            item(key = "history_filter") {
                ModeFilterRow(
                    selectedFilter = selectedFilter,
                    onSelectFilter = onSelectFilter,
                    testTagPrefix = "history_filter"
                )
            }

            if (filteredAttempts.isEmpty()) {
                item(key = "history_empty_state") {
                    DimensionalCard(
                        accentColor = ElectricViolet,
                        testTag = "history_empty_state_card"
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.History,
                                contentDescription = null,
                                tint = ElectricVioletBright,
                                modifier = Modifier.size(38.dp)
                            )
                            Text(
                                text = "No completed quizzes yet.",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface,
                                textAlign = TextAlign.Center
                            )
                            DimensionalButton(
                                text = "Start Quiz",
                                icon = Icons.Default.PlayArrow,
                                onClick = onStartQuiz,
                                modifier = Modifier.fillMaxWidth(),
                                testTag = "empty_history_start_quiz_button"
                            )
                        }
                    }
                }
            } else {
                items(
                    items = filteredAttempts,
                    key = { it.attemptId }
                ) { attempt ->
                    HistoryAttemptCard(
                        attempt = attempt,
                        onClick = { onOpenAttemptDetail(attempt.attemptId) }
                    )
                }
            }

            item(key = "history_bottom_spacer") {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun HistoryAttemptCard(
    attempt: FinalizedAttemptSummary,
    onClick: () -> Unit
) {
    val modeColor = if (attempt.mode == QuizMode.CHALLENGE) WarmAmberAccent else EmeraldSuccess
    val statusColor = when (attempt.completionStatus) {
        AttemptCompletionStatus.COMPLETED_NORMALLY -> EmeraldSuccess
        AttemptCompletionStatus.AUTO_SUBMITTED_FOCUS_LOSS -> WarmAmberAccent
        AttemptCompletionStatus.ENDED_INTERRUPTED_SESSION -> CoralErrorBright
    }

    DimensionalCard(
        accentColor = attempt.scope.category?.let { Color(it.primaryHex) } ?: ElectricVioletBright,
        onClick = onClick,
        testTag = "history_attempt_card_${attempt.attemptId}"
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CategoryDimensionalBadge(category = attempt.scope.category, size = 44.dp)

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = "${attempt.scope.displayName} • ${attempt.difficulty.title}",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = formatEpochMillis(attempt.completedAtEpochMillis),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "${attempt.percentage}%",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = LuminousCyanBright
                    )
                    Text(
                        text = "${attempt.correctCount}/${attempt.totalQuestions}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(modeColor.copy(alpha = 0.14f))
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = if (attempt.mode == QuizMode.CHALLENGE) Icons.Default.Lock else Icons.Default.School,
                            contentDescription = null,
                            tint = modeColor,
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = attempt.mode.title,
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = modeColor
                        )
                    }

                    Text(
                        text = attempt.completionStatus.label,
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                        color = statusColor
                    )
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Open Attempt Details",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
fun AttemptDetailScreen(
    summary: FinalizedAttemptSummary,
    onOpenFullReview: () -> Unit,
    onRetryAttempt: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(onBack = onBack)
    val context = LocalContext.current

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 680.dp)
                .testTag("attempt_detail_screen"),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item(key = "detail_top_bar") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("attempt_detail_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Attempt Details",
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = formatEpochMillis(summary.completedAtEpochMillis),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item(key = "detail_summary_card") {
                DimensionalCard(accentColor = ElectricVioletBright) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = "${summary.scope.displayName} • ${summary.difficulty.title}",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "${summary.mode.title} • ${summary.completionStatus.label}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = LuminousCyanBright
                        )
                        if (summary.completionStatus.bannerMessage != null) {
                            Text(
                                text = summary.completionStatus.bannerMessage,
                                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                                color = WarmAmberAccent
                            )
                        }
                        Text(
                            text = "Score: ${summary.correctCount} / ${summary.totalQuestions} (${summary.percentage}%) • ${summary.correctCount} Correct, ${summary.incorrectCount} Incorrect, ${summary.unansweredCount} Unanswered",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            DimensionalButton(
                                text = "Review",
                                icon = Icons.Default.FactCheck,
                                onClick = onOpenFullReview,
                                modifier = Modifier.weight(1f),
                                testTag = "detail_open_review_button"
                            )
                            DimensionalButton(
                                text = "Try Again",
                                icon = Icons.Default.Refresh,
                                onClick = onRetryAttempt,
                                primaryColor = EmeraldSuccess,
                                secondaryColor = LuminousCyan,
                                modifier = Modifier.weight(1f),
                                testTag = "detail_retry_button"
                            )
                        }

                        DimensionalButton(
                            text = "Share Summary",
                            icon = Icons.Default.Share,
                            onClick = { shareAttemptSummary(context, summary) },
                            primaryColor = Color(0xFF1E293B),
                            secondaryColor = Color(0xFF334155),
                            modifier = Modifier.fillMaxWidth(),
                            testTag = "detail_share_button"
                        )
                    }
                }
            }

            item(key = "detail_questions_header") {
                Text(
                    text = "Questions",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            items(
                items = summary.answers,
                key = { "${summary.attemptId}_detail_q_${it.questionIndex}" }
            ) { record ->
                ReviewQuestionItemCard(record = record)
            }

            item(key = "detail_bottom_spacer") {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
