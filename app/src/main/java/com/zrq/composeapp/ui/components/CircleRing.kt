package com.zrq.composeapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity

@Composable
fun CircleRing(
    modifier: Modifier = Modifier,
    progress: Float, //0-100
    strokeWidth: Float = 25f
) {

    val strokeWidthDp = with(LocalDensity.current) {
        strokeWidth.toDp()
    }

    val sweepAngle = progress / 100 * 220
    Canvas(
        modifier = modifier
            .padding(strokeWidthDp / 2)
    ) {
        drawArc(
            Color(0, 0, 0, 20),
            startAngle = 160f,
            sweepAngle = 220f,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )
        drawArc(
            Color.White,
            startAngle = 160f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )
    }
}