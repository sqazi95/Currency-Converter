package com.saadqazi.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saadqazi.currencyconverter.ui.theme.CurrencyConverterTheme
import com.saadqazi.currencyconverter.ui.theme.CurrencySelectionBottomSheet
import com.saadqazi.currencyconverter.viewModels.CurrencyExchangeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme() {
                mainScreen()
            }
        }
    }
}

@Composable
fun mainScreen() {
    val vm = viewModel<CurrencyExchangeViewModel>()
    val data = vm.data.value
    val loading = vm.loading.value
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .scrollable(state = scrollState, orientation = Orientation.Vertical)
            .safeDrawingPadding()
    ) {

        if (loading) {
            Text(text = "Loading...")
        } else {
            Text(text = data?.conversion_rates.toString() ?: "No data available")
        }

        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth(0.9f)) {
            Button(modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                ,onClick = {
                    vm.showBaseCurrencyBottomSheet.value = true
                }) {
                Text(text = "This is a button")
            }
            Spacer(modifier = Modifier.height(10.dp))
        }



        if (vm.showBaseCurrencyBottomSheet.value){
            CurrencySelectionBottomSheet(isMultiSelect = true,vm)
        }
    }
}

@Composable
@Preview
fun mainScreenPreview(){
    mainScreen()
}