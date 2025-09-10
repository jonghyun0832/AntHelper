package com.example.presentation.ui.chartview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.model.ChartUiModel
import com.example.presentation.theme.AntHelperTheme
import com.example.presentation.theme.Dimens
import com.example.presentation.viewmodel.chartview.ChartViewModel

@Composable
fun ChartViewScreen(
    viewModel: ChartViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchKeyWord by remember { mutableStateOf("") }
    val charts by viewModel.charts.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.updateCharts()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBarScreen(
            keyword = searchKeyWord,
            onValueChange = { searchKeyWord = it },
            searchAction = {
                // TODO : 검색 결과 이동 or 동작 구현
                keyboardController?.hide()
            },
            clearKeywordAction = { searchKeyWord = "" }
        )
        ChartListScreen(charts)
    }
}

@Composable
fun SearchBarScreen(
    keyword: String,
    onValueChange: (String) -> Unit,
    searchAction: () -> Unit,
    clearKeywordAction: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = keyword,
            onValueChange = onValueChange,
            placeholder = { Text("차트를 검색하세요!") },
            shape = RoundedCornerShape(percent = 50),
            leadingIcon =  {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = {
                if (keyword.isNotEmpty()) {
                    IconButton(
                        onClick = { clearKeywordAction() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Cancel,
                            contentDescription = "Clear Search Keyword"
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onSearch = { searchAction() }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            maxLines = 1,
            singleLine = true
        )
    }
}

@Composable
fun ChartListScreen(charts: List<ChartUiModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(Dimens.PaddingExtraSmall)
    ) {
        items(
            items = charts,
            key = { item -> item.id }
        ) { item ->
            // TODO : Chart Item Screen
            Text(text = item.title)
        }
    }
}


@Preview
@Composable
fun PreviewSearchBarScreen() {
    AntHelperTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SearchBarScreen(
                "test",
                {},
                {},
                {}
            )
        }
    }
}