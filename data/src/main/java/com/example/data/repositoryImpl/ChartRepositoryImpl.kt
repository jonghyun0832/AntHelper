package com.example.data.repositoryImpl

import com.example.data.datasource.local.ChartLocalDataSource
import com.example.data.db.dao.ChartDao
import com.example.domain.model.Chart
import com.example.domain.repository.chart.ChartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChartRepositoryImpl @Inject constructor(
    private val chartLocalDataSource: ChartLocalDataSource,
    private val chartDao: ChartDao
) : ChartRepository {
    // TODO : Chart Dao 적용
    override suspend fun getCharts(): Flow<List<Chart>> {
        return chartLocalDataSource.getCharts()
    }
}