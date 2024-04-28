package com.saadqazi.currencyconverter

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saadqazi.currencyconverter.helpers.Util
import com.saadqazi.currencyconverter.ui.theme.CurrencyConverterTheme
import com.saadqazi.currencyconverter.ui.theme.CurrencySelectionBottomSheet
import com.saadqazi.currencyconverter.viewModels.CurrencyExchangeViewModel


@Composable
fun ComposeNavigation(viewModel: CurrencyExchangeViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "converter"){
        composable("converter"){
            converterScreen(navController,viewModel)
        }
        composable("exchange"){
            exchangeScreen(navController,viewModel)
        }
    }

}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = viewModel<CurrencyExchangeViewModel>()
            CurrencyConverterTheme() {
                ComposeNavigation(vm)
            }
        }
    }
}

@Composable
fun converterScreen(navHostController: NavHostController, vm: CurrencyExchangeViewModel) {

    vm.fetchData(LocalContext.current)
    val loading = vm.loading.value
    val scrollState = rememberScrollState()
    val conversionAmount = remember { mutableStateOf(TextFieldValue()) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .scrollable(state = scrollState, orientation = Orientation.Vertical)
            .safeDrawingPadding()
    ) {

        if (loading) {
            Box(modifier = Modifier.fillMaxSize() ){
                Column(modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    CircularProgressIndicator(modifier = Modifier
                        .size(60.dp))
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = stringResource(id = R.string.loading_text), color = MaterialTheme.colorScheme.tertiary)
                }


            }

        } else {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = stringResource(id = R.string.app_name), fontSize = 32.sp, color = MaterialTheme.colorScheme.tertiary)
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
                        tint = MaterialTheme.colorScheme.tertiary
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
                Text("View Exchange Rates", modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clickable {
                        navHostController.navigate("exchange")
                    },
                    color = MaterialTheme.colorScheme.primary)

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = conversionAmount.value,
                    onValueChange = {
                            if (it.toString().isNotEmpty()){
                                conversionAmount.value = it
                            }
                        },
                    label = { Text(stringResource(id = R.string.lbl_amount))},
                    modifier = Modifier.fillMaxWidth(0.9f),
                    placeholder = { Text(text = stringResource(id = R.string.lbl_convert_amount))},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = stringResource(id = R.string.lbl_converted_amounts), modifier = Modifier.fillMaxWidth(0.9f),
                    fontSize = 20.sp, color = MaterialTheme.colorScheme.tertiary)

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
                            Text(text = code, fontSize = 16.sp, color = MaterialTheme.colorScheme.tertiary)
                            var convertedAmount = "NA"
                            try {
                                convertedAmount = String.format("%.2f", vm.getConvertedAmount(conversionAmount.value.text.toDouble(),code))
                            } catch (_: Exception){ }
                            Text(text = convertedAmount, fontWeight = FontWeight.SemiBold ,fontSize = 16.sp, modifier = Modifier.padding(start=30.dp),
                                color = MaterialTheme.colorScheme.tertiary)

                        }
                    }
                }

            }

        }

        if (vm.showBaseCurrencyBottomSheet.value){
            CurrencySelectionBottomSheet(isMultiSelect = false,vm)
        }

        if (vm.showTargetCurrencyBottomSheet.value){
            CurrencySelectionBottomSheet(isMultiSelect = true,vm)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun exchangeScreen(navHostController: NavHostController, vm: CurrencyExchangeViewModel) {
    Scaffold(
        topBar = { TopAppBar(
            title = {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Current Exchange Rates")
                }
            },
            navigationIcon = {
                IconButton({navHostController.navigateUp()}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "menu items"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors( containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White, navigationIconContentColor = Color.White),
        ) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Base Currency:  ${vm.getBaseCurrency().third} ${vm.getBaseCurrency().second} (${vm.getBaseCurrency().first})"
                    , fontWeight = FontWeight.SemiBold ,fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth(0.9f),
                    color = MaterialTheme.colorScheme.tertiary,)
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn() {
                    items(Util.currencyList) { (code,_, flag) ->
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
                            Text(text = code, fontSize = 16.sp, color = MaterialTheme.colorScheme.tertiary)
                            var convertedAmount = "NA"
                            try {
                                convertedAmount = String.format("%.6f", vm.getConvertedAmount(1.0,code))
                            } catch (_: Exception){ }
                            Text(text = convertedAmount, fontWeight = FontWeight.SemiBold ,fontSize = 16.sp, modifier = Modifier.padding(start=30.dp),
                                color = MaterialTheme.colorScheme.tertiary)

                        }
                    }
                }

            }
        }
    )
}

@Composable
@Preview
fun mainScreenPreview(){
    val navController = rememberNavController()
    val vm = viewModel<CurrencyExchangeViewModel>()
//    vm.fetchData(LocalContext.current)
    exchangeScreen(navController, vm)
}