package com.example.mywarsawapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.painterResource
import com.example.mywarsawapp.R
import com.example.mywarsawapp.model.Place
import com.example.mywarsawapp.model.TypeOfPlace

data class WarsawUiState(
    val groupedPlaceList: Map<TypeOfPlace, List<Place>> = emptyMap(),
    @StringRes val currentTitle: Int = R.string.app_name,
    val currentCategory: TypeOfPlace = TypeOfPlace.RESTAURANT,
    val currentPlace: Place? = groupedPlaceList.get(TypeOfPlace.RESTAURANT)?.get(0) ?: null,
)
