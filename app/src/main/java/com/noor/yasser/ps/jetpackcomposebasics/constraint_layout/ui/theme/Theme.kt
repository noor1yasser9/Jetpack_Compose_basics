package com.noor.yasser.ps.jetpackcomposebasics.constraint_layout.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PinkThemeLight = lightColors(
    primary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.pink500,
    secondary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.pink500,
    primaryVariant = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.pink600,
    onPrimary = Color.Black,
    onSecondary = Color.Black
)


private val BlueThemeLight = lightColors(
    primary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.blue700,
    onPrimary = Color.White,
    primaryVariant = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.blue800,
    secondary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.yellow500
)

private val BlueThemeDark = darkColors(
    primary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.blue200,
    secondary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.yellow200,
    surface = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.blueDarkPrimary
)


private val YellowThemeLight = lightColors(
    primary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.yellow500,
    primaryVariant = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.yellow400,
    onPrimary = Color.Black,
    secondary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.blue700,
    secondaryVariant = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.blue800,
    onSecondary = Color.White
)

private val YellowThemeDark = darkColors(
    primary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.yellow200,
    secondary = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.blue200,
    onSecondary = Color.Black,
    surface = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.yellowDarkPrimary
)



@Composable
fun BasicsCodelabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        YellowThemeDark
    } else {
        YellowThemeLight
    }

    MaterialTheme(
        colors = colors,
        typography = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.Typography,
        shapes = com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.theme.Shapes,
        content = content
    )
}