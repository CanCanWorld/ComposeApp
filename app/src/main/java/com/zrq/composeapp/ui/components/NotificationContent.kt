package com.zrq.composeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.zrq.composeapp.ui.theme.Green
import kotlinx.coroutines.launch
import java.util.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NotificationContent(modifier: Modifier = Modifier,list: List<String>) {

    //虚拟页数
    var virtualPage = Int.MAX_VALUE

    //实际页数
    val actualPage = list.size

    //初始图片下标
    val initIndex =
        if (actualPage == 0) {
            virtualPage = 0
            0
        } else {
            virtualPage / 2 - virtualPage / 2 % actualPage
        }

    val pagerState = rememberPagerState(initialPage = initIndex)

    val coroutineScope = rememberCoroutineScope()

    DisposableEffect(Unit) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        }, 3000, 4000)

        onDispose {
            timer.cancel()
        }
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .height(45.dp)
            .fillMaxWidth()
            .background(Green.copy(0.1f))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "最新活动",
            color = Green,
            fontSize = 14.sp,
            fontWeight = FontWeight(800)
        )

        VerticalPager(
            count = virtualPage,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp),
            horizontalAlignment = Alignment.Start
        ) { index ->
            Text(
                text = list[index % actualPage],
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Text(
            text = "更多",
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}