package com.zrq.composeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zrq.composeapp.appBarHeight
import com.zrq.composeapp.statusBarHeightDp
import com.zrq.composeapp.ui.theme.Green
import com.zrq.composeapp.ui.theme.Green200

@Composable
fun MyTopAppBar(modifier: Modifier = Modifier, content: @Composable () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .background(
                Brush.verticalGradient(listOf(Green, Green200))
            )
            .padding(top = statusBarHeightDp)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        content()
    }
}