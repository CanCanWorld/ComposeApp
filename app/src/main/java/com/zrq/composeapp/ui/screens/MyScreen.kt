package com.zrq.composeapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zrq.composeapp.R
import com.zrq.composeapp.model.entity.MenuItem
import com.zrq.composeapp.ui.components.MyTopAppBar
import com.zrq.composeapp.ui.theme.Green
import com.zrq.composeapp.vm.MyViewModel

@Composable
fun MyScreen(
    modifier: Modifier = Modifier,
    myViewModel: MyViewModel = viewModel()
) {
    Column(modifier = modifier) {
        MyTopAppBar {
            Text(text = "我的", color = Color.White)
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            //头像
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pic_3),
                        contentDescription = null,
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .border(1.dp, Green, CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(
                            text = "歪比巴卜",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(1000)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "已坚持学习23天",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )

                    }
                }
            }
            //菜单
            item {
                MenuGroup(
                    menuItems = myViewModel.menus,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
            item {
                MenuGroup(
                    menuItems = myViewModel.menus2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
        }
    }
}

@Composable
fun MenuGroup(
    modifier: Modifier = Modifier,
    menuItems: List<MenuItem>
) {
    Card(
        modifier = modifier
    ) {
        Column {
            menuItems.forEachIndexed { index, menuItem ->
                if (index != 0) {
                    Divider(modifier = Modifier.padding(horizontal = 10.dp))
                }
                MenuItem(menuItem = menuItem)
            }
        }
    }
}

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    menuItem: MenuItem
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = menuItem.id,
            contentDescription = menuItem.title,
            tint = Green
        )
        Text(
            text = menuItem.title,
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp),
            fontWeight = FontWeight(800)
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

