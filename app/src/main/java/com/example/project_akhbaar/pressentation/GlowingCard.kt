package com.example.project_akhbaar.pressentation

import android.graphics.Paint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GlowingCard(
    glowingColor: Color,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.White,
    cornersRadius: Dp = 0.dp,
    glowingRadius: Dp = 20.dp,
    xShifting: Dp = 0.dp,
    yShifting: Dp = 0.dp,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .drawBehind {
                val canvasSize = size
                drawContext.canvas.nativeCanvas.apply {
                    drawRoundRect(
                        0f, // Left
                        0f, // Top
                        canvasSize.width, // Right
                        canvasSize.height, // Bottom
                        cornersRadius.toPx(), // Radius X
                        cornersRadius.toPx(), // Radius Y
                        Paint().apply {
                            color = containerColor.toArgb()
                            isAntiAlias = true
                            setShadowLayer(
                                glowingRadius.toPx(),
                                xShifting.toPx(), yShifting.toPx(),
                                glowingColor.copy(alpha = 0.85f).toArgb()
                            )
                        }
                    )
                }
            }
    ) {
        content()
    }
}

/////////////////////////////////////////////////////////////////////

@Composable
fun ClickableGlowingCard(
    glowingColor: Color,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.White,
    cornersRadius: Dp = 0.dp,
    glowingRadius: Dp = 20.dp,
    xShifting: Dp = 0.dp,
    yShifting: Dp = 0.dp,
    onClick:() -> Unit = {},
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .drawBehind {
                val canvasSize = size
                drawContext.canvas.nativeCanvas.apply {
                    drawRoundRect(
                        0f, // Left
                        0f, // Top
                        canvasSize.width, // Right
                        canvasSize.height, // Bottom
                        cornersRadius.toPx(), // Radius X
                        cornersRadius.toPx(), // Radius Y
                        Paint().apply {
                            color = containerColor.toArgb()
                            isAntiAlias = true
                            setShadowLayer(
                                glowingRadius.toPx(),
                                xShifting.toPx(), yShifting.toPx(),
                                glowingColor.copy(alpha = 0.85f).toArgb()
                            )
                        }
                    )
                }
            }
    ) {
        Box(modifier = Modifier.clip(RoundedCornerShape(cornersRadius)).clickable { onClick() }){
            content()
        }
    }
}