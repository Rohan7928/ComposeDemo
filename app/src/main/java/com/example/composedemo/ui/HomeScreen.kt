package com.example.composedemo.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.asLiveData
import androidx.lifecycle.observe
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewModelScope
import com.example.composedemo.ui.data.LoginModel
import com.example.composedemo.ui.data.Pref
import kotlinx.coroutines.flow.observeOn

@Composable
fun HomeScreen() {
    val mContext = LocalContext.current
    val scope = rememberCoroutineScope()
    val pref = remember(mContext) { Pref(mContext) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        // Parameters set to place the items in center
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        // Icon Composable
        Icon(
            imageVector = Icons.Default.Home, contentDescription = "home", tint = Color(0xFF0F9D58)
        )
        // Text to Display the current Screen
        Text(text = "Hello, ${pref.getUserName.collectAsState("").value}!", color = Color.Black)
        ExtendedFloatingActionButton(
            text = { Text(text = "Home") },
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    Icons.Default.Home, contentDescription = "Home Icon"
                )
            })
    }
}
