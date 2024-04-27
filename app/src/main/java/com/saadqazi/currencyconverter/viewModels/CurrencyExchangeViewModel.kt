package com.saadqazi.currencyconverter.viewModels

import androidx.compose.runtime.mutableStateOf
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

    val loading = mutableStateOf(true)
    var showTargetCurrencyBottomSheet = mutableStateOf(false)
    var showBaseCurrencyBottomSheet = mutableStateOf(false)

    init {
        fetchData()
    }

    private fun fetchData() {
        loading.value = true
        viewModelScope.launch {
//            val response = repository.getExchangeRates()
//            _data.value = response.body()
        loading.value = false
        }
    }
}