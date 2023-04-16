package com.zrq.composeapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.zrq.composeapp.model.entity.VideoEntity

@Composable
fun VideoItem(
    modifier: Modifier = Modifier,
    video: VideoEntity
) {
    Column {
        Row(
            modifier = modifier.padding(20.dp),
        ) {
            AsyncImage(
                model = video.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .width(130.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .aspectRatio(16 / 9f),
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column {

                Text(
                    text = video.title,
                    fontSize = 15.sp,
                    maxLines = 2,
                    fontWeight = FontWeight(600)
                )

                Text(
                    text = video.type,
                    fontSize = 12.sp,
                    maxLines = 1,
                )

                Text(
                    text = "时长：${video.duration}",
                    color = Color.Gray,
                    maxLines = 1,
                    fontSize = 12.sp,
                )
            }
        }
        Divider(Modifier.padding(horizontal = 30.dp))
    }
}