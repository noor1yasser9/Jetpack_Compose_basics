package com.noor.yasser.ps.jetpackcomposebasics.map.presentation

import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.noor.yasser.ps.jetpackcomposebasics.map.domain.model.ParkingSpot

data class MapState(
    val properties: MapProperties = MapProperties(),
    val parkingSpots: List<ParkingSpot> = emptyList(),
    val isFalloutMap: Boolean = false
)