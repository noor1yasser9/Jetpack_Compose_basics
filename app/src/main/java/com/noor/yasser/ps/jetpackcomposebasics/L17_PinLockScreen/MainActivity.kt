package com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.noor.yasser.ps.jetpackcomposebasics.L16_bark.ui.theme.MyTheme
import com.noor.yasser.ps.jetpackcomposebasics.L16_bark.view.WigglesMain

@ExperimentalAnimationApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }}}