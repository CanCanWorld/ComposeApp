package com.zrq.composeapp.ui.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import com.zrq.composeapp.model.entity.MyPoint
import com.zrq.composeapp.ui.theme.Green

@Composable
fun ChartView(
    modifier: Modifier = Modifier,
    rowCount: Int = 5,
    creditsOfWeek: List<MyPoint>,
    start: Int,
    rowNum: Int
) {

    Canvas(
        modifier = modifier
    ) {
        val rowHeight = size.height / rowCount

        for (index in 0 until rowCount) {
            val y = rowHeight * index
            drawLine(
                Color.LightGray,
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = 1f
            )
        }
        var lastPoint = 0.0f
        var widthSpace = size.width / (creditsOfWeek.size - 1)
        var heightSpace = size.height / rowCount
        creditsOfWeek.forEachIndexed { index, d ->
            if (index != 0) {
                drawLine(
                    Green,
                    start = Offset(widthSpace * (index - 1), size.height - heightSpace - (size.height - heightSpace) * lastPoint),
                    end = Offset(widthSpace * index, size.height - heightSpace - (size.height - heightSpace) * d.weight),
                    strokeWidth = 2f
                )

            }
            lastPoint = d.weight

            drawCircle(
                color = Green,
                radius = 10f,
                center = Offset(widthSpace * index, size.height - heightSpace - (size.height - heightSpace) * d.weight),
                style = Stroke(2f, cap = StrokeCap.Round),
            )
            val paint = Paint()

            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    d.title,
                    widthSpace * index.toFloat(),
                    size.height,
                    paint.apply {
                        textSize = 30f
                        textAlign = Paint.Align.CENTER
                    }
                )
            }

        }

    }

}