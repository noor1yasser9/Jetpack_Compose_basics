package com.noor.yasser.ps.jetpackcomposebasics.complex_custom_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.noor.yasser.ps.jetpackcomposebasics.complex_custom_layout.dammy_data.topics
import com.noor.yasser.ps.jetpackcomposebasics.jetpack_compose_basics_1.ui.theme.BasicsCodelabTheme
import com.noor.yasser.ps.jetpackcomposebasics.L12_Draggable_Music_Knob.ui.theme.LayoutsCodelabTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LayoutsCodelabPreview()
                }
            }
        }
    }
}

@Composable
fun StaggeredGrid(
    modifier: Modifier = Modifier,
    rowas: Int = 3,
    content: @Composable () -> Unit
) {
    Layout(content = content, modifier = modifier) { measurables, constraints ->

        val rowWidth = IntArray(rowas) { 0 }
        val rowHeights = IntArray(rowas) { 0 }

        val placeables = measurables.mapIndexed { index, measurable ->

            val placeable = measurable.measure(constraints = constraints)
            val row = index % rowas
            rowWidth[row] += placeable.width
            rowHeights[row] = Math.max(rowHeights[row], placeable.height)
            placeable
        }
        val width = rowWidth.maxOrNull()
            ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth)) ?: constraints.minWidth
        val height = rowHeights.sumOf { it }
            .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))

        val rowY = IntArray(rowas) { 0 }
        for (i in 1 until rowas) {
            rowY[i] = rowY[i - 1] + rowHeights[i - 1]
        }

        layout(width, height) {
            val rowX = IntArray(rowas) { 0 }
            placeables.forEachIndexed { index, placeable ->
                val row = index % rowas
                placeable.placeRelative(
                    x = rowX[row],
                    y = rowY[row]
                )
                rowX[row] += placeable.width
            }
        }

    }

}


@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
    Card(
        modifier = modifier.background(color = Color.Transparent),
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
    ) {

        Row(
            modifier = Modifier.padding(
                start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp,
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(16.dp, 16.dp)
                    .background(color = MaterialTheme.colors.secondary)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = text)

        }

    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Row(modifier = modifier.horizontalScroll(rememberScrollState())) {
        StaggeredGrid(modifier = modifier) {
            for (topic in topics)
                Chip(
                    text = topic,
                    modifier = modifier
                )

        }
    }
}


@Preview
@Composable
fun ChipPreview() {
    LayoutsCodelabTheme {
        BodyContent()
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        BodyContent(
            Modifier.padding(
                8.dp
            )
        )
    }
}


@Stable
fun Modifier.padding(all: Dp) =
    this.then(
        PaddingModifier(
            start = all,
            top = all,
            end = all,
            bottom = all,
            rtlAware = true
        )
    )

// Implementation detail
private class PaddingModifier(
    val start: Dp = 0.dp,
    val top: Dp = 0.dp,
    val end: Dp = 0.dp,
    val bottom: Dp = 0.dp,
    val rtlAware: Boolean,
) : LayoutModifier {
    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val horizontal = start.roundToPx() + end.roundToPx()
        val vertical = top.roundToPx() + bottom.roundToPx()
        val placeable = measurable.measure(constraints = constraints.offset(-horizontal, -vertical))

        val width = constraints.constrainWidth(placeable.width + horizontal)
        val height = constraints.constrainHeight(placeable.height + vertical)
        return layout(width = width, height = height) {
            if (rtlAware)
                placeable.placeRelative(start.roundToPx(), top.roundToPx())
            else
                placeable.place(start.roundToPx(), top.roundToPx())
        }
    }

}