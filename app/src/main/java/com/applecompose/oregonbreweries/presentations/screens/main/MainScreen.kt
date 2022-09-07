package com.applecompose.oregonbreweries.presentations.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
	) {
		
		LazyColumn(

			modifier = Modifier
				.fillMaxWidth(),
			contentPadding = PaddingValues(16.dp)
		) {
			item {
				MyBreweries(viewModel = viewModel)

			}
		}
	}
}


@Composable
fun MyBreweries(
	viewModel: BreweriesViewModel,
	) {
	val brewery = viewModel.data.value.data?.toMutableList()



	if (viewModel.data.value.loading == true) {
		CircularProgressIndicator()
	} else {

		brewery?.forEach { breweryRow ->



			Surface {
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
							.fillMaxWidth(),
						shape = MaterialTheme.shapes.large,
						elevation = 4.dp,

					) {
						Column(
							modifier = Modifier
								.padding(15.dp)

						) {
							Text(
								"Name: ${breweryRow.name}",

								fontSize = 20.sp,
								fontWeight = FontWeight.Bold
							)
							Text(
								"City: ${breweryRow.city}",

								fontSize = 16.sp,
								fontWeight = FontWeight.Light
							)
							Text(
								"Type: ${breweryRow.brewery_type}",

								fontSize = 16.sp,
								fontWeight = FontWeight.Light
							)
							Text(
								"Website: ${breweryRow.website_url}",
								fontSize = 16.sp,
								fontWeight = FontWeight.Light
							)
							Text(
								"Address: ${breweryRow.street}",
								fontSize = 16.sp,
								fontWeight = FontWeight.Light
							)
							Text(
								"Phone: ${breweryRow.phone}",
								fontSize = 16.sp,
								fontWeight = FontWeight.Light
							)

						}
					}
				}
			}
		}
	}
}






















