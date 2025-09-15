package com.example.presentation.model

import com.example.domain.model.Chart

data class ChartModel(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val bookmark: Boolean,
    val locale: ChartLocale
)

fun Chart.toUiModel(): ChartModel {
    return ChartModel(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        bookmark = bookmark,
        locale = locale.toChartLocale()
    )
}

fun ChartModel.toDomain(): Chart {
    return Chart(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        bookmark = bookmark,
        locale = locale.toDomain()
    )
}