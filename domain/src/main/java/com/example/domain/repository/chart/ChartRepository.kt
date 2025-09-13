package com.example.domain.repository.chart

import com.example.domain.model.Chart
import kotlinx.coroutines.flow.Flow

interface ChartRepository {
    fun getCharts(): Flow<List<Chart>>

    suspend fun insertChart(chart: Chart)

    suspend fun deleteChart(id: String)

    suspend fun updateBookmark(id: String, isBookmarked: Boolean)
}