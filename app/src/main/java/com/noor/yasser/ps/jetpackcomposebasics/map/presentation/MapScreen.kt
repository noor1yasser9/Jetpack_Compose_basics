package com.noor.yasser.ps.jetpackcomposebasics.map.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

@Composable
fun MapScreen(
    viewModel: MapsViewModel
    = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val uiSettings = remember {
        MapUiSettings(
            zoomControlsEnabled = false
        )
    }

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {
                Icon(
                    imageVector = if (viewModel.state.isFalloutMap)
                        Icons.Default.ToggleOff
                    else Icons.Default.ToggleOn,
                    contentDescription = "Toggle Fallout map"
                )
            }
        }
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = viewModel.state.properties,
            uiSettings = uiSettings,

            ) {
            viewModel.state.parkingSpots.forEach { spot ->
            }
        }
    }
}