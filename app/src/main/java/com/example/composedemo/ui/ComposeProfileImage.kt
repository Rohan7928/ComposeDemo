package com.example.composedemo.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ComposeProfileImage(drawableResource: DrawableRes, description: String, modifier: Modifier) {
    Image(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape),
        painter = drawableResource(id = drawableResource),
        contentDescription = description,
    )
}

fun drawableResource(id: DrawableRes): Painter {
    TODO("Not yet implemented")
}


