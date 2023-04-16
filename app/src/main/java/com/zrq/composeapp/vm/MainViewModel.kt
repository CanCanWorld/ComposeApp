package com.zrq.composeapp.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.zrq.composeapp.model.entity.Category
import com.zrq.composeapp.model.entity.SwiperEntity

class MainViewModel : ViewModel() {
    val categories by mutableStateOf(
        listOf(
            Category("思想政治"),
            Category("法律法规"),
            Category("职业道德"),
            Category("诚信自律"),
        )
    )

    var categoryIndex by mutableStateOf(0)
        private set

    fun updateCategoryIndex(index: Int) {
        categoryIndex = index
    }

    val types by mutableStateOf(
        listOf(
            "相关数据",
            "视频课程",
        )
    )
    var typeIndex by mutableStateOf(0)
        private set

    fun updateTypeIndex(index: Int) {
        typeIndex = index
    }

    val swiperData = listOf<SwiperEntity>(
        SwiperEntity("http://img5.adesk.com/63b84f0931f613180c614ef5?imageMogr2/thumbnail/!1080x1920r/gravity/Center/crop/1080x1920&sign=c0729e2e7368084b65230ee48e3f795b&t=6436b93a"),
        SwiperEntity("http://img5.adesk.com/63b84f0931f613180c614ef6?imageMogr2/thumbnail/!1080x1920r/gravity/Center/crop/1080x1920&sign=f9d84ef3d8d7b39b02999b8097caa405&t=6436b93a"),
        SwiperEntity("http://img5.adesk.com/63b7e13f7e978a53c5ac51cf?imageMogr2/thumbnail/!1080x1920r/gravity/Center/crop/1080x1920&sign=f980c883fcc644c2b3b81ccd0282d28c&t=6436b93a"),
        SwiperEntity("http://img5.adesk.com/63b6bc94e7bce77c1077a3ff?imageMogr2/thumbnail/!1080x1920r/gravity/Center/crop/1080x1920&sign=95d632346cc9bf6f525575abba2b7659&t=6436b93a"),
    )

    //通知数据
    val notifications = listOf(
        "一起学习 Jetpack Compose 项目实战",
        "两小时用 Jetpack Compose 写个微信界面",
        "一次搞定 Jetpack Compose，优先获得择偶权, 哈哈哈哈哈哈"
    )
}