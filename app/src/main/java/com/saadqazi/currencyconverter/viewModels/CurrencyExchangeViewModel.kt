package com.saadqazi.currencyconverter.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadqazi.currencyconverter.helpers.Util
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
    private val targetCurrencies = arrayListOf<Triple<String,String,String>>()
    private var baseCurrency = Triple("PKR", "Pakistani Rupee", "\uD83C\uDDF5\uD83C\uDDF0")


    init {
        fetchData()
        targetCurrencies.add(Triple("USD", "United States Dollar", "\uD83C\uDDFA\uD83C\uDDF8"))
    }

    private fun fetchData() {
        loading.value = true
        viewModelScope.launch {
//            val response = repository.getExchangeRates()
//            _data.value = response.body()
        loading.value = false
        }
    }

    fun setTargetCurrencies(newSelections: List<Int>) {
        targetCurrencies.clear()
        for (index in newSelections){
            targetCurrencies.add(Util.currencyList[index])
        }
        showTargetCurrencyBottomSheet.value = false
    }

    fun getTargetCurrenciesList(): List<Triple<String,String,String>>{
        return targetCurrencies
    }

    fun setBaseCurrencies(selectionIndex: Int) {
        baseCurrency = Util.currencyList[selectionIndex]
        showBaseCurrencyBottomSheet.value = false
    }

    fun getBaseCurrency(): Triple<String,String,String>{
        return baseCurrency
    }

    fun getRandomCurrency() : Triple<String,String,String> {
        val index = (0..<Util.currencyList.size).random()
        return Util.currencyList[index]
    }
}