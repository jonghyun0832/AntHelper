package com.example.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.viewmodel.home.HomeViewModel

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { viewModel.getStockToken() }
        ) {
            Text("토큰 가져오기(임시)")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = { viewModel.revokeStockToken() }
        ) {
            Text("토큰 제거(임시)")
        }
    }
}