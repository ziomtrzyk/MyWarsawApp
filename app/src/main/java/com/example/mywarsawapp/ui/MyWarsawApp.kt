package com.example.mywarsawapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import com.example.mywarsawapp.R
import com.example.mywarsawapp.data.WarsawPlacesDataProvider
import com.example.mywarsawapp.model.Place
import com.example.mywarsawapp.model.TypeOfPlace
import com.example.mywarsawapp.ui.utils.WarsawScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import java.lang.reflect.Type

@Composable
fun MyWarsawApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val viewModel: WarsawViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            WarsawAppBar(
                uiState.currentTitle,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = WarsawScreen.CATEGORIES.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = WarsawScreen.CATEGORIES.name) {
                CategoriesList(
                    onClick = {
                        navController.navigate(WarsawScreen.PLACES.name)
                        viewModel.updateCategory(it)
                    })
            }
            composable(route = WarsawScreen.PLACES.name){
                PlacesList(
                    uiState.groupedPlaceList[uiState.currentCategory]?: emptyList(),
                    onClick = {
                        navController.navigate(WarsawScreen.DESCRIPTION.name)
                        viewModel.updatePlace(it)
                    }
                )
            }
            composable(route = WarsawScreen.DESCRIPTION.name) {
                DescriptionOfPlace(uiState.currentPlace!!)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WarsawAppBar(
    @StringRes currentTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(currentTitle),
                fontSize = 32.sp
            )
        },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }

    )
}

@Composable
fun PlacesList(
    places: List<Place>,
    onClick: (Place) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium))
    ) {
        items(places) { place ->
            PlaceCard(place = place, onClick = onClick)
        }
    }
}

@Composable
fun CategoriesList(
    onClick: (TypeOfPlace) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    val types = TypeOfPlace.entries.toList()
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium))
    ) {
        items(TypeOfPlace.entries) { place ->
            PlaceCard(place, onClick)
        }
    }
}

@Composable
fun DescriptionOfPlace(place: Place) {
    Column() {
        Image(
            painter = painterResource(place.type.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius))),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = stringResource(place.description),
            modifier = Modifier
                .padding(8.dp),
            textAlign = TextAlign.Justify
        )
    }
}


@Composable
fun PlaceCard(
    place: Place,
    onClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        modifier = modifier,
        onClick = { onClick(place) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(place.type.imageRes),
                contentDescription = place.type.displayName,
                modifier = Modifier
                    .fillMaxHeight()
            )
            Text(
                text = stringResource(place.title),
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun PlaceCard(
    typeOfPlace: TypeOfPlace,
    onClick: (TypeOfPlace) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        modifier = modifier.clipToBounds(),
        onClick = { onClick(typeOfPlace) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(typeOfPlace.imageRes),
                contentDescription = typeOfPlace.displayName,
                modifier = Modifier
                    .fillMaxHeight()
            )
            Text(
                text = typeOfPlace.displayName,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

//@Preview
@Composable
fun checkPlaceCard() {
    val place = WarsawPlacesDataProvider.places[0]
    @DrawableRes val imageRes: Int = R.drawable.cofee
    PlaceCard(place, onClick = {})
}

//@Preview
@Composable
fun checkTypeOfPlaceCard() {
    PlaceCard(TypeOfPlace.COFEE, onClick = {})
}

//@Preview
@Composable
fun checkListOfPlace() {
    val viewModel: WarsawViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    PlacesList(uiState.cofeePlacesList, onClick = {})
}

@Preview
@Composable
fun checkDescriptionOfPlace() {
    //DescriptionOfPlace(WarsawPlacesDataProvider.places[0])
    CategoriesList(onClick = {})
}