package com.example.presentation.viewmodel.chart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.chart.ChartRepository
import com.example.presentation.model.ChartLocale
import com.example.presentation.model.ChartUiModel
import com.example.presentation.model.toDomain
import com.example.presentation.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
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
    private val _eventFlow = MutableSharedFlow<ChartEvent>()
    val eventFlow : SharedFlow<ChartEvent> = _eventFlow

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

    fun dispatch(action: ChartAction) {
        when(action) {
            ChartAction.ClickEnrollChart -> {
                viewModelScope.launch {
                    _eventFlow.emit(ChartEvent.OpenEnrollScreen)
                }
            }
            is ChartAction.ClickBookmark -> {
                updateBookmark(action.chart)
            }
        }
    }

    private fun insertChart(chart: ChartUiModel) {
        viewModelScope.launch {
            chartRepository.insertChart(tempChart.toDomain())
        }
    }

    private fun deleteChart(id: String) {
        viewModelScope.launch {
            chartRepository.deleteChart(id)
        }
    }

    private fun updateBookmark(chart: ChartUiModel) {
        viewModelScope.launch {
            chartRepository.updateBookmark(chart.id, !chart.bookmark)
        }
    }

    fun updateChartDescription(id: String, description: String) {
        viewModelScope.launch {
            chartRepository.updateChartDescription(id, description)
        }
    }
}

sealed class ChartAction {
    data object ClickEnrollChart : ChartAction()
    data class ClickBookmark(val chart: ChartUiModel) : ChartAction()
}

sealed class ChartEvent {
    data object OpenEnrollScreen : ChartEvent()
}