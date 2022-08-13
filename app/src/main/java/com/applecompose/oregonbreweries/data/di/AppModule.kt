package com.applecompose.oregonbreweries.data.di

import com.applecompose.oregonbreweries.domain.repository.BreweriesRepository
import com.applecompose.oregonbreweries.data.network.BreweriesApi
import com.applecompose.oregonbreweries.presentations.utile.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Singleton
	@Provides
	fun provideBreweriesRepository(api: BreweriesApi) =
		BreweriesRepository(api)

	@Singleton
	@Provides
	fun provideBreweriesApi(): BreweriesApi {
		return Retrofit.Builder()
			.baseUrl(Constants.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(BreweriesApi::class.java)
	}
}