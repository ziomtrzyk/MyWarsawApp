package com.example.mywarsawapp.model

import android.view.Display
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.painterResource
import com.example.mywarsawapp.R

enum class TypeOfPlace(val displayName : String, @DrawableRes val imageRes: Int, @StringRes val title: Int){
    RESTAURANT("Restauracje", R.drawable.restaurant, R.string.restaurant),
    GALLERY("Galerie", R.drawable.galeria, R.string.gallery),
    COFEE("Kawiarnie", R.drawable.cofee, R.string.cofee),
    PARK("Parki", R.drawable.park, R.string.park),
    MUSEUM("Muzea", R.drawable.museum, R.string.museum)
}

class Place(
    val type: TypeOfPlace,
    @StringRes val title: Int,
    @StringRes val description: Int
)