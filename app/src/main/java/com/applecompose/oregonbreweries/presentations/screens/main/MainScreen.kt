package com.applecompose.oregonbreweries.presentations.screens.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.applecompose.oregonbreweries.presentations.screens.BreweriesViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: BreweriesViewModel = hiltViewModel()) {

	MyBreweries(viewModel = viewModel)

}


@Composable
fun MyBreweries(viewModel: BreweriesViewModel) {

	val brewery = viewModel.data.value.data?.toMutableList()
	if (viewModel.data.value.loading == true) {
		CircularProgressIndicator()
	} else {
		brewery?.forEach { breweryRow ->
			Log.d("NAME", "MyBreweries: ${breweryRow.name}")
			Text(text = "Name: ${breweryRow.name}")

		}
	}
}
















