package com.zrq.composeapp.vm

import androidx.lifecycle.ViewModel
import com.zrq.composeapp.model.entity.VideoEntity

class VideoViewModel : ViewModel() {
    val list = MutableList(20) {
        VideoEntity(
            "一起学习 Jetpack Compose 项目实战",
            "视频课程",
            "00:02:50",
            "http://img5.adesk.com/63b84f0931f613180c614ef5?imageMogr2/thumbnail/!1080x1920r/gravity/Center/crop/1080x1920&sign=c0729e2e7368084b65230ee48e3f795b&t=6436b93a"
        )
    }
}