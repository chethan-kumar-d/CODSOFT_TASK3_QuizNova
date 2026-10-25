package com.example.ui.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.ui.components.DimensionalButton
import com.example.ui.components.QuizNova3DEmblem
import com.example.ui.theme.ElectricViolet
import com.example.ui.theme.ElectricVioletBright
import com.example.ui.theme.LocalQuizNovaTokens
import com.example.ui.theme.LuminousCyan
import com.example.ui.theme.LuminousCyanBright

@Composable
fun WelcomeScreen(
    onGetStarted: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tokens = LocalQuizNovaTokens.current
    val reduceMotion = tokens.reduceMotion

    var entered by remember { mutableStateOf(reduceMotion) }
    LaunchedEffect(reduceMotion) {
        entered = true
    }

    val entranceProgress by animateFloatAsState(
        targetValue = if (entered || reduceMotion) 1f else 0f,
        animationSpec = if (reduceMotion) {
            tween(durationMillis = 0)
        } else {
            tween(durationMillis = 280, easing = FastOutSlowInEasing)
        },
        label = "welcome_entrance"
    )

    val midnightBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF040712),
            Color(0xFF0A1026),
            Color(0xFF140E30),
            Color(0xFF050814)
        )
    )

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(midnightBrush)
            .testTag("welcome_screen")
    ) {
        val isCompactHeight = maxHeight < 600.dp
        val isCompactWidth = maxWidth < 360.dp
        val emblemSize: Dp = when {
            isCompactHeight -> 126.dp
            isCompactWidth -> 140.dp
            else -> 168.dp
        }
        val haloOuterSize: Dp = emblemSize + if (isCompactHeight) 50.dp else 72.dp
        val haloInnerSize: Dp = emblemSize + if (isCompactHeight) 24.dp else 34.dp

        // Layered Midnight Lighting & Depth Backdrop
        WelcomeLightingBackdrop(reduceMotion = reduceMotion)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = if (isCompactWidth) 20.dp else 28.dp,
                    vertical = if (isCompactHeight) 20.dp else 36.dp
                )
                .graphicsLayer {
                    alpha = entranceProgress
                    translationY = (1f - entranceProgress) * 18f
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(if (isCompactHeight) 4.dp else 16.dp))

            // Centrepiece: Layered 3D Q Emblem Stage + Title + Headline + Supporting Line
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 460.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WelcomeDimensionalEmblemStage(
                    emblemSize = emblemSize,
                    haloOuterSize = haloOuterSize,
                    haloInnerSize = haloInnerSize
                )

                Spacer(modifier = Modifier.height(if (isCompactHeight) 20.dp else 32.dp))

                // Prominent "QuizNova" Title Badge & Wordmark
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 6.dp,
                            shape = RoundedCornerShape(50),
                            ambientColor = Color.Black.copy(alpha = 0.45f),
                            spotColor = ElectricViolet.copy(alpha = 0.35f)
                        )
                        .clip(RoundedCornerShape(50))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF172042).copy(alpha = 0.92f),
                                    Color(0xFF1C1542).copy(alpha = 0.92f)
                                )
                            )
                        )
                        .border(
                            width = 1.dp,
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.White.copy(alpha = 0.28f),
                                    LuminousCyanBright.copy(alpha = 0.35f),
                                    ElectricVioletBright.copy(alpha = 0.22f)
                                )
                            ),
                            shape = RoundedCornerShape(50)
                        )
                        .padding(horizontal = 22.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                        color = LuminousCyanBright,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.testTag("welcome_app_title")
                    )
                }

                Spacer(modifier = Modifier.height(if (isCompactHeight) 14.dp else 20.dp))

                // Headline: "Challenge your mind."
                Text(
                    text = stringResource(R.string.hero_headline),
                    style = if (isCompactWidth) {
                        MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold)
                    } else {
                        MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.ExtraBold)
                    },
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("welcome_headline")
                )

                Spacer(modifier = Modifier.height(if (isCompactHeight) 8.dp else 12.dp))

                // Supporting Line: "Learn. Practice. Improve."
                Text(
                    text = stringResource(R.string.welcome_subtitle),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color(0xFFCBD5E1),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("welcome_subtitle")
                )
            }

            Spacer(modifier = Modifier.height(if (isCompactHeight) 20.dp else 32.dp))

            // Bottom Action Area: Large "Get Started" Button
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 420.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DimensionalButton(
                    text = stringResource(R.string.action_get_started),
                    icon = Icons.AutoMirrored.Filled.ArrowForward,
                    onClick = onGetStarted,
                    primaryColor = ElectricViolet,
                    secondaryColor = LuminousCyan,
                    modifier = Modifier.fillMaxWidth(),
                    testTag = "welcome_get_started_button"
                )
            }
        }
    }
}

@Composable
private fun WelcomeDimensionalEmblemStage(
    emblemSize: Dp,
    haloOuterSize: Dp,
    haloInnerSize: Dp
) {
    Box(
        modifier = Modifier
            .size(haloOuterSize)
            .testTag("welcome_emblem_stage"),
        contentAlignment = Alignment.Center
    ) {
        // Outer Ambient 3D Halo Ring
        Box(
            modifier = Modifier
                .size(haloOuterSize)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            ElectricViolet.copy(alpha = 0.25f),
                            LuminousCyan.copy(alpha = 0.12f),
                            Color.Transparent
                        )
                    )
                )
                .border(
                    width = 1.dp,
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.20f),
                            ElectricVioletBright.copy(alpha = 0.14f),
                            Color.Transparent
                        )
                    ),
                    shape = CircleShape
                )
        )

        // Sculpted Inner Pedestal Disc with Top Specular Highlight & Depth Shadow
        Box(
            modifier = Modifier
                .size(haloInnerSize)
                .shadow(
                    elevation = 10.dp,
                    shape = CircleShape,
                    ambientColor = Color.Black.copy(alpha = 0.65f),
                    spotColor = ElectricViolet.copy(alpha = 0.35f)
                )
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF1A254B).copy(alpha = 0.92f),
                            Color(0xFF0A1024).copy(alpha = 0.96f)
                        )
                    )
                )
                .border(
                    width = 1.5.dp,
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.32f),
                            LuminousCyanBright.copy(alpha = 0.36f),
                            ElectricVioletBright.copy(alpha = 0.20f),
                            Color(0xFF050814).copy(alpha = 0.65f)
                        )
                    ),
                    shape = CircleShape
                )
        )

        // Large Original 3D QuizNova Q Emblem (with built-in floating motion & Reduce Motion support)
        QuizNova3DEmblem(size = emblemSize)
    }
}

@Composable
private fun WelcomeLightingBackdrop(
    reduceMotion: Boolean
) {
    val pulseFactor = if (reduceMotion) {
        1f
    } else {
        val infiniteTransition = rememberInfiniteTransition(label = "welcome_ambient_glow")
        val animated by infiniteTransition.animateFloat(
            initialValue = 0.93f,
            targetValue = 1.07f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 3600, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "glow_scale"
        )
        animated
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        val minDim = minOf(w, h)

        // Upper-left Electric Violet volumetric glow
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    ElectricViolet.copy(alpha = 0.30f),
                    ElectricViolet.copy(alpha = 0.10f),
                    Color.Transparent
                ),
                center = Offset(w * 0.28f, h * 0.24f),
                radius = minDim * 0.72f * pulseFactor
            ),
            radius = minDim * 0.72f * pulseFactor,
            center = Offset(w * 0.28f, h * 0.24f)
        )

        // Lower-right Luminous Cyan volumetric glow
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    LuminousCyan.copy(alpha = 0.24f),
                    LuminousCyan.copy(alpha = 0.07f),
                    Color.Transparent
                ),
                center = Offset(w * 0.76f, h * 0.62f),
                radius = minDim * 0.68f * pulseFactor
            ),
            radius = minDim * 0.68f * pulseFactor,
            center = Offset(w * 0.76f, h * 0.62f)
        )

        // Subtle geometric depth rings around the upper-center stage
        val stageCenter = Offset(w * 0.5f, h * 0.34f)
        drawCircle(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.08f),
                    LuminousCyanBright.copy(alpha = 0.04f),
                    Color.Transparent
                )
            ),
            radius = minDim * 0.46f,
            center = stageCenter,
            style = Stroke(width = 1.2.dp.toPx())
        )

        drawCircle(
            brush = Brush.verticalGradient(
                colors = listOf(
                    ElectricVioletBright.copy(alpha = 0.08f),
                    Color.Transparent
                )
            ),
            radius = minDim * 0.60f,
            center = stageCenter,
            style = Stroke(width = 1.dp.toPx())
        )
    }
}
