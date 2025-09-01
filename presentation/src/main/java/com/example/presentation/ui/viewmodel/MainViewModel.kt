package com.example.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.TestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val testUseCase: TestUseCase
) : ViewModel() {
    val message = testUseCase()

    fun showMessage() {
        println(message)
    }
}