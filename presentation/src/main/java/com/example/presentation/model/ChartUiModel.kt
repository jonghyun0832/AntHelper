package com.example.presentation.model

import com.example.domain.model.Chart

data class ChartUiModel(
    val id: String,
    val title: String,
    val imageUrl: String,
    val bookmark: Boolean,
    val locale: ChartLocale
)

fun Chart.toUiModel(): ChartUiModel {
    return ChartUiModel(
        id = id,
        title = title,
        imageUrl = imageUrl,
        bookmark = bookmark,
        locale = locale.toChartLocale()
    )
}