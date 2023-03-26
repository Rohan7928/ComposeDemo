package com.example.composedemo.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.data.Pref

@RequiresApi(Build.VERSION_CODES.O)
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
        var isClockRunning by remember {
            mutableStateOf(true)
        }

        AnalogClockComposable(
            modifier = Modifier.clickable {
                isClockRunning = !isClockRunning
            },
            isClockRunning = isClockRunning, minSize = 220.dp,
        )
        /*Surface(
            modifier = Modifier.fillMaxSize(150f), color = MaterialTheme.colors.background
        ) {
            var isClockRunning by remember {
                mutableStateOf(true)
            }
            AnalogClockComposable(
                modifier = Modifier.clickable {
                    isClockRunning = !isClockRunning
                }, isClockRunning = isClockRunning
            )
        }*/
        Icon(
            imageVector = Icons.Default.Home, contentDescription = "home", tint = Color(0xFF0F9D58)
        )
        // Text to Display the current Screen
        Text(text = "Hello, ${pref.getUserName.collectAsState("").value}!", color = Color.Black)
        ExtendedFloatingActionButton(text = { Text(text = "Home") }, onClick = { TODO() }, icon = {
            Icon(
                Icons.Default.Home, contentDescription = "Home Icon"
            )
        })
    }
}
