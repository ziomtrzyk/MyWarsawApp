package com.example.mywarsawapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.painterResource
import com.example.mywarsawapp.R
import com.example.mywarsawapp.model.Place
import com.example.mywarsawapp.model.TypeOfPlace

data class WarsawUiState(
    val groupedPlaceList: Map<TypeOfPlace, List<Place>> = emptyMap(),
    val restaurantPlacesList: List<Place> = emptyList(),
    val galerryPlacesList: List<Place> = emptyList(),
    val cofeePlacesList: List<Place> = emptyList(),
    val parkPlacesList: List<Place> = emptyList(),
    val museumPlacesList: List<Place> = emptyList(),
    @StringRes val currentTitle: Int = R.string.app_name,
    val currentCategory: TypeOfPlace? = null,
    val currentPlace: Place? = null,
)
