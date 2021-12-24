package com.noor.yasser.ps.jetpackcomposebasics.L13_Making_a_Meditation

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.noor.yasser.ps.jetpackcomposebasics.L13_Making_a_Meditation.ui.HomeScreen
import com.noor.yasser.ps.jetpackcomposebasics.L13_Making_a_Meditation.ui.theme.MeditationUIYouTubeTheme
import com.noor.yasser.ps.jetpackcomposebasics.R
import com.noor.yasser.ps.jetpackcomposebasics.complex_custom_layout.padding
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.roundToInt

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


