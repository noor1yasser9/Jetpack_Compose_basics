package com.noor.yasser.ps.jetpackcomposebasics.L13_Making_a_Meditation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import com.noor.yasser.ps.jetpackcomposebasics.L13_Making_a_Meditation.MeditationUIYouTubeTheme
import com.noor.yasser.ps.jetpackcomposebasics.L13_Making_a_Meditation.ui.HomeScreen

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MeditationUIYouTubeTheme {
                HomeScreen()
            }

        }
    }
}


