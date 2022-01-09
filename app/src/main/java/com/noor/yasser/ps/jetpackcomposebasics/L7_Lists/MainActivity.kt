package com.noor.yasser.ps.jetpackcomposebasics.L7_Lists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.noor.yasser.ps.jetpackcomposebasics.complex_custom_layout.padding
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val scrollState = rememberScrollState()
//            Column(
//                modifier = Modifier.verticalScroll(scrollState)
//            ) {
//                for (i in 1..50) {
//                    Text(
//                        text = "Item $i",
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 24.dp)
//                    )
//                }
//            }

            val tasks = listOf(
                Task("Buy Milk and eggs!"),
                Task("Run 3 miles"),
                Task("Take puppy to clinic"),
                Task("Plan for weekend trip"),
                Task("2 Buy Milk and eggs!"),
                Task("3 Run 3 miles"),
                Task("4 Take puppy to clinic"),
                Task("6 Plan for weekend trip")
            )
            TaskListScreen(tasks)
//            listLaze()
        }
    }
}

@Composable
fun listLaze() {
    LazyColumn {
        itemsIndexed(
            listOf(
                "This",
                "is",
                "Jetpack",
                "Compose",
                "This",
                "is",
                "Jetpack",
                "Compose",
                "This",
                "is",
                "Jetpack",
                "Compose2",
                "This",
                "is",
                "Jetpack",
                "Compose",
                "This",
                "is",
                "Jetpack",
                "Compose"
            )
        ) { index, item ->
            Text(
                text = item,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
        }
    }
}


@Composable
fun TaskListScreen(tasks: List<Task>) {
    // A surface container using the 'background' color from the theme
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Surface(color = MaterialTheme.colors.background) {
            LazyColumn(modifier = Modifier.testTag(TASK_LIST_TEST_TAG)) {
                items(tasks) { task ->
//                Text(text =)
                    Text(
                        text = task.description,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                            .clickable {
                                coroutineScope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar(task.description)
                                }
                            }
                    )
                }
            }
        }
    }
}

data class Task(val description: String)


const val TASK_LIST_TEST_TAG = "task_list_test_tag"




