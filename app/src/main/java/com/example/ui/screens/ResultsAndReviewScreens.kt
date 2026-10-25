package com.example.ui.screens

import android.content.Context
import android.content.Intent
import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FactCheck
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.AnswerOutcome
import com.example.model.AttemptCompletionStatus
import com.example.model.EvaluatedAnswerRecord
import com.example.model.FinalizedAttemptSummary
import com.example.ui.components.CodeSnippetBlock
import com.example.ui.components.DimensionalButton
import com.example.ui.components.DimensionalCard
import com.example.ui.components.ResultScoreMedallion
import com.example.ui.theme.CoralErrorBright
import com.example.ui.theme.ElectricViolet
import com.example.ui.theme.ElectricVioletBright
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.EmeraldSuccessBright
import com.example.ui.theme.LuminousCyan
import com.example.ui.theme.LuminousCyanBright
import com.example.ui.theme.WarmAmberAccent

fun buildPlainTextShareSummary(summary: FinalizedAttemptSummary): String {
    return buildString {
        appendLine("QuizNova — Programming & Aptitude")
        appendLine("Category: ${summary.scope.displayName} (${summary.difficulty.title})")
        appendLine("Mode: ${summary.mode.title}")
        appendLine("Score: ${summary.correctCount} / ${summary.totalQuestions} (${summary.percentage}%)")
        appendLine("Breakdown: ${summary.correctCount} Correct • ${summary.incorrectCount} Incorrect • ${summary.unansweredCount} Unanswered")
        append("Status: ${summary.completionStatus.label}")
    }
}

fun shareAttemptSummary(context: Context, summary: FinalizedAttemptSummary) {
    val text = buildPlainTextShareSummary(summary)
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "QuizNova Score")
        putExtra(Intent.EXTRA_TEXT, text)
    }
    val chooser = Intent.createChooser(sendIntent, "Share QuizNova Score").apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    runCatching { context.startActivity(chooser) }
}

@Composable
fun ResultsScreen(
    summary: FinalizedAttemptSummary,
    onReviewAnswers: () -> Unit,
    onTryAgain: () -> Unit,
    onGoHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(onBack = onGoHome)
    val context = LocalContext.current
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
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .testTag("results_screen"),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. Auto-Submitted / Interrupted Status Banner (if applicable)
            val statusMessage = summary.completionStatus.bannerMessage
            if (statusMessage != null) {
                DimensionalCard(
                    accentColor = WarmAmberAccent,
                    testTag = "results_status_banner"
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "Submission Notice",
                            tint = WarmAmberAccent,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = statusMessage,
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier
                                .weight(1f)
                                .testTag("results_status_banner_text")
                        )
                    }
                }
            }

            // 2. Main Dimensional Medallion & Summary Card
            DimensionalCard(
                accentColor = ElectricVioletBright,
                testTag = "results_summary_card"
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "${summary.scope.displayName} • ${summary.difficulty.title}",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = LuminousCyanBright,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "${summary.mode.title} • ${summary.completionStatus.label}",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )

                    ResultScoreMedallion(
                        percentage = summary.percentage,
                        scoreText = "${summary.correctCount} / ${summary.totalQuestions}"
                    )

                    // Breakdown Row: Correct, Incorrect, Unanswered
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutcomeStatCard(
                            label = "Correct",
                            count = summary.correctCount,
                            color = EmeraldSuccess,
                            modifier = Modifier.weight(1f),
                            testTag = "results_correct_count"
                        )
                        OutcomeStatCard(
                            label = "Incorrect",
                            count = summary.incorrectCount,
                            color = CoralErrorBright,
                            modifier = Modifier.weight(1f),
                            testTag = "results_incorrect_count"
                        )
                        OutcomeStatCard(
                            label = "Unanswered",
                            count = summary.unansweredCount,
                            color = WarmAmberAccent,
                            modifier = Modifier.weight(1f),
                            testTag = "results_unanswered_count"
                        )
                    }
                }
            }

            // 3. Actions: Review Answers, Try Again, Share, Home
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                DimensionalButton(
                    text = stringResource(R.string.action_review_answers),
                    icon = Icons.Default.FactCheck,
                    onClick = onReviewAnswers,
                    primaryColor = ElectricViolet,
                    secondaryColor = LuminousCyan,
                    modifier = Modifier.fillMaxWidth(),
                    testTag = "review_answers_button"
                )

                BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                    val stackVertically = maxWidth < 360.dp
                    if (stackVertically) {
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            DimensionalButton(
                                text = stringResource(R.string.action_try_again),
                                icon = Icons.Default.Refresh,
                                onClick = onTryAgain,
                                primaryColor = EmeraldSuccess,
                                secondaryColor = LuminousCyan,
                                modifier = Modifier.fillMaxWidth(),
                                testTag = "try_again_button"
                            )
                            DimensionalButton(
                                text = stringResource(R.string.action_share_score),
                                icon = Icons.Default.Share,
                                onClick = { shareAttemptSummary(context, summary) },
                                primaryColor = Color(0xFF1E293B),
                                secondaryColor = Color(0xFF334155),
                                modifier = Modifier.fillMaxWidth(),
                                testTag = "share_results_button"
                            )
                        }
                    } else {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            DimensionalButton(
                                text = stringResource(R.string.action_try_again),
                                icon = Icons.Default.Refresh,
                                onClick = onTryAgain,
                                primaryColor = EmeraldSuccess,
                                secondaryColor = LuminousCyan,
                                modifier = Modifier.weight(1f),
                                testTag = "try_again_button"
                            )

                            DimensionalButton(
                                text = stringResource(R.string.action_share_score),
                                icon = Icons.Default.Share,
                                onClick = { shareAttemptSummary(context, summary) },
                                primaryColor = Color(0xFF1E293B),
                                secondaryColor = Color(0xFF334155),
                                modifier = Modifier.weight(1f),
                                testTag = "share_results_button"
                            )
                        }
                    }
                }

                DimensionalButton(
                    text = stringResource(R.string.action_back_home),
                    icon = Icons.Default.Home,
                    onClick = onGoHome,
                    primaryColor = Color(0xFF312E81),
                    secondaryColor = Color(0xFF1E3A8A),
                    modifier = Modifier.fillMaxWidth(),
                    testTag = "results_home_button"
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
private fun OutcomeStatCard(
    label: String,
    count: Int,
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$count",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = color
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1
        )
    }
}

@Composable
fun AnswerReviewScreen(
    summary: FinalizedAttemptSummary,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(onBack = onBack)

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 680.dp)
                .testTag("answer_review_screen"),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item(key = "review_header") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("review_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Answer Review",
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = "${summary.scope.displayName} • ${summary.correctCount}/${summary.totalQuestions} (${summary.percentage}%)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            if (summary.completionStatus != AttemptCompletionStatus.COMPLETED_NORMALLY) {
                item(key = "review_status_note") {
                    DimensionalCard(accentColor = WarmAmberAccent) {
                        Text(
                            text = summary.completionStatus.bannerMessage ?: summary.completionStatus.label,
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                            color = WarmAmberAccent
                        )
                    }
                }
            }

            items(
                items = summary.answers,
                key = { "${summary.attemptId}_q_${it.questionIndex}" }
            ) { record ->
                ReviewQuestionItemCard(record = record)
            }

            item(key = "review_bottom_spacer") {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun ReviewQuestionItemCard(record: EvaluatedAnswerRecord) {
    val question = record.question
    val (outcomeColor, outcomeIcon, outcomeLabel) = when (record.outcome) {
        AnswerOutcome.CORRECT -> Triple(EmeraldSuccess, Icons.Default.CheckCircle, "Correct")
        AnswerOutcome.INCORRECT -> Triple(CoralErrorBright, Icons.Default.Cancel, "Incorrect")
        AnswerOutcome.UNANSWERED -> Triple(WarmAmberAccent, Icons.Default.HelpOutline, "Unanswered")
    }

    val submittedText = question.optionById(record.submittedOptionId)?.text
    val unsubmittedSelectionText = if (record.submittedOptionId == null && record.selectedOptionId != null) {
        question.optionById(record.selectedOptionId)?.text
    } else null
    val correctText = question.optionById(record.correctOptionId)?.text.orEmpty()

    DimensionalCard(
        accentColor = outcomeColor,
        testTag = "review_question_card_${record.questionIndex}"
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Q${record.questionIndex + 1} • ${question.category.shortTitle}",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                    color = LuminousCyanBright
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = outcomeIcon,
                        contentDescription = outcomeLabel,
                        tint = outcomeColor,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = outcomeLabel,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = outcomeColor
                    )
                }
            }

            Text(
                text = question.prompt,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurface
            )

            if (!question.codeSnippet.isNullOrBlank()) {
                CodeSnippetBlock(
                    code = question.codeSnippet,
                    languageNote = question.languageNote
                )
            }

            // User's Answer Box
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(outcomeColor.copy(alpha = 0.12f))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Your Answer",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = outcomeColor
                )
                Text(
                    text = submittedText ?: if (unsubmittedSelectionText != null) {
                        "Not submitted (selected \"$unsubmittedSelectionText\")"
                    } else {
                        "Not answered"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            if (record.outcome != AnswerOutcome.CORRECT) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(EmeraldSuccess.copy(alpha = 0.12f))
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = "Correct Answer",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = EmeraldSuccessBright
                    )
                    Text(
                        text = correctText,
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Text(
                text = question.explanation,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
