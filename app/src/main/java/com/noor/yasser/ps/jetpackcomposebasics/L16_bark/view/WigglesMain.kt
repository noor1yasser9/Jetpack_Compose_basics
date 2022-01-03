package com.noor.yasser.ps.jetpackcomposebasics.L16_bark.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Composable
fun WigglesMain(toggleTheme: () -> Unit) {
    val navController = rememberAnimatedNavController()


}