package com.noor.yasser.ps.jetpackcomposebasics.L16_bark


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.noor.yasser.ps.jetpackcomposebasics.L16_bark.ui.theme.MyTheme
import com.noor.yasser.ps.jetpackcomposebasics.L16_bark.view.WigglesMain


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}


@ExperimentalAnimationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WigglesMain(toggleTheme = { })
    }
}