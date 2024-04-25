package com.saadqazi.currencyconverter.networking

import com.saadqazi.currencyconverter.models.ConversionRates
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v6/1f8d0bd18a609630b7c0116b/latest/USD")
    suspend fun getExchangeRates() : Response<ConversionRates>
}