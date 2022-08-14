package com.applecompose.oregonbreweries.presentations.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.applecompose.oregonbreweries.presentations.screens.BreweriesViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: BreweriesViewModel = hiltViewModel()) {
	val brewery = viewModel.data.value.data?.toMutableList()

	if (viewModel.data.value.loading == true) {
		CircularProgressIndicator()
	} else {
		brewery?.forEach { breweryItem ->
			Column() {
				Card(
					modifier = Modifier
						.padding(6.dp)
						.fillMaxWidth(),
					shape = RoundedCornerShape(16.dp),
					elevation = 4.dp
				) {
					Column() {
						Text(text = "Name: ${breweryItem.name}")
						Text(text = "Type: ${breweryItem.brewery_type}")
						Text(text = "Address: ${breweryItem.street}")
					}



				}

				Text(text = "Name: ${brewery.size}")
			}


		}
	}
}




