package com.applecompose.oregonbreweries.presentations.screens.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.applecompose.oregonbreweries.presentations.screens.BreweriesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: BreweriesViewModel = hiltViewModel()) {
	Text(text = "Main Screen")

}