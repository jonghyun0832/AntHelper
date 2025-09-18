package com.example.data.repositoryImpl

import com.example.data.BuildConfig
import com.example.data.model.request.TokenRequest
import com.example.data.model.response.toDomain
import com.example.data.service.StockService
import com.example.domain.model.Token
import com.example.domain.repository.stock.StockRepository
import javax.inject.Inject

class StockRepositoryImpl @Inject constructor(
    private val service: StockService
): StockRepository {
    override suspend fun getAuthToken(): Token {
        return service.getAuthToken(
            request = TokenRequest(
                appKey = BuildConfig.MOCK_APP_KEY,
                secretKey = BuildConfig.MOCK_APP_SECRET
            )
        ).toDomain()
    }
}