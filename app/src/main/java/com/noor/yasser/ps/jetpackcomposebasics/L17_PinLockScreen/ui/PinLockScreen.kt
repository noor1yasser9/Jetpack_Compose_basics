package com.noor.yasser.ps.jetpackcomposebasics.L17_PinLockScreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.noor.yasser.ps.jetpackcomposebasics.R
import kotlinx.coroutines.delay


const val pinSize = 4
const val password = "1234" //sample password

@Composable
fun PinLockScreen() {
    val inputPin = remember { mutableStateListOf<Int>() }
    val error = remember { mutableStateOf<String>("") }
    val showSuccess = remember { mutableStateOf(false) }
    val context = LocalContext.current


    if (inputPin.size == 4) {
        LaunchedEffect(true) {
            delay(300)
            if (inputPin.joinToString("") == password) {
                showSuccess.value = true
                error.value = ""
            } else {
                inputPin.clear()
                error.value = "Wrong pin, Please retry!"
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(id = R.drawable.wiggle_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Enter pin to unlock",
                    style = typography.h6,
                    modifier = Modifier.padding(16.dp),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(30.dp))
                if (showSuccess.value) {

                }
            }
        }
    }
}