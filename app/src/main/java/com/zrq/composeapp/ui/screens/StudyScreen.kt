package com.zrq.composeapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zrq.composeapp.ui.components.*
import com.zrq.composeapp.ui.theme.Green
import com.zrq.composeapp.vm.ArticleViewModel
import com.zrq.composeapp.vm.MainViewModel
import com.zrq.composeapp.vm.VideoViewModel

@Composable
fun StudyScreen(
    modifier: Modifier = Modifier,
    vm: MainViewModel = viewModel(),
    articleViewModel: ArticleViewModel = viewModel(),
    videoViewModel: VideoViewModel = viewModel(),
    onNavigationToArticle: () -> Unit = {},
    onNavigationToVideo: () -> Unit = {},
) {
    Column(modifier = modifier) {
        MyTopAppBar(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            //搜索框
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f),
                color = Color(0x40FFFFFF)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(20.dp),
                        imageVector = Icons.Filled.Search,
                        contentDescription = "搜索",
                        tint = Color.White,
                    )
                    Text(
                        text = "搜索感兴趣的资讯或者课程",
                        modifier = Modifier.padding(horizontal = 4.dp),
                        color = Color.White,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = Ellipsis
                    )
                }
            }
            //学习进度
            Text(
                text = "学习\n进度",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 10.dp),
                lineHeight = 15.sp
            )
            Text(
                text = "26%",
                fontSize = 14.sp,
                color = Color.White,
            )
            //消息
            Icon(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(24.dp),
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "消息",
                tint = Color.White,
            )
        }

        TabRow(
            selectedTabIndex = vm.categoryIndex,
            backgroundColor = Green.copy(0.25f),
            contentColor = Green
        ) {
            vm.categories.forEachIndexed { index, category ->
                Tab(
                    selected = vm.categoryIndex == index,
                    onClick = {
                        vm.updateCategoryIndex(index)
                    },
                    selectedContentColor = Green,
                    unselectedContentColor = Color.Black.copy(0.8f)
                ) {
                    Text(
                        text = category.title,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

        TabRow(
            selectedTabIndex = vm.typeIndex,
            backgroundColor = Color.White,
            contentColor = Color.White
        ) {
            vm.types.forEachIndexed { index, title ->
                Tab(
                    selected = vm.typeIndex == index,
                    onClick = {
                        vm.updateTypeIndex(index)
                    },
                    selectedContentColor = Green,
                    unselectedContentColor = Color.Black.copy(0.8f)
                ) {
                    Text(
                        text = title,
                        modifier = Modifier.padding(10.dp),
                        fontSize = 18.sp
                    )
                }
            }
        }

        LazyColumn() {

            item {
                //轮播图
                SwiperContent(swiperData = vm.swiperData)
            }

            item {
                //通知公告
                NotificationContent(
                    modifier = Modifier
                        .padding(
                            horizontal = 10.dp,
                            vertical = 6.dp
                        ),
                    list = vm.notifications
                )
            }

            when (vm.types[vm.typeIndex]) {
                "相关数据" -> {
                    items(articleViewModel.list.size) {
                        ArticleItem(
                            modifier = Modifier
                                .clickable {
                                    onNavigationToArticle()
                                },
                            article = articleViewModel.list[it]
                        )
                    }
                }
                "视频课程" -> {
                    items(videoViewModel.list.size) {
                        VideoItem(
                            modifier = Modifier.clickable {
                                onNavigationToVideo()
                            },
                            video = videoViewModel.list[it]
                        )
                    }
                }
            }
        }
    }
}