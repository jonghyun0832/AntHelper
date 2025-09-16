package com.example.data.repositoryImpl

import com.example.data.service.StockService
import com.example.domain.repository.stock.StockRepository
import javax.inject.Inject

class StockRepositoryImpl @Inject constructor(
    private val service: StockService
): StockRepository {
}