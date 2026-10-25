package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.ActiveQuizSession
import com.example.model.QuestionOption
import com.example.model.QuizMode
import com.example.model.QuizQuestion
import com.example.ui.components.CodeSnippetBlock
import com.example.ui.components.DimensionalButton
import com.example.ui.components.DimensionalCard
import com.example.ui.theme.CoralError
import com.example.ui.theme.CoralErrorBright
import com.example.ui.theme.ElectricViolet
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.EmeraldSuccessBright
import com.example.ui.theme.LocalQuizNovaTokens
import com.example.ui.theme.LuminousCyan
import com.example.ui.theme.LuminousCyanBright
import com.example.ui.theme.WarmAmberAccent

@Composable
fun QuizSessionScreen(
    session: ActiveQuizSession,
    question: QuizQuestion,
    showAbandonDialog: Boolean,
    onChallengeScreenFocused: () -> Unit,
    onQuestionDisplayed: (String) -> Unit = {},
    onSelectOption: (String) -> Unit,
    onSubmitAnswer: () -> Unit,
    onNextOrFinish: () -> Unit,
    onRequestAbandon: () -> Unit,
    onConfirmAbandon: () -> Unit,
    onDismissAbandon: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(onBack = onRequestAbandon)

    val windowInfo = LocalWindowInfo.current
    LaunchedEffect(session.sessionId, session.mode, windowInfo.isWindowFocused) {
        if (session.mode == QuizMode.CHALLENGE && windowInfo.isWindowFocused) {
            onChallengeScreenFocused()
        }
    }

    // Record question seen only when actually displayed on screen
    LaunchedEffect(session.sessionId, question.id) {
        onQuestionDisplayed(question.id)
    }

    val tokens = LocalQuizNovaTokens.current
    val currentState = session.currentQuestionState ?: return
    val isSubmitted = currentState.isSubmitted
    val selectedOptionId = currentState.selectedOptionId
    val submittedOptionId = currentState.submittedOptionId
    val isLastQuestion = session.currentIndex == session.questions.lastIndex

    val progressFraction = (session.currentIndex + 1).toFloat() / session.totalQuestions.coerceAtLeast(1).toFloat()
    val animatedProgress by animateFloatAsState(
        targetValue = progressFraction,
        animationSpec = if (tokens.reduceMotion) tween(0) else tween(280),
        label = "quiz_progress"
    )

    val orderedOptions: List<QuestionOption> = currentState.shuffledOptionIds.mapNotNull { id ->
        question.optionById(id)
    }

    val scrollState = rememberScrollState()
    LaunchedEffect(session.sessionId, session.currentIndex) {
        scrollState.scrollTo(0)
    }

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
                .testTag("active_quiz_screen"),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // 1. Top Session Bar & Progress
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        IconButton(
                            onClick = onRequestAbandon,
                            modifier = Modifier.testTag("quiz_close_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Exit Quiz"
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "${question.category.shortTitle} • ${question.difficulty.title}",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = "Question ${session.currentIndex + 1} of ${session.totalQuestions}",
                                style = MaterialTheme.typography.labelMedium,
                                color = if (tokens.isDark) LuminousCyanBright else ElectricViolet,
                                modifier = Modifier.testTag("question_counter_text")
                            )
                        }
                    }

                    // Mode Status Pill
                    val modeColor = if (session.mode == QuizMode.CHALLENGE) WarmAmberAccent else EmeraldSuccess
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(modeColor.copy(alpha = 0.14f))
                            .border(
                                width = 1.dp,
                                color = modeColor.copy(alpha = 0.35f),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = if (session.mode == QuizMode.CHALLENGE) Icons.Default.Lock else Icons.Default.School,
                            contentDescription = null,
                            tint = modeColor,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = session.mode.title,
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = modeColor
                        )
                    }
                }

                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(CircleShape)
                        .testTag("quiz_progress_bar"),
                    color = LuminousCyanBright,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            }

            // 2. Question Prompt & Optional Code Snippet (calm, readable surface)
            DimensionalCard(
                accentColor = Color(question.category.primaryHex),
                testTag = "question_prompt_card"
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(
                        text = question.prompt,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.testTag("question_prompt_text")
                    )

                    if (!question.codeSnippet.isNullOrBlank()) {
                        CodeSnippetBlock(
                            code = question.codeSnippet,
                            languageNote = question.languageNote
                        )
                    }
                }
            }

            // 3. Four Option Cards (calm, clear contrast)
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                orderedOptions.forEachIndexed { index, option ->
                    val optionLetter = ('A' + index).toString()
                    val isSelected = selectedOptionId == option.id
                    val isCorrectOption = option.id == question.correctOptionId
                    val isUserSubmittedOption = submittedOptionId == option.id

                    OptionItemCard(
                        optionLetter = optionLetter,
                        optionText = option.text,
                        isSelected = isSelected,
                        isSubmitted = isSubmitted,
                        isCorrectOption = isCorrectOption,
                        isUserSubmittedOption = isUserSubmittedOption,
                        onClick = {
                            if (!isSubmitted) {
                                onSelectOption(option.id)
                            }
                        },
                        testTag = "option_card_$index"
                    )
                }
            }

            // 4. Immediate Feedback & Explanation Banner after Submission
            AnimatedVisibility(
                visible = isSubmitted,
                enter = if (tokens.reduceMotion) fadeIn(tween(0)) else fadeIn(tween(200))
            ) {
                val isCorrect = submittedOptionId == question.correctOptionId
                val correctOptionText = question.optionById(question.correctOptionId)?.text.orEmpty()
                val statusColor = if (isCorrect) EmeraldSuccess else CoralError

                DimensionalCard(
                    accentColor = statusColor,
                    testTag = "answer_feedback_card"
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = if (isCorrect) Icons.Default.CheckCircle else Icons.Default.Cancel,
                                contentDescription = if (isCorrect) "Correct" else "Incorrect",
                                tint = statusColor,
                                modifier = Modifier.size(22.dp)
                            )
                            Text(
                                text = if (isCorrect) "Correct" else "Incorrect",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = statusColor,
                                modifier = Modifier.testTag("feedback_status_title")
                            )
                        }

                        if (!isCorrect) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(EmeraldSuccess.copy(alpha = 0.12f))
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = "Correct Answer",
                                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                    color = EmeraldSuccess
                                )
                                Text(
                                    text = correctOptionText,
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.testTag("feedback_correct_answer_text")
                                )
                            }
                        }

                        Text(
                            text = question.explanation,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.testTag("feedback_explanation_text")
                        )
                    }
                }
            }

            // 5. Explicit Submit / Next / View Results Action Button
            if (!isSubmitted) {
                DimensionalButton(
                    text = stringResource(R.string.action_submit_answer),
                    onClick = onSubmitAnswer,
                    enabled = selectedOptionId != null,
                    primaryColor = ElectricViolet,
                    secondaryColor = LuminousCyan,
                    modifier = Modifier.fillMaxWidth(),
                    testTag = "submit_answer_button"
                )
            } else {
                DimensionalButton(
                    text = if (isLastQuestion) {
                        stringResource(R.string.action_view_results)
                    } else {
                        stringResource(R.string.action_next_question)
                    },
                    icon = if (isLastQuestion) Icons.Default.EmojiEvents else Icons.AutoMirrored.Filled.ArrowForward,
                    onClick = onNextOrFinish,
                    primaryColor = EmeraldSuccess,
                    secondaryColor = LuminousCyan,
                    modifier = Modifier.fillMaxWidth(),
                    testTag = if (isLastQuestion) "view_results_button" else "next_question_button"
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }

    if (showAbandonDialog) {
        val isChallenge = session.mode == QuizMode.CHALLENGE
        AlertDialog(
            onDismissRequest = onDismissAbandon,
            title = {
                Text(
                    text = if (isChallenge) "End Challenge?" else "Leave Quiz?",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            },
            text = {
                Text(
                    text = if (isChallenge) {
                        "Ending a Challenge submits your attempt with the answers already submitted. Unanswered questions receive zero marks."
                    } else {
                        "Leave this Practice quiz and discard your current session?"
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            confirmButton = {
                TextButton(
                    onClick = onConfirmAbandon,
                    modifier = Modifier.testTag("confirm_abandon_button")
                ) {
                    Text(
                        text = if (isChallenge) "End & Submit" else "Leave Quiz",
                        color = CoralErrorBright,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismissAbandon,
                    modifier = Modifier.testTag("cancel_abandon_button")
                ) {
                    Text("Continue")
                }
            }
        )
    }
}

@Composable
private fun OptionItemCard(
    optionLetter: String,
    optionText: String,
    isSelected: Boolean,
    isSubmitted: Boolean,
    isCorrectOption: Boolean,
    isUserSubmittedOption: Boolean,
    onClick: () -> Unit,
    testTag: String
) {
    val borderColor: Color
    val containerBrush: Brush
    val badgeColor: Color

    when {
        !isSubmitted && isSelected -> {
            borderColor = LuminousCyanBright
            containerBrush = Brush.verticalGradient(
                listOf(
                    LuminousCyan.copy(alpha = 0.18f),
                    ElectricViolet.copy(alpha = 0.12f)
                )
            )
            badgeColor = LuminousCyanBright
        }
        !isSubmitted -> {
            borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.30f)
            containerBrush = Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.56f),
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.42f)
                )
            )
            badgeColor = MaterialTheme.colorScheme.outline
        }
        isCorrectOption -> {
            borderColor = EmeraldSuccessBright
            containerBrush = Brush.verticalGradient(
                listOf(
                    EmeraldSuccess.copy(alpha = 0.18f),
                    EmeraldSuccess.copy(alpha = 0.12f)
                )
            )
            badgeColor = EmeraldSuccess
        }
        isUserSubmittedOption && !isCorrectOption -> {
            borderColor = CoralErrorBright
            containerBrush = Brush.verticalGradient(
                listOf(
                    CoralError.copy(alpha = 0.18f),
                    CoralError.copy(alpha = 0.12f)
                )
            )
            badgeColor = CoralError
        }
        else -> {
            borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.20f)
            containerBrush = Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.30f),
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.24f)
                )
            )
            badgeColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.45f)
        }
    }

    val shape = RoundedCornerShape(14.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .minimumInteractiveComponentSize()
            .defaultMinSize(minHeight = 56.dp)
            .clip(shape)
            .background(containerBrush)
            .border(
                width = if (isSelected || (isSubmitted && (isCorrectOption || isUserSubmittedOption))) 1.6.dp else 1.dp,
                color = borderColor,
                shape = shape
            )
            .clickable(
                enabled = !isSubmitted,
                role = Role.RadioButton,
                onClick = onClick
            )
            .padding(horizontal = 14.dp, vertical = 12.dp)
            .testTag(testTag),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(badgeColor.copy(alpha = 0.20f))
                .border(1.dp, badgeColor, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = optionLetter,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = if (isSelected || (isSubmitted && (isCorrectOption || isUserSubmittedOption))) {
                    borderColor
                } else {
                    MaterialTheme.colorScheme.onSurface
                }
            )
        }

        Text(
            text = optionText,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f)
        )

        if (isSubmitted) {
            if (isCorrectOption) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Correct option",
                    tint = EmeraldSuccessBright
                )
            } else if (isUserSubmittedOption) {
                Icon(
                    imageVector = Icons.Default.Cancel,
                    contentDescription = "Your incorrect option",
                    tint = CoralErrorBright
                )
            }
        }
    }
}
