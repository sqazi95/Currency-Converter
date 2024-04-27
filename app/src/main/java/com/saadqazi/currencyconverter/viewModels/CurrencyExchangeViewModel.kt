package com.saadqazi.currencyconverter.viewModels

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadqazi.currencyconverter.helpers.Util
import com.saadqazi.currencyconverter.models.ConversionRates
import com.saadqazi.currencyconverter.networking.Repository
import kotlinx.coroutines.launch


class CurrencyExchangeViewModel() : ViewModel() {
    private val repository = Repository()

    private val _data = MutableLiveData<ConversionRates?>()
    val data: LiveData<ConversionRates?> = _data
    val loading = mutableStateOf(true)
    var showTargetCurrencyBottomSheet = mutableStateOf(false)
    var showBaseCurrencyBottomSheet = mutableStateOf(false)
    private val targetCurrencies = arrayListOf<Triple<String,String,String>>()
    private var baseCurrency = Triple("PKR", "Pakistani Rupee", "\uD83C\uDDF5\uD83C\uDDF0")
    private var dataFetched = false


    init {
        targetCurrencies.add(Triple("USD", "United States Dollar", "\uD83C\uDDFA\uD83C\uDDF8"))
    }

    fun fetchData(context: Context) {
        if (!dataFetched){
            loading.value = true
            viewModelScope.launch {
                if (repository.enoughTimeSinceLastFetch(context)){
                    Log.d("FETCH","Fetch response from API")
                    val response = repository.getExchangeRatesFromAPI(context)
                    repository.saveConversionRatesToFile(context,response.body())
                    _data.value = response.body()
                } else {
                    Log.d("FETCH","Fetch response from Local file")
                    var conversionRates: ConversionRates? = repository.getConversionRatesFromFile(context)
                    if (conversionRates == null){
                        Log.d("FETCH","Fetch response from API")
                        conversionRates = repository.getExchangeRatesFromAPI(context).body()
                        repository.saveConversionRatesToFile(context,conversionRates)
                    }
                    _data.value = conversionRates
                }
                loading.value = false
            }
            dataFetched = true
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

    fun getConvertedAmount(input: Double, currencyCode: String): String {
        return String.format("%.2f", (convertUSDtoOther(convertToUSD(input),currencyCode)))
    }

    private fun convertUSDtoOther(amount: Double, targetCurrency: String): Double{
        val exchangeRate: Double? = data.value?.conversion_rates?.get(targetCurrency)
        if (exchangeRate != null){
            return exchangeRate * amount
        }
        return 0.0
    }

    private fun convertToUSD(amount: Double): Double{
        val exchangeRate: Double? = data.value?.conversion_rates?.get(baseCurrency.first)
        if (exchangeRate != null){
            return amount / exchangeRate
        }
        return 0.0
    }
}