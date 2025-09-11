package com.example.presentation.ui.chartview

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.R
import com.example.presentation.model.ChartLocale
import com.example.presentation.model.ChartUiModel
import com.example.presentation.theme.AntHelperTheme
import com.example.presentation.theme.Dimens
import com.example.presentation.ui.component.SearchBar
import com.example.presentation.viewmodel.chartview.ChartViewModel

@Composable
fun ChartViewScreen(
    viewModel: ChartViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchKeyWord by remember { mutableStateOf("") }
    val charts by viewModel.charts.collectAsState()
    val scrollState = rememberLazyListState()

    LaunchedEffect(Unit) {
        viewModel.updateCharts()
    }

    // TODO : 무한 스크롤 구현

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
                ChartItem(item)
            }
        }
    }
}

@Composable
fun ChartItem(chart: ChartUiModel) {
    var showDialog by remember { mutableStateOf(false) }
    var userInput by remember { mutableStateOf(chart.description) }

    ChartCard(
        chart = chart,
        onChartClick = {}, // TODO : 차트 상세화면 이동
        onEditDescriptionClick = { showDialog = true },
        onEditBookmarkClick = {} // TODO : 북마크 수정
    )

    if (showDialog) {
        ChartMemoDialog(
            userInput = userInput,
            onValueChange = { userInput = it },
            onDismiss = {
                showDialog = false
                userInput = chart.description
            },
            onConfirm = {
                showDialog = false
                // TODO : 수정한 내용 Chart Description에 저장
            }
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
                ChartUiModel(
                    id = "1",
                    title = "Chart",
                    description = "",
                    imageUrl = "",
                    bookmark = false,
                    locale = ChartLocale.KR
                )
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
                ChartUiModel(
                    id = "2",
                    title = "Chart With Bookmark Chart With Bookmark",
                    description = "",
                    imageUrl = "",
                    bookmark = true,
                    locale = ChartLocale.KR
                )
            )
        }
    }
}