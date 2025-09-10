package com.example.data.repositoryImpl

import com.example.data.datasource.local.ChartLocalDataSource
import com.example.domain.model.Chart
import com.example.domain.repository.chart.ChartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChartRepositoryImpl @Inject constructor(
    private val chartLocalDataSource: ChartLocalDataSource
) : ChartRepository {
    override suspend fun getCharts(): Flow<List<Chart>> {
        return chartLocalDataSource.getCharts()
    }
}