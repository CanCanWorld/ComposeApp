package com.zrq.composeapp.vm

import androidx.lifecycle.ViewModel
import com.zrq.composeapp.model.entity.ArticleEntity

class ArticleViewModel : ViewModel() {

    //文章列表
    val list = MutableList(20) {
        ArticleEntity("一起学习 Jetpack Compose 项目实战", "bilibili", "2022-03-21")
    }
}