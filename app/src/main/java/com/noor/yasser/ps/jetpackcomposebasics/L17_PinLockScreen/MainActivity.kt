package com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen.ui.PinLockScreen
import com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen.ui.theme.PinLockScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PinLockScreenTheme {
                Surface(color = MaterialTheme.colors.background) {
                    PinLockScreen()
                }
            }
        }
    }
}