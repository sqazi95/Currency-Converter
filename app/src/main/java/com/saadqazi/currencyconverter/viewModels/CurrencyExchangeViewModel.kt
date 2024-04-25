package com.saadqazi.currencyconverter.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadqazi.currencyconverter.models.ConversionRates
import com.saadqazi.currencyconverter.networking.Repository
import kotlinx.coroutines.launch


class CurrencyExchangeViewModel : ViewModel() {
    private val repository = Repository()

    private val _data = MutableLiveData<ConversionRates?>()
    val data: LiveData<ConversionRates?> = _data

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    init {
        fetchData()
    }

    private fun fetchData() {
        _loading.value = true // Set loading state to true before fetching data
        viewModelScope.launch {
            val response = repository.getExchangeRates()
            _data.value = response.body()
            _loading.value = false // Set loading state to false after fetching data
        }
    }
}