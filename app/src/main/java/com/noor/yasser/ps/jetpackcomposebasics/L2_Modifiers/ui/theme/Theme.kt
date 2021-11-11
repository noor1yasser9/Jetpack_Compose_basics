package com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    secondary = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.Teal200,
    surface = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.Blue,
    onSurface = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.Navy,
    primary = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.Navy,
    onPrimary = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.Chartreuse
)

private val LightColorPalette = lightColors(
    primaryVariant = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.Navy,
    secondary = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.Teal200,
    surface = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.Blue,
    onSurface = Color.White,
    primary = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.LightBlue,
    onPrimary = com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers.ui.theme.Navy
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BasicsCodelabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = com.noor.yasser.ps.jetpackcomposebasics.layouts_in_jetpack_compose_2.ui.theme.Typography,
        shapes = Shapes,
        content = content
    )
}