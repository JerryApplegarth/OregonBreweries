package com.applecompose.oregonbreweries.presentations.navigation

sealed class Screen(val route: String) {

	object SplashScreen: Screen("splash_screen")
	object MainScreen: Screen("main_screen")


}
