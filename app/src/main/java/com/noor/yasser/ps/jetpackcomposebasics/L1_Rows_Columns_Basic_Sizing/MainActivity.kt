package com.noor.yasser.ps.jetpackcomposebasics.L1_Rows_Columns_Basic_Sizing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Green),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceAround
////                SpaceBetween
//            ) {
//                Text(text = "Hello World")
//                Text(text = "Hello World")
//                Text(text = "Noor")
//                Text(text = "Noor")
//            }
            Row(
                modifier = Modifier
//                    .fillMaxSize(0.5f)
//                    .width(300.dp)
//                    .height(300.dp)
                    .fillMaxHeight(0.7f)
                    .fillMaxWidth(0.9f)
                    .background(Color.Green),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Noor")
                Text(text = "Hello World")
                Text(text = "Noor")
            }
        }
    }
}




