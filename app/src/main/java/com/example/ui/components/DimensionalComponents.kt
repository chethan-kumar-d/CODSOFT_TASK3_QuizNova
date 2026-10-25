package com.example.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.QuizCategory
import com.example.ui.theme.CoralError
import com.example.ui.theme.ElectricViolet
import com.example.ui.theme.ElectricVioletBright
import com.example.ui.theme.ElectricVioletDeep
import com.example.ui.theme.EmeraldSuccess
import com.example.ui.theme.JetBrainsMonoFontFamily
import com.example.ui.theme.LocalQuizNovaTokens
import com.example.ui.theme.LuminousCyan
import com.example.ui.theme.LuminousCyanBright
import com.example.ui.theme.MidnightNavyBorder
import com.example.ui.theme.MidnightNavyCardTop
import com.example.ui.theme.MidnightNavyDeep
import com.example.ui.theme.MidnightNavyElevated
import com.example.ui.theme.WarmAmberAccent
import com.example.ui.theme.WarmAmberSoft

/**
 * Original 3D-style QuizNova Q Emblem with multi-layered sculpted depth, bevelled inner recess,
 * controlled specular lighting, and subtle vertical floating motion (disabled when Reduce Motion is enabled).
 */
@Composable
fun QuizNova3DEmblem(
    modifier: Modifier = Modifier,
    size: Dp = 84.dp
) {
    val tokens = LocalQuizNovaTokens.current
    val floatOffsetDp = if (tokens.reduceMotion) {
        0f
    } else {
        val infiniteTransition = rememberInfiniteTransition(label = "emblem_float")
        val offset by infiniteTransition.animateFloat(
            initialValue = -3.0f,
            targetValue = 3.0f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 3000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "emblem_vertical_float"
        )
        offset
    }

    Box(
        modifier = modifier
            .size(size)
            .semantics { contentDescription = "QuizNova 3D Q Emblem" },
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(size)
                .graphicsLayer {
                    translationY = floatOffsetDp.dp.toPx()
                }
        ) {
            val w = this.size.width
            val h = this.size.height
            val center = Offset(w * 0.47f, h * 0.47f)
            val outerR = w * 0.335f

            // 1. Soft controlled volumetric aura behind the pedestal
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        ElectricViolet.copy(alpha = 0.32f),
                        LuminousCyan.copy(alpha = 0.14f),
                        Color.Transparent
                    ),
                    center = Offset(w * 0.5f, h * 0.5f),
                    radius = w * 0.49f
                ),
                radius = w * 0.49f,
                center = Offset(w * 0.5f, h * 0.5f)
            )

            // 2. 3D Extruded Base Pedestal: contact shadow + bevelled side wall + sculpted top face
            drawRoundRect(
                color = Color(0xFF03060F).copy(alpha = 0.85f),
                topLeft = Offset(w * 0.11f, h * 0.165f),
                size = Size(w * 0.78f, h * 0.78f),
                cornerRadius = CornerRadius(w * 0.24f, w * 0.24f)
            )
            drawRoundRect(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0E172E),
                        Color(0xFF070C1B)
                    )
                ),
                topLeft = Offset(w * 0.11f, h * 0.135f),
                size = Size(w * 0.78f, h * 0.78f),
                cornerRadius = CornerRadius(w * 0.24f, w * 0.24f)
            )
            drawRoundRect(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF273554),
                        Color(0xFF131C35),
                        Color(0xFF1B153C)
                    ),
                    start = Offset(w * 0.1f, h * 0.1f),
                    end = Offset(w * 0.9f, h * 0.9f)
                ),
                topLeft = Offset(w * 0.11f, h * 0.095f),
                size = Size(w * 0.78f, h * 0.78f),
                cornerRadius = CornerRadius(w * 0.24f, w * 0.24f)
            )

            // Inner recessed chamber inside the pedestal for realistic 3D depth
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF070B18),
                        Color(0xFF111A32)
                    ),
                    center = center,
                    radius = outerR * 0.95f
                ),
                radius = outerR * 0.92f,
                center = center
            )

            // Subtle top-left specular bevel on pedestal rim
            drawRoundRect(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.36f),
                        LuminousCyanBright.copy(alpha = 0.24f),
                        ElectricViolet.copy(alpha = 0.10f)
                    ),
                    start = Offset(w * 0.1f, h * 0.1f),
                    end = Offset(w * 0.9f, h * 0.9f)
                ),
                topLeft = Offset(w * 0.11f, h * 0.095f),
                size = Size(w * 0.78f, h * 0.78f),
                cornerRadius = CornerRadius(w * 0.24f, w * 0.24f),
                style = Stroke(width = w * 0.016f)
            )

            // 3. Deep 3D Extruded Shadow & Lower Sidewall of the Q torus
            drawCircle(
                color = Color(0xFF050814),
                radius = outerR * 0.73f,
                center = Offset(center.x + w * 0.026f, center.y + h * 0.048f),
                style = Stroke(width = w * 0.138f)
            )
            drawCircle(
                color = ElectricVioletDeep.copy(alpha = 0.90f),
                radius = outerR * 0.73f,
                center = Offset(center.x + w * 0.014f, center.y + h * 0.026f),
                style = Stroke(width = w * 0.132f)
            )

            // 4. Main Sculpted Q Torus Ring with multi-stop directional lighting
            drawCircle(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        LuminousCyanBright,
                        ElectricVioletBright,
                        ElectricViolet,
                        Color(0xFF4338CA),
                        LuminousCyan,
                        LuminousCyanBright
                    ),
                    center = center
                ),
                radius = outerR * 0.73f,
                center = center,
                style = Stroke(width = w * 0.125f)
            )

            // Inner bevel ring on the Q torus
            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.35f),
                        Color.White.copy(alpha = 0.22f)
                    ),
                    start = Offset(center.x - outerR * 0.5f, center.y - outerR * 0.5f),
                    end = Offset(center.x + outerR * 0.5f, center.y + outerR * 0.5f)
                ),
                radius = outerR * 0.54f,
                center = center,
                style = Stroke(width = w * 0.012f)
            )

            // Top-left specular highlight arc on the Q ring
            drawArc(
                color = Color.White.copy(alpha = 0.58f),
                startAngle = 198f,
                sweepAngle = 84f,
                useCenter = false,
                topLeft = Offset(
                    center.x - outerR * 0.73f,
                    center.y - outerR * 0.73f
                ),
                size = Size(outerR * 1.46f, outerR * 1.46f),
                style = Stroke(width = w * 0.024f, cap = StrokeCap.Round)
            )

            // 5. Sculpted 3D Q Tail with cast shadow, extruded sidewall, and top bevel facet
            val tailShadowPath = Path().apply {
                moveTo(w * 0.53f, h * 0.575f)
                lineTo(w * 0.625f, h * 0.50f)
                lineTo(w * 0.785f, h * 0.685f)
                lineTo(w * 0.69f, h * 0.755f)
                close()
            }
            drawPath(
                path = tailShadowPath,
                color = Color(0xFF050915)
            )

            val tailExtrusionPath = Path().apply {
                moveTo(w * 0.52f, h * 0.555f)
                lineTo(w * 0.61f, h * 0.485f)
                lineTo(w * 0.77f, h * 0.665f)
                lineTo(w * 0.68f, h * 0.735f)
                close()
            }
            drawPath(
                path = tailExtrusionPath,
                color = ElectricVioletDeep
            )

            val tailPath = Path().apply {
                moveTo(w * 0.508f, h * 0.538f)
                lineTo(w * 0.60f, h * 0.468f)
                lineTo(w * 0.762f, h * 0.648f)
                lineTo(w * 0.67f, h * 0.718f)
                close()
            }
            drawPath(
                path = tailPath,
                brush = Brush.linearGradient(
                    colors = listOf(LuminousCyanBright, ElectricVioletBright),
                    start = Offset(w * 0.51f, h * 0.47f),
                    end = Offset(w * 0.76f, h * 0.72f)
                )
            )

            // Specular ridge along the top edge of the Q tail
            drawLine(
                color = Color.White.copy(alpha = 0.52f),
                start = Offset(w * 0.595f, h * 0.476f),
                end = Offset(w * 0.750f, h * 0.645f),
                strokeWidth = w * 0.015f,
                cap = StrokeCap.Round
            )

            // 6. Radiant 4-Point Nova Spark Accent (upper right)
            val sparkCx = w * 0.675f
            val sparkCy = h * 0.335f
            val sparkOuter = w * 0.145f
            val sparkInner = w * 0.042f
            val sparkPath = Path().apply {
                moveTo(sparkCx, sparkCy - sparkOuter)
                lineTo(sparkCx + sparkInner, sparkCy - sparkInner)
                lineTo(sparkCx + sparkOuter, sparkCy)
                lineTo(sparkCx + sparkInner, sparkCy + sparkInner)
                lineTo(sparkCx, sparkCy + sparkOuter)
                lineTo(sparkCx - sparkInner, sparkCy + sparkInner)
                lineTo(sparkCx - sparkOuter, sparkCy)
                lineTo(sparkCx - sparkInner, sparkCy - sparkInner)
                close()
            }
            drawPath(
                path = sparkPath,
                brush = Brush.linearGradient(
                    colors = listOf(WarmAmberSoft, WarmAmberAccent, LuminousCyanBright),
                    start = Offset(sparkCx - sparkOuter, sparkCy - sparkOuter),
                    end = Offset(sparkCx + sparkOuter, sparkCy + sparkOuter)
                )
            )
            drawCircle(
                color = Color.White,
                radius = w * 0.022f,
                center = Offset(sparkCx, sparkCy)
            )
        }
    }
}

/**
 * Refined dimensional surface card with layered depth, realistic soft shadows,
 * restrained top specular highlight, and gentle press animation.
 */
@Composable
fun DimensionalCard(
    modifier: Modifier = Modifier,
    accentColor: Color = ElectricViolet,
    cornerRadius: Dp = 18.dp,
    depthOffset: Dp = 2.5.dp,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    onClick: (() -> Unit)? = null,
    testTag: String? = null,
    content: @Composable BoxScope.() -> Unit
) {
    val tokens = LocalQuizNovaTokens.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val pressOffset by animateFloatAsState(
        targetValue = if (isPressed && onClick != null && !tokens.reduceMotion) 1f else 0f,
        animationSpec = spring(stiffness = 650f),
        label = "card_press"
    )

    val pressScale by animateFloatAsState(
        targetValue = if (isPressed && onClick != null && !tokens.reduceMotion) 0.992f else 1f,
        animationSpec = spring(stiffness = 650f),
        label = "card_scale"
    )

    val topSurfaceBrush = if (tokens.isDark) {
        Brush.verticalGradient(
            colors = listOf(
                MidnightNavyCardTop,
                MidnightNavyElevated
            )
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                Color.White,
                Color(0xFFF8FAFC)
            )
        )
    }

    val baseLipBrush = if (tokens.isDark) {
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFF050914),
                accentColor.copy(alpha = 0.22f),
                Color(0xFF050914)
            )
        )
    } else {
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFFD8E1EE),
                accentColor.copy(alpha = 0.18f),
                Color(0xFFD8E1EE)
            )
        )
    }

    // Restrained top-lit border with a soft specular sheen on the upper edge
    val subtleBorderBrush = Brush.verticalGradient(
        colors = if (tokens.isDark) {
            listOf(
                Color.White.copy(alpha = 0.15f),
                accentColor.copy(alpha = 0.16f),
                MidnightNavyBorder.copy(alpha = 0.55f)
            )
        } else {
            listOf(
                Color.White.copy(alpha = 0.9f),
                accentColor.copy(alpha = 0.18f),
                Color(0xFFCBD5E1)
            )
        }
    )

    val shape = RoundedCornerShape(cornerRadius)
    val clickableModifier = if (onClick != null) {
        Modifier
            .minimumInteractiveComponentSize()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                role = Role.Button,
                onClick = onClick
            )
    } else {
        Modifier
    }

    Box(
        modifier = modifier
            .then(if (testTag != null) Modifier.testTag(testTag) else Modifier)
            .graphicsLayer {
                scaleX = pressScale
                scaleY = pressScale
            }
            .then(clickableModifier)
            .padding(bottom = depthOffset)
    ) {
        // Subtle 3D Bottom Lip
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(y = depthOffset)
                .clip(shape)
                .background(baseLipBrush)
        )

        // Foreground Layered Surface
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (depthOffset.value * pressOffset).dp)
                .shadow(
                    elevation = if (tokens.isDark) 6.dp else 3.dp,
                    shape = shape,
                    ambientColor = Color.Black.copy(alpha = if (tokens.isDark) 0.48f else 0.08f),
                    spotColor = accentColor.copy(alpha = if (tokens.isDark) 0.18f else 0.10f)
                )
                .clip(shape)
                .background(topSurfaceBrush)
                .border(width = 1.dp, brush = subtleBorderBrush, shape = shape)
                .padding(contentPadding),
            content = content
        )
    }
}

/**
 * Tactile 3D Button with layered depth, soft shadow, restrained top highlight,
 * gentle press animation, minimum 48dp touch target, and clean text layout.
 */
@Composable
fun DimensionalButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    primaryColor: Color = ElectricViolet,
    secondaryColor: Color = LuminousCyan,
    contentColor: Color = Color.White,
    testTag: String? = null
) {
    val tokens = LocalQuizNovaTokens.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val depth = 3.dp

    val pressFraction by animateFloatAsState(
        targetValue = if (isPressed && enabled && !tokens.reduceMotion) 1f else 0f,
        animationSpec = spring(stiffness = 700f),
        label = "btn_press"
    )

    val pressScale by animateFloatAsState(
        targetValue = if (isPressed && enabled && !tokens.reduceMotion) 0.988f else 1f,
        animationSpec = spring(stiffness = 700f),
        label = "btn_scale"
    )

    val shape = RoundedCornerShape(14.dp)
    val surfaceBrush = if (enabled) {
        Brush.horizontalGradient(colors = listOf(primaryColor, secondaryColor))
    } else {
        Brush.horizontalGradient(
            colors = listOf(
                MaterialTheme.colorScheme.surfaceVariant,
                MaterialTheme.colorScheme.surfaceVariant
            )
        )
    }

    val lipBrush = if (enabled) {
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFF050812).copy(alpha = 0.78f),
                primaryColor.copy(alpha = 0.42f),
                Color(0xFF050812).copy(alpha = 0.78f)
            )
        )
    } else {
        Brush.horizontalGradient(
            colors = listOf(
                MaterialTheme.colorScheme.outline.copy(alpha = 0.18f),
                MaterialTheme.colorScheme.outline.copy(alpha = 0.18f)
            )
        )
    }

    val borderBrush = if (enabled) {
        Brush.verticalGradient(
            colors = listOf(
                Color.White.copy(alpha = 0.32f),
                Color.White.copy(alpha = 0.10f)
            )
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                MaterialTheme.colorScheme.outline.copy(alpha = 0.15f),
                MaterialTheme.colorScheme.outline.copy(alpha = 0.12f)
            )
        )
    }

    val textColor = if (enabled) {
        contentColor
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.55f)
    }

    Box(
        modifier = modifier
            .then(if (testTag != null) Modifier.testTag(testTag) else Modifier)
            .graphicsLayer {
                scaleX = pressScale
                scaleY = pressScale
            }
            .minimumInteractiveComponentSize()
            .defaultMinSize(minHeight = 50.dp)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                role = Role.Button,
                onClick = onClick
            )
            .padding(bottom = depth)
    ) {
        // Subtle 3D Bottom Lip
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(y = depth)
                .clip(shape)
                .background(lipBrush)
        )

        // Button Face
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 48.dp)
                .offset(y = (depth.value * pressFraction).dp)
                .shadow(
                    elevation = if (enabled) 4.dp else 0.dp,
                    shape = shape,
                    ambientColor = Color.Black.copy(alpha = 0.35f),
                    spotColor = primaryColor.copy(alpha = 0.28f)
                )
                .clip(shape)
                .background(surfaceBrush)
                .border(
                    width = 1.dp,
                    brush = borderBrush,
                    shape = shape
                )
                .padding(horizontal = 16.dp, vertical = 11.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = textColor,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * Recognizable Category Icon Badge for Python, Java, SQL, Computer Fundamentals, Logical Reasoning, and Mixed Quiz.
 */
@Composable
fun CategoryDimensionalBadge(
    category: QuizCategory?,
    modifier: Modifier = Modifier,
    size: Dp = 44.dp
) {
    val primary = if (category != null) Color(category.primaryHex) else ElectricViolet
    val secondary = if (category != null) Color(category.secondaryHex) else LuminousCyan
    val icon: ImageVector = when (category) {
        QuizCategory.PYTHON -> Icons.Default.Code
        QuizCategory.JAVA -> Icons.Default.Coffee
        QuizCategory.SQL -> Icons.Default.Storage
        QuizCategory.COMPUTER_FUNDAMENTALS -> Icons.Default.Memory
        QuizCategory.LOGICAL_REASONING -> Icons.Default.Psychology
        null -> Icons.Default.Shuffle
    }

    Box(
        modifier = modifier
            .size(size)
            .shadow(4.dp, RoundedCornerShape(13.dp), spotColor = primary.copy(alpha = 0.42f))
            .clip(RoundedCornerShape(13.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(primary, secondary)
                )
            )
            .border(
                width = 1.dp,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.35f),
                        Color.White.copy(alpha = 0.12f)
                    )
                ),
                shape = RoundedCornerShape(13.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = category?.title ?: "Mixed Quiz",
            tint = Color.White,
            modifier = Modifier.size(size * 0.52f)
        )
    }
}

/**
 * Dimensional Result Medallion for the Results celebration card.
 */
@Composable
fun ResultScoreMedallion(
    percentage: Int,
    scoreText: String,
    modifier: Modifier = Modifier
) {
    val tokens = LocalQuizNovaTokens.current
    var entered by remember { mutableStateOf(tokens.reduceMotion) }
    LaunchedEffect(Unit) {
        entered = true
    }

    val animatedProgress by animateFloatAsState(
        targetValue = if (entered) (percentage / 100f).coerceIn(0f, 1f) else 0f,
        animationSpec = if (tokens.reduceMotion) tween(0) else tween(850, easing = FastOutSlowInEasing),
        label = "medallion_arc"
    )

    val entranceScale by animateFloatAsState(
        targetValue = if (entered) 1f else 0.90f,
        animationSpec = if (tokens.reduceMotion) tween(0) else spring(dampingRatio = 0.68f, stiffness = 360f),
        label = "medallion_scale"
    )

    val ringColors = when {
        percentage >= 80 -> listOf(EmeraldSuccess, LuminousCyanBright)
        percentage >= 50 -> listOf(LuminousCyanBright, ElectricVioletBright)
        else -> listOf(WarmAmberAccent, CoralError)
    }

    Box(
        modifier = modifier
            .size(156.dp)
            .graphicsLayer {
                scaleX = entranceScale
                scaleY = entranceScale
            }
            .semantics {
                contentDescription = "Score medallion: $percentage percent, $scoreText"
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(156.dp)) {
            val stroke = 13.dp.toPx()
            val diameter = size.minDimension - stroke * 1.6f
            val topLeft = Offset((size.width - diameter) / 2f, (size.height - diameter) / 2f)

            // Soft outer glow
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        ringColors.first().copy(alpha = 0.22f),
                        Color.Transparent
                    )
                ),
                radius = size.minDimension / 2f
            )

            // Inner 3D disc
            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(MidnightNavyCardTop, MidnightNavyDeep)
                ),
                radius = diameter / 2f - stroke * 0.35f
            )

            // Background track ring
            drawArc(
                color = MidnightNavyBorder.copy(alpha = 0.45f),
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = topLeft,
                size = Size(diameter, diameter),
                style = Stroke(width = stroke, cap = StrokeCap.Round)
            )

            // Foreground progress arc
            drawArc(
                brush = Brush.sweepGradient(colors = ringColors + ringColors.first()),
                startAngle = -90f,
                sweepAngle = 360f * animatedProgress,
                useCenter = false,
                topLeft = topLeft,
                size = Size(diameter, diameter),
                style = Stroke(width = stroke, cap = StrokeCap.Round)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$percentage%",
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = scoreText,
                style = MaterialTheme.typography.labelLarge,
                color = LuminousCyanBright,
                textAlign = TextAlign.Center
            )
        }
    }
}

/**
 * Formatted monospace code block preserving indentation and horizontal scroll for long lines.
 */
@Composable
fun CodeSnippetBlock(
    code: String,
    languageNote: String?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF080D1A))
            .border(1.dp, MidnightNavyBorder.copy(alpha = 0.7f), RoundedCornerShape(12.dp))
    ) {
        if (!languageNote.isNullOrBlank()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0F172A))
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Box(modifier = Modifier.size(7.dp).clip(CircleShape).background(CoralError))
                    Box(modifier = Modifier.size(7.dp).clip(CircleShape).background(WarmAmberAccent))
                    Box(modifier = Modifier.size(7.dp).clip(CircleShape).background(EmeraldSuccess))
                }
                Text(
                    text = languageNote,
                    style = MaterialTheme.typography.labelSmall,
                    color = LuminousCyanBright
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(12.dp)
        ) {
            Text(
                text = code,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = JetBrainsMonoFontFamily,
                    lineHeight = 20.sp
                ),
                color = Color(0xFFE2E8F0)
            )
        }
    }
}
