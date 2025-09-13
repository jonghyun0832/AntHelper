package com.example.data.repositoryImpl

import com.example.data.db.dao.ChartDao
import com.example.data.db.entity.toDomain
import com.example.data.db.entity.toEntity
import com.example.domain.model.Chart
import com.example.domain.repository.chart.ChartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ChartRepositoryImpl @Inject constructor(
    private val chartDao: ChartDao
) : ChartRepository {
    override fun getCharts(): Flow<List<Chart>> {
        return chartDao.getCharts().map { charts ->
            charts.map { it.toDomain()}
        }
    }

    override suspend fun insertChart(chart: Chart) {
        chartDao.insertChart(chart.toEntity())
    }

    override suspend fun deleteChart(id: String) {
        chartDao.deleteChart(id)
    }

    override suspend fun updateBookmark(id: String, isBookmarked: Boolean) {
        chartDao.updateBookmark(id, isBookmarked)
    }

    override suspend fun updateChartDescription(id: String, description: String) {
        chartDao.updateChartDescription(id, description)
    }
}