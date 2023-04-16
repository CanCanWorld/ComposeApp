package com.zrq.composeapp.vm

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.zrq.composeapp.model.entity.MenuItem

class MyViewModel : ViewModel() {
    val menus by mutableStateOf(
        mutableListOf(
            MenuItem(Icons.Filled.Favorite, "学习积分"),
            MenuItem(Icons.Filled.Check, "浏览记录"),
            MenuItem(Icons.Filled.Settings, "学习档案"),
        )
    )
    val menus2 by mutableStateOf(
        mutableListOf(
            MenuItem(Icons.Filled.Favorite, "常见问题"),
            MenuItem(Icons.Filled.Check, "版本信息"),
            MenuItem(Icons.Filled.Settings, "个人设置"),
            MenuItem(Icons.Filled.Settings, "联系我们"),
        )
    )
}