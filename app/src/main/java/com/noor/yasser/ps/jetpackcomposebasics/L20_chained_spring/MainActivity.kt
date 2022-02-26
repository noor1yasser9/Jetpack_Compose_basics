package com.noor.yasser.ps.jetpackcomposebasics.L20_chained_spring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.noor.yasser.ps.jetpackcomposebasics.L20_chained_spring.ui.theme.BasicsCodelabTheme
import kotlinx.coroutines.delay
import kotlin.math.max


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChainedSpring()
        }
    }
}


@Preview
@Composable
fun ChainedSpring() {
    var moved by remember { mutableStateOf(false) }

    BasicsCodelabTheme() {
        Surface(
            Modifier
                .fillMaxSize()
                .clickable(
                    onClick = { moved = !moved },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                for (i in 0 until 8) {
                    Ring(
                        moved = moved,
                        idx = i,
                        size = (16 + 22 * i).dp
                    )
                }
            }
        }
    }
}


@Composable
private fun Ring(
    idx: Int,
    moved: Boolean,
    size: Dp
) {
    val offset = remember { Animatable(-150f) }

    LaunchedEffect(moved) {
        delay((80 + 40 * idx).toLong())
        offset.animateTo(
            targetValue = if (moved) 150f else -150f,
            animationSpec = spring(
                dampingRatio = 0.22f - 0.002f * max(idx, 1),
                stiffness = 200f + 10f * max(idx, 1)
            )
        )
    }

    Canvas(
        Modifier
            .size(size)
            .offset(y = (offset.value).dp)
            .graphicsLayer { rotationX = 72f }
    ) {
        drawRing()
    }
}

private fun DrawScope.drawRing() {
    drawArc(
        color = Color.Black,
        startAngle = 0f,
        sweepAngle = 360f,
        useCenter = true,
        style = Stroke(16f)
    )
}


