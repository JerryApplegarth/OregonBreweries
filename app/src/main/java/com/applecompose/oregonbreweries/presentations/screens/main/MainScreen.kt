package com.applecompose.oregonbreweries.presentations.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.applecompose.oregonbreweries.R
import com.applecompose.oregonbreweries.presentations.screens.BreweriesViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: BreweriesViewModel = hiltViewModel()) {
	Scaffold(topBar = {
		TopAppBar(
			backgroundColor = MaterialTheme.colors.primary,
			title = { Text(text = stringResource(id = R.string.app_name)) }
		)
	}
	){
		MyBreweries(viewModel = viewModel)
	}

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

			Surface() {
				Column(
					modifier = Modifier
						.fillMaxWidth()
						.padding(start = 16.dp)
						.padding(6.dp),
					horizontalAlignment = Alignment.Start,
					verticalArrangement = Arrangement.Top
				) {
					Card(
						modifier = Modifier
							.padding(4.dp)
					) {
						Column() {
							Text(text = "Name: ${breweryRow.name}")
							Text(text = "Type: ${breweryRow.brewery_type}")
						}


					}

				}

			}

		}
	}
}
















