package com.example.composedemo.ui.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.model.NavigationDrawerItem


@Composable
fun DrawerContent(
    gradientColors: List<Color> = listOf(Color(0xFFF70A74), Color(0xFFF59118)),
    itemClick: (String) -> Unit) {

    val itemsList = prepareNavigationDrawerItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = gradientColors)),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(vertical = 36.dp)
    ) {

        item {

            // user's image
            /* Image(
                 modifier = Modifier
                     .size(size = 120.dp)
                     .clip(shape = CircleShape),
                 painter = painterResource(id = R.drawable.people1),
                 contentDescription = "Profile Image"
             )*/

            // user's name
            Text(
                modifier = Modifier
                    .padding(top = 12.dp),
                text = "Hermione",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            // user's email
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 30.dp),
                text = "hermione@email.com",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )
        }

        items(itemsList) { item ->
            NavigationListItem(item = item) {
                itemClick(item.label)
            }
        }
    }

}


@Composable
private fun prepareNavigationDrawerItems(): List<NavigationDrawerItem> {
    val itemsList = arrayListOf<NavigationDrawerItem>()

    itemsList.add(
        NavigationDrawerItem(
            //image = painterResource(id = R.drawable.home),
            label = "Home",
            showUnreadBubble = true

        )
    )
    itemsList.add(
        NavigationDrawerItem(
            //image = painterResource(id = R.drawable.message_square),
            label = "Messages",
            showUnreadBubble = true
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            //image = painterResource(id = R.drawable.bell),
            label = "Notifications",
            showUnreadBubble = true
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            //image = painterResource(id = R.drawable.user),
            label = "Profile",
            showUnreadBubble = true
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            //image = painterResource(id = R.drawable.credit_card),
            label = "Payments",
            showUnreadBubble = true
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            //image = painterResource(id = R.drawable.settings),
            label = "Settings",
            showUnreadBubble = true
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            //image = painterResource(id = R.drawable.log_out),
            label = "Logout",
            showUnreadBubble = true
        )
    )

    return itemsList
}
