package com.saadqazi.currencyconverter.networking

import com.saadqazi.currencyconverter.models.ConversionRates
import retrofit2.Response

class Repository {

    suspend fun getExchangeRates(): Response<ConversionRates> {
        return RetrofitInstance.api.getExchangeRates()
    }
}