package com.example.composedemo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            .background(MaterialTheme.colorScheme.primary, CircleShape),
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier.padding(start = 16.dp),
            tint = Color.White
        )
        androidx.compose.material3.Text(
            text = "Search Replies",   // stringResource(id = R.string.search_replies)
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
      /* ComposeProfileImage(
            drawableResource = painterResource(R.drawable.avatar_6),
            description = "Profile",
            modifier = Modifier
                .padding(12.dp)
                .size(32.dp)
        )*/
    }
}
