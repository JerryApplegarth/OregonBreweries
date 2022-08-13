package com.applecompose.oregonbreweries.presentations.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.applecompose.oregonbreweries.presentations.screens.BreweriesViewModel
import com.applecompose.oregonbreweries.presentations.screens.main.MainScreen
import com.applecompose.oregonbreweries.presentations.screens.splash.SplashScreen

@Composable
fun Navigation() {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {

		composable(Screen.SplashScreen.route) {
			SplashScreen(navController = navController)
		}
		composable(Screen.MainScreen.route) {
			val mainViewModel = hiltViewModel<BreweriesViewModel>()


			MainScreen(navController = navController, mainViewModel
				)
		}


	}
}