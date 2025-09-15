package com.example.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.viewmodel.home.HomeViewModel

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
) {

    Column() {  }
}