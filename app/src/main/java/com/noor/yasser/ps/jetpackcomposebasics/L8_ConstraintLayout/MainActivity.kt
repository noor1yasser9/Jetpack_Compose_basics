package com.noor.yasser.ps.jetpackcomposebasics.L8_ConstraintLayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
//import com.noor.yasser.ps.jetpackcomposebasics.complex_custom_layout.padding


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")
                val guideline = createGuidelineFromTop(0.5f)
                constrain(greenBox) {
                    top.linkTo(guideline)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(redBox) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(greenBox.end)
                    width = Dimension.fillToConstraints
//                    value(100.dp)
                    height = Dimension.value(100.dp)
                }

                createHorizontalChain(greenBox,redBox,chainStyle = ChainStyle.Packed)
            }
            ConstraintLayout(
                constraints,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(modifier = Modifier.background(Color.Green)
                    .layoutId("greenBox"))
                Box(modifier = Modifier.background(Color.Red)
                    .layoutId("redBox"))
            }
        }
    }
}






