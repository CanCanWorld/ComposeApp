package com.zrq.composeapp.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.zrq.composeapp.model.entity.MyPoint

class TaskViewModel : ViewModel() {
    val taskDate by mutableStateOf("学习周期：2023.4.14-2023.4.16")

    var credits by mutableStateOf(10000)

    var creditsProgress by mutableStateOf(credits * 100 / totalCredits.toFloat())

    var creditsOfWeek by mutableStateOf(
        listOf(
            MyPoint("2.1", 0.2f),
            MyPoint("2.2", 0.5f),
            MyPoint("2.3", 0.1f),
            MyPoint("2.4", 0.4f),
            MyPoint("2.5", 0.7f),
            MyPoint("2.6", 1f),
            MyPoint("2.7", 0f),
        )
    )

    companion object {
        const val totalCredits = 13500
    }
}