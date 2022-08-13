package com.applecompose.oregonbreweries.data.network

import com.applecompose.oregonbreweries.data.model.Breweries
import com.applecompose.oregonbreweries.data.model.BreweriesItem
import com.applecompose.oregonbreweries.presentations.contents.Constants
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface BreweriesApi {

	@GET(Constants.END_POINT)
	suspend fun getAllBreweries(): Breweries


}