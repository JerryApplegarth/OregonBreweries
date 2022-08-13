package com.applecompose.oregonbreweries.presentations.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
			val myList = breweryItem.brewery_type
			val name = breweryItem.name
			val city = breweryItem.city
			Scaffold(
				topBar = {
					TopAppBar(
						backgroundColor = MaterialTheme.colors.primary,
						title = { Text(stringResource(com.applecompose.oregonbreweries.R.string.app_name)) }
					)
				}
			) {
				LazyColumn(
					modifier = Modifier.fillMaxWidth(),
					contentPadding = PaddingValues(16.dp)
				) {
					item {
						Column(
							modifier = Modifier
								.fillMaxWidth()
								.wrapContentHeight()
								.padding(vertical = 25.dp),
							horizontalAlignment = Alignment.Start,
							verticalArrangement = Arrangement.Top

						) {
							Text(text = myList)
						}

					}
				}
			}
		}
	}

}






