package com.noor.yasser.ps.jetpackcomposebasics.L2_Modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Green)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(4.dp,color = Color.Magenta)
                    .padding(16.dp)
                    .border(4.dp,color = Color.Black)
                    .padding(16.dp)
                    .border(4.dp,color = Color.White)
                    .padding(16.dp)
//                    .width(300.dp)
//                    .requiredWidth(300.dp)
            ) {
                Text(
                    text = "Hello",
                    modifier = Modifier
                        .border(5.dp,Color.Cyan)
                        .padding(5.dp)
                        .offset(20.dp,20.dp)
                        .border(10.dp,Color.Black)
                        .padding(10.dp)
                        .clickable {

                        }

                )
                Spacer(modifier = Modifier.height(50.dp))
                Text(text = "World")
            }
        }
    }
}




