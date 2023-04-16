package com.zrq.composeapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zrq.composeapp.model.entity.NavigationItem
import com.zrq.composeapp.ui.theme.Green

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainFrame(
    onNavigationToArticle: () -> Unit = {},
    onNavigationToVideo: () -> Unit = {},
) {

    val bottomItems = listOf(
        NavigationItem(title = "学习", icon = Icons.Filled.Home),
        NavigationItem(title = "任务", icon = Icons.Filled.DateRange),
        NavigationItem(title = "我的", icon = Icons.Filled.Person),
    )

    var currentItem by remember {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 3.dp,
            ) {
                bottomItems.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = currentItem == index,
                        onClick = {
                            currentItem = index
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = item.title)
                        },
                        selectedContentColor = Green,
                        unselectedContentColor = Color.Gray
                    )
                }
            }
        }
    ) {
        when (currentItem) {
            0 -> {
                StudyScreen(
                    modifier = Modifier.padding(it),
                    onNavigationToArticle = {
                        onNavigationToArticle()
                    },
                    onNavigationToVideo = {
                        onNavigationToVideo()
                    }
                )
            }
            1 -> {
                TaskScreen(modifier = Modifier.padding(it))
            }
            2 -> {
                MyScreen(modifier = Modifier.padding(it))
            }
            else -> {}
        }
    }

}
