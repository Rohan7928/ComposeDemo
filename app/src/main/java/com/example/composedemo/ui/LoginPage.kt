package com.example.composedemo.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navArgument
import com.example.composedemo.R
import com.example.composedemo.ui.data.LoginModel
import com.example.composedemo.ui.data.Pref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LoginPage(navController: NavController) = Box(
    modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(), contentAlignment = Alignment.Center
) {
    //Initilazation
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val mContext = LocalContext.current
        val scope = rememberCoroutineScope()
        val pref = remember(mContext) { Pref(mContext) }
        val userName = remember {
            mutableStateOf(TextFieldValue())
        }
        val password = remember {
            mutableStateOf(TextFieldValue())
        }
        Image(painter = painterResource(id = R.drawable.app_icon), contentDescription = "AppIcon")
        Text(
            text = "Hello, ${pref.getUserName.collectAsState("").value}!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(20.dp))
        TextField(
            shape = RoundedCornerShape(30.dp),
            label = { Text(text = "UserName/Email") },
            value = userName.value,
            onValueChange = { userName.value = it },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.LightGray,
            )
        )
        Spacer(modifier = Modifier.size(20.dp))
        TextField(
            shape = RoundedCornerShape(30.dp),
            label = { Text(text = "Password") },
            value = password.value,
            onValueChange = { password.value = it },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.LightGray,
            )
        )
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .width(150.dp)
                .padding(10.dp),
            onClick = { onClick(userName, password, navController, mContext, pref, scope) }) {
            Text(
                text = "Submit",
                color = Color.White
            )
        }

    }
}


fun onClick(
    userName: MutableState<TextFieldValue>,
    password: MutableState<TextFieldValue>,
    navController: NavController,
    mContext: Context,
    pref: Pref,
    scope: CoroutineScope
) {
    if (userName.value.text.contains("Rohan") && password.value.text.contains("12345678")) {
        scope.launch {
            pref.saveUserName(userName.value.text)
        }

        navController.navigate(Routes.DashBoard.route)
    } else {
        showToast(mContext, "Please Enter Valid Credentials")
    }
}
