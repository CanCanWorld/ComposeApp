package com.zrq.composeapp.ui.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.zrq.composeapp.model.entity.SwiperEntity
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SwiperContent(swiperData: List<SwiperEntity>) {

    //虚拟页数
    var virtualPage = Int.MAX_VALUE

    //实际页数
    val actualPage = swiperData.size

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
        }, 3000, 3000)

        onDispose {
            timer.cancel()
        }
    }

    HorizontalPager(
        count = virtualPage,
        state = pagerState,
    ) { index ->
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7 / 3f)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            model = swiperData[index % actualPage].imageUrl,
            contentDescription = null,
        )
    }
}