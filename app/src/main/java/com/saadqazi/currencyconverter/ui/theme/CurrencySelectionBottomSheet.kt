package com.saadqazi.currencyconverter.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saadqazi.currencyconverter.helpers.Util
import com.saadqazi.currencyconverter.viewModels.CurrencyExchangeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencySelectionBottomSheet(isMultiSelect: Boolean, vm: CurrencyExchangeViewModel?) {
    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val showDialog = remember { mutableStateOf(false) }
    val selectedCurrencies = remember { mutableStateListOf<Int>() }

    ModalBottomSheet(
        onDismissRequest = {
            if (isMultiSelect){
                vm?.showTargetCurrencyBottomSheet?.value = false
            } else {
                vm?.showBaseCurrencyBottomSheet?.value = false
            }
       },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {



        Column(modifier = Modifier
            .safeDrawingPadding()
            .background(color = MaterialTheme.colorScheme.background)) {

            LazyColumn(modifier = Modifier.weight(1f)) {
                itemsIndexed(Util.currencyList) { index, (_,country, flag) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 20.dp)
                            .clickable {
                                if (isMultiSelect) {
                                    if (selectedCurrencies.contains(index)) {
                                        selectedCurrencies.remove(index)
                                    } else {
                                        selectedCurrencies.add(index)
                                    }
                                } else {
                                    vm?.setBaseCurrencies(index)
                                }
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = flag,
                            modifier = Modifier.padding(end = 20.dp),
                            fontSize = 20.sp
                        )
                        Text(text = country, fontSize = 16.sp)

                        if (selectedCurrencies.contains(index)) {
                            Icon(
                                Icons.Rounded.CheckCircle,
                                contentDescription = "",
                                modifier = Modifier.padding(start = 20.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            if (isMultiSelect){
                Box(modifier = Modifier.fillMaxWidth()){
                    Button(modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(40.dp)
                        .align(Alignment.Center),
                        onClick = {
                            if (selectedCurrencies.isEmpty()){
                                showDialog.value = true
                            } else {
                                vm?.setTargetCurrencies(selectedCurrencies)
                            }
                        }) {
                        Text(text = "Confirm")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }

        }

        if (showDialog.value) {
            var selections = "";
            for (currency in selectedCurrencies) {
                selections += " $currency"
            }
            AlertDialog(
                onDismissRequest = {
                    showDialog.value = false
                },
                title = {
                    Text(text = "Invalid Selection")
                },
                text = {
                    Text(text = "Please select at least one target currency")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                        }
                    ) {
                        Text(text = "Dismiss")
                    }
                }
            )
        }

    }
}
@Preview
@Composable
fun SingleSelectBottomSheetPreview() {
    val vm = viewModel<CurrencyExchangeViewModel>()
    CurrencySelectionBottomSheet(false, vm)
}



