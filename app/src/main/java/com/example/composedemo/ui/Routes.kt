package com.example.composedemo.ui

sealed class Routes(val route: String){
    object MainActivity : Routes("MainActivity")
    object LoginScreen : Routes("LoginScreen")
    object DashBoard : Routes("DashBoard")
    object SplashScreen : Routes("SplashScreen")
    object ProfileScreen : Routes("ProfileScreen")
}