package com.applecompose.oregonbreweries.domain.repository

import android.util.Log
import com.applecompose.oregonbreweries.data.DataOrException
import com.applecompose.oregonbreweries.data.model.BreweriesItem
import com.applecompose.oregonbreweries.data.network.BreweriesApi
import javax.inject.Inject

class BreweriesRepository @Inject constructor(
	private val api: BreweriesApi
) {
	private val dataOrException =
		DataOrException<ArrayList<BreweriesItem>,
			Boolean,
			Exception>()

	suspend fun getAllBreweries(): DataOrException<ArrayList<BreweriesItem>, Boolean, java.lang.Exception> {
		try {
			dataOrException.loading = true
			dataOrException.data = api.getAllBreweries()
			if (dataOrException.data.toString().isNotEmpty())
				dataOrException.loading = false
		} catch (exception: Exception) {
			dataOrException.e = exception
			Log.d("EXCEPTION", "getAllBreweries: ${dataOrException.e!!.localizedMessage}")
		}
		return dataOrException
	}



}