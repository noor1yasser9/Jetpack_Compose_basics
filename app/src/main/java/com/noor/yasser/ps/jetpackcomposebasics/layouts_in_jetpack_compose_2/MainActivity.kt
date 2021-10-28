package com.noor.yasser.ps.jetpackcomposebasics.layouts_in_jetpack_compose_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.noor.yasser.ps.jetpackcomposebasics.layouts_in_jetpack_compose_2.ui.theme.LayoutsCodelabTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsCodelabTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
private fun MyApp() {
    LayoutsCodelab()
}


@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Column() {
        Row(
            modifier = modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .clickable { }
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier
                    .size(50.dp),
                shape = CircleShape,
                color = MaterialTheme
                    .colors
                    .onSurface
                    .copy(alpha = 0.2f)
            ) {

            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Alfred Sisley",
                    fontWeight = FontWeight.Bold
                )
                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.medium
                ) {
                    Text(
                        text = "3 minutes ago",
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
        Button(
            onClick = { /*TODO*/ }, modifier = modifier
                .padding(8.dp)
        ) {
            Row {
                Image(imageVector = Icons.Filled.Favorite, contentDescription = "")
                Spacer(modifier = Modifier.size(4.dp))
                Text("Button")
            }
        }
    }
}

@Composable
fun LayoutsCodelab() {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Filled.Favorite, contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Column {
            Row {
                Button(onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }) {
                    Text("Scroll to the top")
                }
                Spacer(Modifier.width(10.dp))
                Button(onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(100 - 1)
                    }
                }) {
                    Text("Scroll to the end")
                }
            }
            BodyContent(
                Modifier
                    .padding(innerPadding)
                    .padding(8.dp)
            )
            LazyList(scrollState)
        }
    }
}

@Composable
fun LazyList(scrollState:LazyListState) {

    LazyColumn(state = scrollState) {
        items(100) {
            ImageListItem(it)
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}


@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    LayoutsCodelabTheme {
        PhotographerCard()
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}