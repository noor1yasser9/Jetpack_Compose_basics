package com.noor.yasser.ps.jetpackcomposebasics.complex_custom_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.noor.yasser.ps.jetpackcomposebasics.jetpack_compose_basics_1.ui.theme.BasicsCodelabTheme
import java.lang.reflect.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

@Composable
fun StaggeredGrid(
    modifier: Modifier = Modifier(),
    row: Int = 3,
    content: @Composable () -> Unit
) {

}

