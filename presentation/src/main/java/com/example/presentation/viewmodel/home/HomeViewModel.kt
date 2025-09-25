package com.example.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.stock.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val stockRepository: StockRepository
): ViewModel() {
    fun getStockToken() {
        viewModelScope.launch {
            val token = stockRepository.getAuthToken()
        }
    }

    fun revokeStockToken() {
        viewModelScope.launch {
            stockRepository.revokeToken()
        }
    }

}