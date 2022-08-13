package com.applecompose.oregonbreweries.presentations.screens.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.applecompose.oregonbreweries.data.DataOrException
import com.applecompose.oregonbreweries.data.model.BreweriesItem
import com.applecompose.oregonbreweries.presentations.screens.BreweriesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: BreweriesViewModel = hiltViewModel()) {
	ShowData(viewModel)

}

@Composable
fun ShowData(viewModel: BreweriesViewModel) {
	val brewery = viewModel.data.value.data?.toMutableList()
	if (viewModel.data.value.loading == true) {
		Log.d("LOADING", "ShowData: Loading.....")
	}else {
		brewery?.forEach { breweryItem ->
			Log.d("TYPE", "ShowData: ${breweryItem.brewery_type}")
		}
	}


	Text(text = "Main Screen")

}