package com.applecompose.oregonbreweries.data.network

import com.applecompose.oregonbreweries.data.model.Breweries
import com.applecompose.oregonbreweries.presentations.utile.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface BreweriesApi {

	@GET(value = Constants.END_POINT)
	suspend fun getBreweries(
		@Query( "by_state") query: String = "oregon"
	): Breweries


}