package com.saadqazi.currencyconverter.networking

import android.content.Context
import com.google.gson.Gson
import com.saadqazi.currencyconverter.models.ConversionRates
import retrofit2.Response
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class Repository() {

    private val sharedPreferencesKey = "LocalPreferences"
    private val ratesFileName = "conversion_rates.json"
    suspend fun getExchangeRatesFromAPI(context: Context): Response<ConversionRates> {
        setLastFetchTime(context)
        return RetrofitInstance.api.getExchangeRates()
    }

    fun getConversionRatesFromFile(context: Context): ConversionRates? {
        val file = File(context.filesDir, ratesFileName)
        if (!file.exists()) {
            return null
        }
        FileReader(file).use { reader ->
            val gson = Gson()
            return gson.fromJson(reader, ConversionRates::class.java)
        }
    }

    fun enoughTimeSinceLastFetch(context: Context): Boolean {
        val sharedPref = context.getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        val lastTimestamp = sharedPref.getLong("lastTimestamp", 0)

        if (lastTimestamp == 0L) {
            return true
        }

        val currentTimeMillis = System.currentTimeMillis()
        val differenceInMillis = currentTimeMillis - lastTimestamp
        val differenceInHours = differenceInMillis / (1000 * 60 * 60)
        return differenceInHours > 24
    }

    private fun setLastFetchTime(context: Context) {
        val currentTimeMillis = System.currentTimeMillis()
        val sharedPreferences = context.getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong("lastTimestamp", currentTimeMillis)
        editor.apply()
    }

    fun saveConversionRatesToFile(context: Context, conversionRates: ConversionRates?) {
        if (conversionRates != null) {
            val gson = Gson()
            val json = gson.toJson(conversionRates)
            val file = File(context.filesDir, ratesFileName)
            FileWriter(file).use { writer ->
                writer.write(json)
            }
        }
    }
}