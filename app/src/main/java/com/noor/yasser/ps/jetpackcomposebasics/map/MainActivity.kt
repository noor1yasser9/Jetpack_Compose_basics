package com.noor.yasser.ps.jetpackcomposebasics.map

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.noor.yasser.ps.jetpackcomposebasics.map.ui.theme.MapsComposeGuideTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapsComposeGuideTheme {

            }
        }
    }
}