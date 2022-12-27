package com.example.composedemo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import com.example.composedemo.ui.Routes


@Composable
fun SplashScreen(navController: NavHostController) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.White)
    ) {


        Row(
            modifier = Modifier
                .padding(all = 10.dp)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(R.drawable.map),
                contentDescription = "Contact profile picture",

                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)

            )
            Spacer(modifier = Modifier.size(8.dp))


            Column {
                SearchBar()
                Text(
                    text = "Hello Welcome!", color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = "Please Enter your name to join!",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(20.dp))
                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {
                            navController.navigate(Routes.LoginPage.route)
                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                    ) {
                        Text(text = "Go To", color = androidx.compose.ui.graphics.Color.White)
                    }
                }
            }
        }


    }
}

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    BasicTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.primary,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp)
            .border(1.5.dp, MaterialTheme.colorScheme.primary)
            .padding(10.dp),

        )
}


/*@Preview(name="Light Mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name= "Dark Mode")
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        Greeting(message = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!"))
    }
}*/
