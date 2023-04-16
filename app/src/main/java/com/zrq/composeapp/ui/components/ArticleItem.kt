package com.zrq.composeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zrq.composeapp.model.entity.ArticleEntity

@Composable
fun ArticleItem(
    modifier: Modifier = Modifier,
    article: ArticleEntity
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 20.dp,
                start = 20.dp,
                end = 20.dp
            )
    ) {
        Text(
            text = article.title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp,
            fontWeight = FontWeight(600)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "来源：${article.source}",
                color = Color.Gray,
                fontSize = 12.sp
            )
            Text(
                text = article.timestamp,
                color = Color.Gray,
                fontSize = 12.sp
            )
        }

        Divider()
    }
}