package com.example.domain.repository.chart

import com.example.domain.model.Chart
import kotlinx.coroutines.flow.Flow

interface ChartRepository {
    suspend fun getCharts(): Flow<List<Chart>>
}