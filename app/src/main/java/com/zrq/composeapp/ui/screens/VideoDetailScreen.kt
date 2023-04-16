package com.zrq.composeapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.zrq.composeapp.ui.components.MyTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VideoDetailScreen() {
    Column {
        MyTopAppBar() {
            Row {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "返回",
                    tint = Color.White
                )
                Text(
                    text = "视频详情",
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    modifier = Modifier
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}