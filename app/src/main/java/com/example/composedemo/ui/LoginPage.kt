package com.example.composedemo.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.Utils.Constants
import com.example.composedemo.theme.ComposeDemoTheme
import com.example.composedemo.ui.drawer.DrawerContent
import com.example.composedemo.ui.navigation.NavHostContainer
import com.example.composedemo.ui.appBar.MyTopAppBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginPage() {

    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
    ) {

        ComposeDemoTheme {
            // remember navController so it does not
            // get recreated on recomposition
            Surface(color = MaterialTheme.colorScheme.primary) {
                val scaffoldState = rememberScaffoldState()
                val coroutineScope = rememberCoroutineScope()
                val contextForToast = LocalContext.current.applicationContext
                // Scaffold Component
                Scaffold(scaffoldState = scaffoldState, topBar = {
                    MyTopAppBar {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                }, drawerContent = {
                    DrawerContent { ItemLabel ->
                        Toast.makeText(contextForToast, ItemLabel, Toast.LENGTH_SHORT).show()

                        coroutineScope.launch {
                            delay(300)
                            scaffoldState.drawerState.close()
                        }

                    }
                }, floatingActionButton = {
                    FloatingActionButton(onClick = {
                        navController.navigate("profile")
                    }, content = {
                        Column(
                            modifier = Modifier.padding(PaddingValues(10.dp))
                        ) {
                            androidx.compose.material3.Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Person",
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    })
                }, isFloatingActionButtonDocked = true,
                    // Bottom navigation
                    bottomBar = {
                        BottomAppBar(cutoutShape = androidx.compose.material.MaterialTheme.shapes.small.copy(
                            CornerSize(percent = 80)
                        ),

                            content = {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                // observe current route to change the icon
                                // color,label color when navigated
                                val currentRoute = navBackStackEntry?.destination?.route
                                // Bottom nav items we declared
                                Constants.BottomNavItems.forEach { navItem ->
                                    // Place the bottom nav items
                                    BottomNavigationItem(
                                        modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp),
                                        // it currentRoute is equal then its selected route
                                        selected = currentRoute == navItem.route,
                                        // navigate on click
                                        onClick = {
                                            navController.navigate(navItem.route)
                                        },
                                        // Icon of navItem
                                        icon = {
                                            Icon(
                                                imageVector = navItem.icon,
                                                contentDescription = navItem.label
                                            )
                                        },
                                        // label
                                        label = {
                                            Text(text = navItem.label)
                                        }, alwaysShowLabel = false
                                    )
                                }
                            })
                        //BottomNavigationBar(navController = navController)
                    }, content = { padding ->
                        // Navhost: where screens are placed
                        NavHostContainer(navController = navController, padding = padding)
                    })
            }
        }
    }

}


/*

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeDemoTheme {
        Greeting2()
    }
}*/
