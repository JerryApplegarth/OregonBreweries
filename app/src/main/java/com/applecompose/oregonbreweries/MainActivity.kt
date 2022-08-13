package com.applecompose.oregonbreweries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.applecompose.oregonbreweries.presentations.screens.BreweriesViewModel
import com.applecompose.oregonbreweries.ui.theme.OregonBreweriesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			OregonBreweriesTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					MainScreen()
				}
			}
		}
	}
}

@Composable
fun MainScreen(viewModel: BreweriesViewModel = hiltViewModel()) {
	BreweriesApp(viewModel)
}

@Composable
fun BreweriesApp(viewModel: BreweriesViewModel) {

	Text(text = "Breweries: ${viewModel.getTotalBreweriesCount()}")

//	Text(text = "Text goes here")
//
//	val oregonBreweries = viewModel.data.value.data?.toMutableList()
//	val oregonBreweriesIndex = remember { mutableStateOf("") }

//	if (viewModel.data.value.loading == true) {
//		CircularProgressIndicator()
//	} else {
//		val oregonBrewery = try {
//			oregonBreweries?.get(oregonBreweriesIndex.value.toInt())
//		} catch (ex: Exception) {
//			null
//		}
//		Text(text = "Something here: ${oregonBrewery.toString()}")






}