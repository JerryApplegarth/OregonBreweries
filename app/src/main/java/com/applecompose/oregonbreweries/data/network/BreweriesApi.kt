package com.applecompose.oregonbreweries.data.network

import com.applecompose.oregonbreweries.data.model.Breweries
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface BreweriesApi {

	@GET("breweries/?by_state=oregon")
	suspend fun getAllBreweries(): Breweries
}