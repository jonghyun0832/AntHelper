package com.example.presentation.ui.chart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.model.ChartLocale
import com.example.presentation.model.ChartUiModel
import com.example.presentation.navigation.ChartEnrollNav
import com.example.presentation.theme.AntHelperTheme
import com.example.presentation.theme.Dimens
import com.example.presentation.ui.component.SearchBar
import com.example.presentation.util.NavigationUtils
import com.example.presentation.viewmodel.chart.ChartAction
import com.example.presentation.viewmodel.chart.ChartEvent
import com.example.presentation.viewmodel.chart.ChartViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ChartViewScreen(
    viewModel: ChartViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchKeyWord by remember { mutableStateOf("") }
    val charts by viewModel.charts.collectAsState()
    val scrollState = rememberLazyListState()

    var selectedChartId by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var userInput by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is ChartEvent.OpenEnrollScreen -> {
                    NavigationUtils.navigate(
                        navHostController = navHostController,
                        routeName = ChartEnrollNav.navigateWithArg(null)
                    )
                }
            }
        }
    }

    // TODO : 무한 스크롤 구현

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SearchBar(
                keyword = searchKeyWord,
                onValueChange = { searchKeyWord = it },
                searchAction = {
                    // TODO : 검색 결과 이동 or 동작 구현
                    keyboardController?.hide()
                },
                clearKeywordAction = { searchKeyWord = "" }
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(Dimens.PaddingSmall),
                state = scrollState
            ) {
                items(
                    items = charts,
                    key = { item -> item.id }
                ) { item ->
                    ChartItem(
                        chart = item,
                        showDialog = showDialog,
                        userInput = userInput,
                        onUserInputChange = { userInput = it },
                        onEditDescriptionClick = { chart ->
                            showDialog = true
                            selectedChartId = chart.id
                            userInput = chart.description
                        },
                        onBookmarkClick = { viewModel.dispatch(ChartAction.ClickBookmark(it)) },
                        onDismiss = {
                            showDialog = false
                        },
                        onConfirm = {
                            showDialog = false
                            viewModel.updateChartDescription(selectedChartId, userInput)
                        },
                        onChartClick = {} // TODO : 차트 상세화면 이동
                    )
                }
            }
        }
        FloatingActionButton(
            onClick = { viewModel.dispatch(ChartAction.ClickEnrollChart) },
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = Dimens.PaddingLarge, bottom = Dimens.PaddingLarge)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Chart"
            )
        }
    }
}

@Composable
fun ChartItem(
    chart: ChartUiModel,
    showDialog: Boolean,
    userInput: String,
    onUserInputChange: (String) -> Unit,
    onEditDescriptionClick: (ChartUiModel) -> Unit,
    onBookmarkClick: (ChartUiModel) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    onChartClick: () -> Unit
) {
    ChartCard(
        chart = chart,
        onChartClick = onChartClick,
        onEditDescriptionClick = { onEditDescriptionClick(chart) },
        onBookmarkClick = onBookmarkClick
    )

    if (showDialog) {
        ChartMemoDialog(
            userInput = userInput,
            onValueChange = onUserInputChange,
            onDismiss = onDismiss,
            onConfirm = onConfirm
        )
    }
}

@Preview
@Composable
fun PreviewChartItem() {
    AntHelperTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ChartItem(
                chart = ChartUiModel(
                    id = "1",
                    title = "Chart",
                    description = "",
                    imageUrl = "",
                    bookmark = false,
                    locale = ChartLocale.KR
                ),
                showDialog = false,
                userInput = "",
                onUserInputChange = {},
                onEditDescriptionClick = {},
                onBookmarkClick = {},
                onDismiss = {},
                onConfirm = {},
                onChartClick = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewChartItemWithBookmark() {
    AntHelperTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ChartItem(
                chart = ChartUiModel(
                    id = "2",
                    title = "Chart With Bookmark Chart With Bookmark",
                    description = "",
                    imageUrl = "",
                    bookmark = true,
                    locale = ChartLocale.KR
                ),
                showDialog = false,
                userInput = "",
                onUserInputChange = {},
                onEditDescriptionClick = {},
                onBookmarkClick = {},
                onDismiss = {},
                onConfirm = {},
                onChartClick = {}
            )
        }
    }
}