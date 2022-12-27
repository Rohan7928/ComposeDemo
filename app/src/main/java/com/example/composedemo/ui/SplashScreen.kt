package com.example.composedemo.ui

import android.content.res.Configuration
import android.graphics.SweepGradient
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composedemo.R
import com.example.composedemo.theme.ComposeDemoTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    gradientColors: List<Color> = listOf(Color(0xFFF70A74), Color(0xFFF59118)),
    navController: NavHostController
) = Box(
    modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(brush = Brush.horizontalGradient(colors = gradientColors)),
    contentAlignment = Alignment.Center
) {

    val scale = remember {
        androidx.compose.animation.core.Animatable(0.0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f, animationSpec = tween(800, easing = {
                OvershootInterpolator(4f).getInterpolation(it)
            })
        )
        delay(1000)
        navController.navigate(Routes.LoginPage.route) {
            popUpTo(Routes.SplashScreen.route) {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier.size(800.dp), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = "Contact profile picture",

            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)

        )
    }


}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {}
}
