package com.zrq.composeapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zrq.composeapp.appBarHeight
import com.zrq.composeapp.statusBarHeightDp
import com.zrq.composeapp.ui.components.ChartView
import com.zrq.composeapp.ui.components.CircleRing
import com.zrq.composeapp.ui.components.DailyTaskContent
import com.zrq.composeapp.ui.theme.Green
import com.zrq.composeapp.vm.TaskViewModel
import com.zrq.composeapp.vm.TaskViewModel.Companion.totalCredits

@Composable
fun TaskScreen(
    modifier: Modifier = Modifier,
    taskViewModel: TaskViewModel = viewModel()
) {

    val boxSize: Int
    with(LocalConfiguration.current) {
        boxSize = screenWidthDp / 2
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Green, Color.White)))
    ) {

        Box(
            modifier = Modifier
                .padding(top = statusBarHeightDp)
                .height(appBarHeight)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "学习任务",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight(600)
            )
        }

        Box(modifier = Modifier.fillMaxWidth()) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //学习周期
                Text(
                    text = taskViewModel.taskDate,
                    fontSize = 14.sp,
                    color = Color.White,
                )

                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(boxSize.dp),
                    contentAlignment = Alignment.Center
                ) {

                    //圆环
                    CircleRing(
                        modifier = Modifier.size(boxSize.dp),
                        progress = taskViewModel.creditsProgress,
                    )

                    //进度数据
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            buildAnnotatedString {
                                append(taskViewModel.credits.toString())
                                withStyle(SpanStyle(fontSize = 12.sp)) {
                                    append("分")
                                }
                            },
                            fontSize = 36.sp,
                            color = Color.White,
                            fontWeight = FontWeight(1000)
                        )
                        Text(
                            text = "学年积分",
                            fontSize = 12.sp,
                            color = Color.White,
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp)
                        .offset(y = (-60).dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "${totalCredits}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "学年规定积分",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                    Column {
                        Text(
                            text = "${totalCredits - taskViewModel.credits}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "还差",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {


                item {
                    Spacer(modifier = Modifier.height(240.dp))
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "学习明细",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "最近一周获得积分情况",
                            fontSize = 14.sp,
                            color = Color.Gray,
                        )

                        //折线图
                        ChartView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            rowCount = 6,
                            creditsOfWeek = taskViewModel.creditsOfWeek,
                            start = 0,
                            rowNum = 2,
                        )

                        Text(
                            text = "今日获得0积分，快去完成下面任务吧",
                            fontSize = 14.sp,
                            color = Green,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth()
                                .background(Green.copy(0.1f))
                                .padding(10.dp),
                            textAlign = TextAlign.Start
                        )

                        DailyTaskContent(modifier = Modifier)
                    }
                }

            }
        }
    }
}