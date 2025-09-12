package com.example.presentation.viewmodel.chartview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.chart.ChartRepository
import com.example.presentation.model.ChartLocale
import com.example.presentation.model.ChartUiModel
import com.example.presentation.model.toDomain
import com.example.presentation.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChartViewModel @Inject constructor(
    private val chartRepository: ChartRepository
) : ViewModel()  {
    val charts: StateFlow<List<ChartUiModel>> = chartRepository.getCharts().map { charts ->
        charts.map { it.toUiModel() }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(3000),
        initialValue = emptyList()
    )

    val tempChart = ChartUiModel(
        id = "2",
        title = "차트 이름2",
        description = "차트 관련 기록사항2",
        imageUrl = "",
        bookmark = false,
        locale = ChartLocale.KR
    )

    fun insertChart(chart: ChartUiModel = tempChart) {
        viewModelScope.launch {
            chartRepository.insertChart(tempChart.toDomain())
        }
    }

    fun deleteChart(id: String) {
        viewModelScope.launch {
            chartRepository.deleteChart(id)
        }
    }
}