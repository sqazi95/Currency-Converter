package com.saadqazi.currencyconverter.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.saadqazi.currencyconverter.helpers.Util
import com.saadqazi.currencyconverter.viewModels.CurrencyExchangeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencySelectionBottomSheet(isMultiSelect: Boolean, vm: CurrencyExchangeViewModel?) {
    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

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
        BottomSheetContent(isMultiSelect = isMultiSelect)
    }
}


@Composable
fun BottomSheetContent(isMultiSelect: Boolean){
//    var text by rememberSaveable { mutableStateOf("") }
//    var active by rememberSaveable { mutableStateOf(false) }
    val selectedCurrencies = remember { mutableStateListOf<Int>() }
    val showDialog = remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .safeDrawingPadding()
        .background(color = MaterialTheme.colorScheme.background)) {
//        SearchBar(
//            modifier = Modifier
//                .fillMaxWidth(0.95f)
//                .height(40.dp),
//            query = text,
//            onQueryChange = { text = it },
//            onSearch = { active = false },
//            active = true,
//            onActiveChange = {
//                active = it
//            },
//            placeholder = { Text("Search Currency") },
//            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
//        ){}

            LazyColumn(modifier = Modifier.weight(1f)) {
                itemsIndexed(Util.currencyList) { index, (_,country, flag) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 20.dp)
                            .clickable {
                                if (selectedCurrencies.contains(index)){
                                    selectedCurrencies.remove(index)
                                } else {
                                    selectedCurrencies.add(index)
                                }
                            }
                    ) {
                        Text(
                            text = flag,
                            modifier = Modifier.padding(end = 20.dp)
                        )
                        Text(text = country)

                        if (selectedCurrencies.contains(index)) {
                            Icon(
                                Icons.Rounded.CheckCircle,
                                contentDescription = "",
                                modifier = Modifier.padding(start = 20.dp)
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
                    onClick = { showDialog.value = true }) {
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
                Text(text = "Country Clicked")
            },
            text = {
                Text(text = "You selected on ${selections}")
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Dismiss the dialog when the button is clicked
                        showDialog.value = false
                    }
                ) {
                    Text(text = "OK")
                }
            }
        )
    }
}

@Preview
@Composable
fun SingleSelectBottomSheetPreview() {
//    val vm = viewModel<CurrencyExchangeViewModel>()
//    CurrencySelectionBottomSheet(false, vm)
    BottomSheetContent(isMultiSelect = true)
}



