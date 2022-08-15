package com.applecompose.oregonbreweries.data.network

import com.applecompose.oregonbreweries.data.model.Breweries
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface BreweriesApi {

	@GET("breweries?by_state=oregon&per_page=50")
	suspend fun getAllBreweries(): Breweries
}