package com.example.data.datasource.local

import com.example.domain.model.Chart
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChartLocalDataSource @Inject constructor() {
    // TODO : Room - Model 추가
    fun getCharts(): Flow<List<Chart>> = flow {
        val charts = listOf<Chart>(
            Chart(
                id = "1",
                title = "차트 이름1",
                imageUrl = "",
                bookmark = false,
                locale = "KR"
            ),
            Chart(
                id = "2",
                title = "차트 이름2",
                imageUrl = "",
                bookmark = false,
                locale = "KR"
            ),
            Chart(
                id = "3",
                title = "차트 이름3",
                imageUrl = "",
                bookmark = false,
                locale = "KR"
            ),
            Chart(
                id = "4",
                title = "차트 이름4",
                imageUrl = "",
                bookmark = false,
                locale = "KR"
            ),
            Chart(
                id = "5",
                title = "차트 이름5",
                imageUrl = "",
                bookmark = false,
                locale = "KR"
            )
        )
        emit(charts)
    }
}