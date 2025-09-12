package com.example.presentation.ui.chart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.model.ChartUiModel
import com.example.presentation.theme.Dimens
import com.example.presentation.viewmodel.chart.ChartEnrollViewModel

@Composable
fun ChartEnrollScreen(
    chart: ChartUiModel? = null,
    navHostController: NavHostController,
    viewModel: ChartEnrollViewModel = hiltViewModel()
) {
    var titleInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = titleInput,
            onValueChange = { titleInput = it },
            label = { Text("종목명을 입력해주세요") },
            shape = MaterialTheme.shapes.large,
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(Dimens.PaddingLarge))
    }
}