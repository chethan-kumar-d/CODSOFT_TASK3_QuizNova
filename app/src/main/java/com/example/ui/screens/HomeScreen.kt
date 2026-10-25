package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.questions.QuestionBank
import com.example.domain.ProgressAnalyticsSnapshot
import com.example.model.ActiveQuizSession
import com.example.model.FinalizedAttemptSummary
import com.example.model.QuizCategory
import com.example.model.QuizMode
import com.example.model.QuizScope
import com.example.ui.components.CategoryDimensionalBadge
import com.example.ui.components.DimensionalButton
import com.example.ui.components.DimensionalCard
import com.example.ui.components.QuizNova3DEmblem
import com.example.ui.theme.ElectricViolet
import com.example.ui.theme.ElectricVioletBright
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.LocalQuizNovaTokens
import com.example.ui.theme.LuminousCyan
import com.example.ui.theme.LuminousCyanBright
import com.example.ui.theme.WarmAmberAccent

@Composable
fun HomeScreen(
    activeSession: ActiveQuizSession?,
    analyticsSnapshot: ProgressAnalyticsSnapshot,
    interruptedChallengeAttempt: FinalizedAttemptSummary?,
    onDismissInterruptedBanner: () -> Unit,
    onViewAttemptResults: (String) -> Unit,
    onStartQuizSetup: (QuizScope) -> Unit,
    onStartRandomQuiz: () -> Unit,
    onResumePracticeQuiz: () -> Unit,
    onOpenProgress: () -> Unit,
    onOpenHistory: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tokens = LocalQuizNovaTokens.current
    val categories = remember { QuizCategory.entries }
    val listState = rememberLazyListState()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 700.dp)
                .testTag("home_lazy_column"),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // 1. Interrupted Challenge Notification Banner (only when a previous Challenge was interrupted)
            if (interruptedChallengeAttempt != null) {
                item(key = "interrupted_banner") {
                    DimensionalCard(
                        accentColor = WarmAmberAccent,
                        testTag = "interrupted_challenge_banner"
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = null,
                                    tint = WarmAmberAccent,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = "Previous Challenge Ended",
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            Text(
                                text = stringResource(R.string.challenge_interrupted_banner),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                TextButton(onClick = onDismissInterruptedBanner) {
                                    Text("Dismiss")
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                TextButton(
                                    onClick = {
                                        val id = interruptedChallengeAttempt.attemptId
                                        onDismissInterruptedBanner()
                                        onViewAttemptResults(id)
                                    },
                                    modifier = Modifier.testTag("view_interrupted_results_button")
                                ) {
                                    Text("View Score (${interruptedChallengeAttempt.percentage}%)")
                                }
                            }
                        }
                    }
                }
            }

            // 2. Layered 3D Hero Card
            item(key = "hero_section") {
                HeroLandingCard(
                    onStartQuiz = { onStartQuizSetup(QuizScope.PYTHON) },
                    onRandomQuiz = onStartRandomQuiz
                )
            }

            // 3. Active Practice Session Resume Card (if any)
            if (activeSession != null && activeSession.mode == QuizMode.PRACTICE && !activeSession.isFinalized) {
                item(key = "resume_practice_card") {
                    DimensionalCard(
                        accentColor = LuminousCyanBright,
                        onClick = onResumePracticeQuiz,
                        testTag = "resume_practice_session_card"
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(3.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(8.dp)
                                            .clip(CircleShape)
                                            .background(EmeraldSuccess)
                                    )
                                    Text(
                                        text = "Practice in progress",
                                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                        color = if (tokens.isDark) LuminousCyanBright else ElectricViolet
                                    )
                                }
                                Text(
                                    text = "${activeSession.scope.displayName} • ${activeSession.difficulty.title}",
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Question ${activeSession.currentIndex + 1} of ${activeSession.totalQuestions}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(ElectricViolet.copy(alpha = 0.16f))
                                    .padding(horizontal = 12.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    text = "Resume",
                                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                                    color = if (tokens.isDark) LuminousCyanBright else ElectricViolet
                                )
                            }
                        }
                    }
                }
            }

            // 4. Progress Summary or Compact Empty State
            item(key = "progress_summary_section") {
                HomeProgressOverviewCard(
                    snapshot = analyticsSnapshot,
                    onOpenProgress = onOpenProgress,
                    onOpenHistory = onOpenHistory
                )
            }

            // 5. Categories Heading + Dedicated Mixed Quiz Row
            item(key = "categories_header") {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Categories",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    DimensionalButton(
                        text = stringResource(R.string.action_mixed_quiz),
                        icon = Icons.Default.Shuffle,
                        onClick = { onStartQuizSetup(QuizScope.MIXED) },
                        primaryColor = Color(0xFF1E293B),
                        secondaryColor = Color(0xFF334155),
                        modifier = Modifier.fillMaxWidth(),
                        testTag = "configure_mixed_quiz_button"
                    )
                }
            }

            // 6. Compact Category Cards
            items(
                items = categories,
                key = { it.id }
            ) { category ->
                val count = remember(category) {
                    QuestionBank.getQuestionsForCategory(category).size
                }
                val categoryStat = analyticsSnapshot.categoryStats.find { it.category == category }
                CategoryCompactCard(
                    category = category,
                    questionCount = count,
                    accuracyPercent = if ((categoryStat?.totalQuestions ?: 0) > 0) {
                        categoryStat?.accuracyPercentage
                    } else null,
                    onStartClick = {
                        onStartQuizSetup(QuizScope.fromId(category.id))
                    }
                )
            }

            item(key = "bottom_spacer") {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun HeroLandingCard(
    onStartQuiz: () -> Unit,
    onRandomQuiz: () -> Unit
) {
    val heroBackground = Brush.linearGradient(
        colors = listOf(
            Color(0xFF162044),
            Color(0xFF0E162B),
            Color(0xFF1E1642)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 3.dp)
    ) {
        // Subtle 3D Base Lip
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(top = 4.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFF060A16))
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(heroBackground)
                .border(
                    width = 1.dp,
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.18f),
                            ElectricVioletBright.copy(alpha = 0.14f)
                        )
                    ),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                QuizNova3DEmblem(size = 78.dp)

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                        color = LuminousCyanBright
                    )

                    Text(
                        text = stringResource(R.string.hero_headline),
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )

                    Text(
                        text = stringResource(R.string.hero_subtitle),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFCBD5E1)
                    )
                }
            }

            // Stack hero actions vertically on compact widths so "Random Quiz" never clips or ellipses
            BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                val stackVertically = maxWidth < 440.dp
                if (stackVertically) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        DimensionalButton(
                            text = stringResource(R.string.action_start_quiz),
                            icon = Icons.Default.PlayArrow,
                            onClick = onStartQuiz,
                            primaryColor = ElectricViolet,
                            secondaryColor = LuminousCyan,
                            modifier = Modifier.fillMaxWidth(),
                            testTag = "start_quiz_button"
                        )

                        DimensionalButton(
                            text = stringResource(R.string.action_random_quiz),
                            icon = Icons.Default.Shuffle,
                            onClick = onRandomQuiz,
                            primaryColor = Color(0xFF1E293B),
                            secondaryColor = Color(0xFF334155),
                            modifier = Modifier.fillMaxWidth(),
                            testTag = "random_quiz_button"
                        )
                    }
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        DimensionalButton(
                            text = stringResource(R.string.action_start_quiz),
                            icon = Icons.Default.PlayArrow,
                            onClick = onStartQuiz,
                            primaryColor = ElectricViolet,
                            secondaryColor = LuminousCyan,
                            modifier = Modifier.weight(1f),
                            testTag = "start_quiz_button"
                        )

                        DimensionalButton(
                            text = stringResource(R.string.action_random_quiz),
                            icon = Icons.Default.Shuffle,
                            onClick = onRandomQuiz,
                            primaryColor = Color(0xFF1E293B),
                            secondaryColor = Color(0xFF334155),
                            modifier = Modifier.weight(1f),
                            testTag = "random_quiz_button"
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun HomeProgressOverviewCard(
    snapshot: ProgressAnalyticsSnapshot,
    onOpenProgress: () -> Unit,
    onOpenHistory: () -> Unit
) {
    if (snapshot.totalFinalizedAttempts == 0) {
        DimensionalCard(
            accentColor = LuminousCyan,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            testTag = "home_empty_progress_card"
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Analytics,
                    contentDescription = null,
                    tint = LuminousCyanBright,
                    modifier = Modifier.size(22.dp)
                )
                Text(
                    text = "Complete a quiz to see your progress.",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    } else {
        DimensionalCard(
            accentColor = ElectricVioletBright,
            testTag = "home_progress_summary_card"
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Analytics,
                            contentDescription = null,
                            tint = LuminousCyanBright,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "Progress",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                        TextButton(
                            onClick = onOpenProgress,
                            modifier = Modifier.testTag("home_open_analytics_button")
                        ) {
                            Text("Details")
                        }
                        TextButton(
                            onClick = onOpenHistory,
                            modifier = Modifier.testTag("home_open_history_button")
                        ) {
                            Text("History")
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MetricPill(
                        label = "Attempts",
                        value = "${snapshot.totalFinalizedAttempts}",
                        accent = ElectricVioletBright,
                        modifier = Modifier.weight(1f)
                    )
                    MetricPill(
                        label = "Accuracy",
                        value = "${snapshot.overallAccuracyPercentage}%",
                        accent = LuminousCyanBright,
                        modifier = Modifier.weight(1f)
                    )
                    MetricPill(
                        label = "Best",
                        value = "${snapshot.bestScorePercentage}%",
                        accent = EmeraldSuccess,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun MetricPill(
    label: String,
    value: String,
    accent: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f))
            .padding(horizontal = 8.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = accent
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1
        )
    }
}

@Composable
private fun CategoryCompactCard(
    category: QuizCategory,
    questionCount: Int,
    accuracyPercent: Int?,
    onStartClick: () -> Unit
) {
    val primaryColor = Color(category.primaryHex)
    val secondaryColor = Color(category.secondaryHex)

    DimensionalCard(
        accentColor = primaryColor,
        contentPadding = PaddingValues(14.dp),
        onClick = onStartClick,
        testTag = "category_card_${category.id}"
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CategoryDimensionalBadge(category = category, size = 46.dp)

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = category.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                val metaText = if (accuracyPercent != null) {
                    "$questionCount questions • $accuracyPercent% accuracy"
                } else {
                    "$questionCount questions"
                }
                Text(
                    text = metaText,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(primaryColor, secondaryColor)
                        )
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .testTag("start_category_${category.id}"),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Start",
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Start ${category.title}",
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}
