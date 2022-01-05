package com.noor.yasser.ps.jetpackcomposebasics.L16_bark.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen.ui.theme.Purple200,
    primaryVariant = com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen.ui.theme.Purple700,
    secondary = com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen.ui.theme.Teal200,
    background = blueBGNight,
    surface = pinkText,
    onSurface = cardNight
)

private val LightColorPalette = lightColors(
    primary = com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen.ui.theme.Purple500,
    primaryVariant = com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen.ui.theme.Purple700,
    secondary = com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen.ui.theme.Teal200,
    background = blueBG,
    surface = blueText,
    onSurface = card

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
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
