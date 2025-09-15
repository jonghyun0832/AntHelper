package com.example.presentation.ui.chart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.model.ChartModel
import com.example.presentation.theme.Dimens
import com.example.presentation.ui.component.textfield.OutlinedSingleTextField
import com.example.presentation.viewmodel.chart.ChartEnrollViewModel

@Composable
fun ChartEnrollScreen(
    chart: ChartModel? = null,
    navHostController: NavHostController,
    viewModel: ChartEnrollViewModel = hiltViewModel()
) {
    var titleInput by remember { mutableStateOf(chart?.title.orEmpty()) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedSingleTextField(
            input = titleInput,
            onValueChange = { titleInput = it },
            labelString = "종목명을 입력해주세요",
            maxLength = 20
        )
        Spacer(modifier = Modifier.height(Dimens.PaddingLarge))
    }
}