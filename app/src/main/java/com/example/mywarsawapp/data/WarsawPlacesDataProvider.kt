package com.example.mywarsawapp.data

import com.example.mywarsawapp.R
import com.example.mywarsawapp.model.Place
import com.example.mywarsawapp.model.TypeOfPlace

object WarsawPlacesDataProvider {

    val places = listOf(
        Place(TypeOfPlace.RESTAURANT, R.string.restaurant_1_title, R.string.restaurant_1_desc),
        Place(TypeOfPlace.RESTAURANT, R.string.restaurant_2_title, R.string.restaurant_2_desc),
        Place(TypeOfPlace.RESTAURANT, R.string.restaurant_3_title, R.string.restaurant_3_desc),
        Place(TypeOfPlace.RESTAURANT, R.string.restaurant_4_title, R.string.restaurant_4_desc),
        Place(TypeOfPlace.RESTAURANT, R.string.restaurant_5_title, R.string.restaurant_5_desc),
        Place(TypeOfPlace.RESTAURANT, R.string.restaurant_6_title, R.string.restaurant_6_desc),

        Place(TypeOfPlace.COFEE, R.string.coffee_1_title, R.string.coffee_1_desc),
        Place(TypeOfPlace.COFEE, R.string.coffee_2_title, R.string.coffee_2_desc),
        Place(TypeOfPlace.COFEE, R.string.coffee_3_title, R.string.coffee_3_desc),
        Place(TypeOfPlace.COFEE, R.string.coffee_4_title, R.string.coffee_4_desc),
        Place(TypeOfPlace.COFEE, R.string.coffee_5_title, R.string.coffee_5_desc),
        Place(TypeOfPlace.COFEE, R.string.coffee_6_title, R.string.coffee_6_desc),

        Place(TypeOfPlace.PARK, R.string.park_1_title, R.string.park_1_desc),
        Place(TypeOfPlace.PARK, R.string.park_2_title, R.string.park_2_desc),
        Place(TypeOfPlace.PARK, R.string.park_3_title, R.string.park_3_desc),
        Place(TypeOfPlace.PARK, R.string.park_4_title, R.string.park_4_desc),
        Place(TypeOfPlace.PARK, R.string.park_5_title, R.string.park_5_desc),
        Place(TypeOfPlace.PARK, R.string.park_6_title, R.string.park_6_desc),

        Place(TypeOfPlace.GALLERY, R.string.gallery_1_title, R.string.gallery_1_desc),
        Place(TypeOfPlace.GALLERY, R.string.gallery_2_title, R.string.gallery_2_desc),
        Place(TypeOfPlace.GALLERY, R.string.gallery_3_title, R.string.gallery_3_desc),
        Place(TypeOfPlace.GALLERY, R.string.gallery_4_title, R.string.gallery_4_desc),
        Place(TypeOfPlace.GALLERY, R.string.gallery_5_title, R.string.gallery_5_desc),
        Place(TypeOfPlace.GALLERY, R.string.gallery_6_title, R.string.gallery_6_desc),

        Place(TypeOfPlace.MUSEUM, R.string.museum_1_title, R.string.museum_1_desc),
        Place(TypeOfPlace.MUSEUM, R.string.museum_2_title, R.string.museum_2_desc),
        Place(TypeOfPlace.MUSEUM, R.string.museum_3_title, R.string.museum_3_desc),
        Place(TypeOfPlace.MUSEUM, R.string.museum_4_title, R.string.museum_4_desc),
        Place(TypeOfPlace.MUSEUM, R.string.museum_5_title, R.string.museum_5_desc),
        Place(TypeOfPlace.MUSEUM, R.string.museum_6_title, R.string.museum_6_desc),
    )

}