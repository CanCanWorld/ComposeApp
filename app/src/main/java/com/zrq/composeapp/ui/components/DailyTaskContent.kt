package com.zrq.composeapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DailyTaskContent(modifier: Modifier) {
    Column {
        DailyTaskItem(modifier = Modifier, title = "文章学习", subtitle = "10积分/每有效阅读1篇文章")
        DailyTaskItem(modifier = Modifier, title = "文章学习", subtitle = "10积分/每有效阅读1篇文章")
        DailyTaskItem(modifier = Modifier, title = "文章学习", subtitle = "10积分/每有效阅读1篇文章")
        DailyTaskItem(modifier = Modifier, title = "文章学习", subtitle = "10积分/每有效阅读1篇文章")
        DailyTaskItem(modifier = Modifier, title = "文章学习", subtitle = "10积分/每有效阅读1篇文章")
    }
}

@Composable
fun DailyTaskItem(
    modifier: Modifier,
    title: String,
    subtitle: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight(600)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = subtitle,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(600)
                )
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .size(18.dp)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                LinearProgressIndicator(
                    progress = 0.7f,
                    modifier = Modifier.width(100.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "已获50积分",
                    fontSize = 11.sp
                )
                Text(
                    text = "/每日上限100积分",
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "去学习")
        }
    }
}