package com.saadqazi.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saadqazi.currencyconverter.ui.theme.CurrencyConverterTheme
import com.saadqazi.currencyconverter.viewModels.CurrencyExchangeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = viewModel<CurrencyExchangeViewModel>()
                    val data = viewModel.data.value
                    val loading = viewModel.loading.value

                    if (loading == true) {
                        Text(text = "Loading...")
                    } else {
                        Text(text = data?.result ?: "No data available")
                    }
                }
            }
        }
    }
}