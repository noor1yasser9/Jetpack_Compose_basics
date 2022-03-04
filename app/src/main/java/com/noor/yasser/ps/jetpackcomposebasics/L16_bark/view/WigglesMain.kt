package com.noor.yasser.ps.jetpackcomposebasics.L16_bark.view

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
//import androidx.navigation.compose.navArgument
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.noor.yasser.ps.jetpackcomposebasics.L16_bark.data.FakeDogDatabase
import com.noor.yasser.ps.jetpackcomposebasics.L16_bark.navigation.Screen


@ExperimentalAnimationApi
@Composable
fun WigglesMain(toggleTheme: () -> Unit) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController, startDestination = Screen.Home.route) {
        composable(
            Screen.Home.route,
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
        ) {
            Home(navController, FakeDogDatabase.dogList, toggleTheme)
        }
        composable(
            "${Screen.Details.route}/{id}/{title}/{location}",
            enterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
//            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            Details(navController, it.arguments?.getInt("id") ?: 0)
        }
    }
}
