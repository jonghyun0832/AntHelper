package com.example.presentation.viewmodel.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.rsi.RsiRepository
import com.example.domain.repository.stock.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val stockRepository: StockRepository,
    private val rsiRepository: RsiRepository
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

    fun getRsi() {
        viewModelScope.launch {
            val rsi = rsiRepository.test()
            Log.d("tjwh", "getRsi: $rsi")
        }
    }
}