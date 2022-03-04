package com.noor.yasser.ps.jetpackcomposebasics.map.presentation

import com.google.android.gms.maps.model.LatLng
import com.noor.yasser.ps.jetpackcomposebasics.map.domain.model.ParkingSpot

sealed class MapEvent {
    object ToggleFalloutMap : MapEvent()
    data class OnMapLongClick(val latLng: LatLng) : MapEvent()
    data class OnInfoWindowLongClick(val spot: ParkingSpot) : MapEvent()
}