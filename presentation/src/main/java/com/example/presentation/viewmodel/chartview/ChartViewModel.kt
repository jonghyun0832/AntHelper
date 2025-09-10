package com.example.presentation.viewmodel.chartview

import androidx.lifecycle.ViewModel
import com.example.domain.repository.chart.ChartRepository
import com.example.presentation.model.ChartUiModel
import com.example.presentation.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class ChartViewModel @Inject constructor(
    private val chartRepository: ChartRepository
) : ViewModel()  {
    private val _charts = MutableStateFlow<List<ChartUiModel>>(emptyList())
    val charts : StateFlow<List<ChartUiModel>> = _charts

    suspend fun updateCharts() {
        chartRepository.getCharts().collectLatest { charts ->
            _charts.emit(charts.map { it.toUiModel() })
        }
    }
}