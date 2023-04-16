package com.zrq.composeapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zrq.composeapp.statusBarHeightDp
import com.zrq.composeapp.ui.components.MyTopAppBar
import com.zrq.composeapp.ui.components.MyWebView
import com.zrq.composeapp.ui.components.rememberWebViewState
import com.zrq.composeapp.ui.theme.Green

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ArticleDetailScreen(
    onBack: () -> Unit
) {
    Column {
        MyTopAppBar {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "返回",
                    tint = Color.White,
                    modifier = Modifier
                        .clickable {
                            onBack()
                        }
                        .align(Alignment.CenterStart)
                )
                Text(
                    text = "文章详情",
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }
        }

        val webViewState = rememberWebViewState(data = "<h1>哈哈哈</h1>")

        MyWebView(webViewState)
    }
}