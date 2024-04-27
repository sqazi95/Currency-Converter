package com.saadqazi.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saadqazi.currencyconverter.helpers.Util
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
    val conversionAmount = remember { mutableLongStateOf(0) }

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
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Currency Converter", fontSize = 32.sp)
                Spacer(modifier = Modifier.height(30.dp))
                
                Row(modifier = Modifier.fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    OutlinedButton(
                        onClick = {  vm.showBaseCurrencyBottomSheet.value = true },
                        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                        modifier = Modifier
                            .height(60.dp)
                            .width(130.dp)
                    ) {
                        Text(vm.getBaseCurrency().third,
                            modifier = Modifier.size(ButtonDefaults.IconSize),
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text(vm.getBaseCurrency().first, fontSize = 20.sp)
                    }

                    Icon(Icons.Filled.KeyboardArrowRight,"",
                        modifier = Modifier.size(60.dp),
                        )


                    OutlinedButton(
                        onClick = {  vm.showTargetCurrencyBottomSheet.value = true },
                        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                        modifier = Modifier
                            .height(60.dp)
                            .width(130.dp)
                    ) {

                        var targetLabel = ""
                        var targetIcon = ""
                        if (vm.getTargetCurrenciesList().isNotEmpty()){
                            if (vm.getTargetCurrenciesList().size > 1){
                                targetLabel =
                                    "${vm.getTargetCurrenciesList()[0].first} +${(vm.getTargetCurrenciesList().size - 1)}"
                                targetIcon = vm.getTargetCurrenciesList()[0].third
                            } else {
                                targetLabel = vm.getTargetCurrenciesList()[0].first
                                targetIcon = vm.getTargetCurrenciesList()[0].third
                            }
                        } else {
                            val randomCurrency = vm.getRandomCurrency()
                            targetLabel = randomCurrency.first
                            targetIcon = randomCurrency.third
                        }

                        Text(targetIcon,
                            modifier = Modifier.size(ButtonDefaults.IconSize),
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text(targetLabel, fontSize = 20.sp)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = conversionAmount.value.toString(),
                    onValueChange = { conversionAmount.longValue = it.toLong() },
                    label = { Text("Amount")},
                    modifier = Modifier.fillMaxWidth(0.9f),
                    placeholder = { Text(text = "Enter amount to convert")}

                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Converted Amounts", modifier = Modifier.fillMaxWidth(0.9f),
                    fontSize = 20.sp)

                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn() {
                    items(vm.getTargetCurrenciesList()) {(code,_, flag) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp, horizontal = 20.dp)
                                .clickable {},
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = flag,
                                modifier = Modifier.padding(end = 20.dp),
                                fontSize = 20.sp
                            )
                            Text(text = code, fontSize = 16.sp)

                            Text(text = "Converted Amount", fontWeight = FontWeight.SemiBold ,fontSize = 16.sp, modifier = Modifier.padding(start=30.dp))
                        }
                    }
                }

            }

        }

//        Column(modifier = Modifier
//            .align(Alignment.BottomCenter)
//            .fillMaxWidth(0.9f)) {
//            Button(modifier = Modifier
//                .height(40.dp)
//                .fillMaxWidth()
//                ,onClick = {
//                    vm.showBaseCurrencyBottomSheet.value = true
//                }) {
//                Text(text = "Select Base Currency")
//            }
//            Spacer(modifier = Modifier.height(10.dp))
//            Button(modifier = Modifier
//                .height(40.dp)
//                .fillMaxWidth()
//                ,onClick = {
//                    vm.showTargetCurrencyBottomSheet.value = true
//                }) {
//                Text(text = "Select Target Currencies")
//            }
//            Spacer(modifier = Modifier.height(10.dp))
//        }



        if (vm.showBaseCurrencyBottomSheet.value){
            CurrencySelectionBottomSheet(isMultiSelect = false,vm)
        }

        if (vm.showTargetCurrencyBottomSheet.value){
            CurrencySelectionBottomSheet(isMultiSelect = true,vm)
        }
    }
}

@Composable
@Preview
fun mainScreenPreview(){
    mainScreen()
}