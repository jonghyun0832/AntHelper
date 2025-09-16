package com.example.presentation.viewmodel.chart

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChartEnrollViewModel @Inject constructor() : ViewModel() {
    private val _eventFlow = MutableSharedFlow<ChartEnrollEvent>()
    val eventFlow: SharedFlow<ChartEnrollEvent> = _eventFlow

    private val _chartTitle = MutableStateFlow("")
    val chartTitle: StateFlow<String> = _chartTitle.asStateFlow()

    private val _imageUri = MutableStateFlow<Uri?>(null)
    val imageUri: StateFlow<Uri?> = _imageUri.asStateFlow()

    fun dispatch(action: ChartEnrollAction) {
        when(action) {
            ChartEnrollAction.ClickUploadImage -> {
                viewModelScope.launch {
                    _eventFlow.emit(ChartEnrollEvent.OpenGallery)
                }
            }
            ChartEnrollAction.ClickEnrollChart -> {
                viewModelScope.launch {
                    // TODO : 차트 정보 등록
                    _eventFlow.emit(ChartEnrollEvent.CompleteEnroll)
                }
            }
        }
    }

    fun updateChartTitle(title: String) {
        _chartTitle.value = title
    }

    fun updateImageUri(uri: Uri?) {
        _imageUri.value = uri
    }
}

sealed class ChartEnrollAction {
    data object ClickUploadImage : ChartEnrollAction()
    data object ClickEnrollChart : ChartEnrollAction()
}

sealed class ChartEnrollEvent {
    data object OpenGallery : ChartEnrollEvent()
    data object CompleteEnroll : ChartEnrollEvent()
}