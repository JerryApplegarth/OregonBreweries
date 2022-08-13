package com.applecompose.oregonbreweries.presentations.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applecompose.oregonbreweries.data.DataOrException
import com.applecompose.oregonbreweries.data.model.BreweriesItem
import com.applecompose.oregonbreweries.domain.repository.BreweriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreweriesViewModel @Inject constructor(
	private val repository: BreweriesRepository
) : ViewModel() {

	val data: MutableState<DataOrException<ArrayList<BreweriesItem>,
			Boolean,
			Exception>> = mutableStateOf(
		DataOrException(null, true, Exception(""))
	)
	init {
		getAllBreweries()
	}

	private fun getAllBreweries() {
		viewModelScope.launch {
			data.value.loading = true
			data.value = repository.getAllBreweries()
			if (data.value.toString().isNotEmpty()) {
				data.value.loading = false
			}
		}
	}
}


