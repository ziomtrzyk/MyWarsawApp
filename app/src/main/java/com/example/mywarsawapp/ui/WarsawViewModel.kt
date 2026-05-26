package com.example.mywarsawapp.ui

import androidx.lifecycle.ViewModel
import com.example.mywarsawapp.data.WarsawPlacesDataProvider
import com.example.mywarsawapp.model.Place
import com.example.mywarsawapp.model.TypeOfPlace
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class WarsawViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(WarsawUiState())

    val uiState: StateFlow<WarsawUiState> = _uiState

    init {
        val groupedPlacesList: Map<TypeOfPlace, List<Place>> = WarsawPlacesDataProvider.places.groupBy { it.type }
        _uiState.value =
            WarsawUiState(
                groupedPlacesList
            )
    }

    fun updateCategoryAndTitle(currentCategory: TypeOfPlace){
        _uiState.update {
            it.copy(
                currentCategory = currentCategory,
                currentTitle = currentCategory.title
            )
        }
    }

    fun updateCategory(currentCategory: TypeOfPlace){
        _uiState.update {
            it.copy(
                currentCategory = currentCategory
            )
        }
    }

    fun updatePlaceAndTitle(currentPlace: Place){
        _uiState.update {
            it.copy(
                currentPlace = currentPlace,
                currentTitle = currentPlace.title
            )
        }
    }
    fun updatePlace(currentPlace: Place){
        _uiState.update {
            it.copy(
                currentPlace = currentPlace
            )
        }
    }

}