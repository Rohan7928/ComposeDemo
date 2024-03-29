package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.ui.*


class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenMain()
        }
    }

    @Composable
    private fun ScreenMain() {
        Scaffold(
            content = {

                val navController = rememberNavController()

                /**
                 * NavHost Builds a navGraph to handle navigation, set the start destination to Home and
                 * provide the navController which will control the navigation.
                 */
                NavHost(
                    navController = navController, startDestination = Routes.DashBoard.route
                ) {

                    //First route : Home
                    composable(Routes.SplashScreen.route) {

                        //Lay down the Home Composable and pass the navController
                        SplashScreen(navController = navController)
                    }

                    //Another Route : Profile
                    composable(Routes.DashBoard.route) {
                        //Profile Screen
                        DashBoard()
                    }
                    composable(Routes.ProfileScreen.route) {
                        //Profile Screen
                        ProfileScreen()
                    }

                    composable(Routes.LoginScreen.route) {
                        //Profile Screen
                        LoginPage(navController = navController)
                    }

                    /*    //Settings Route, Notice the "/{id}" in last, its the argument passed down from homeScreen
                        composable(Routes.Settings.route + "/{id}") { navBackStack ->

                            //Extracting the argument
                            val counter = navBackStack.arguments?.getString("id")

                            //Setting screen, Pass the extracted Counter
                            Setting(counter = counter)

                        }*/
                }
            },
        )


    }
}

data class Message(val author: String, val body: String)

