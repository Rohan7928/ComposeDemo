package com.example.composedemo.ui

sealed class Routes(val route: String){
    object MainActivity : Routes("MainActivity")
    object LoginPage : Routes("LoginPage")
    object SplashScreen : Routes("SplashScreen")
    object ProfileScreen : Routes("ProfileScreen")
}