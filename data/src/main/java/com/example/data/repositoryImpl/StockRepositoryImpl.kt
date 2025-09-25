package com.example.data.repositoryImpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.data.BuildConfig
import com.example.data.model.request.TokenRequest
import com.example.data.model.response.toDomain
import com.example.data.datasource.remote.service.StockService
import com.example.domain.model.Token
import com.example.domain.repository.stock.StockRepository
import javax.inject.Inject

class StockRepositoryImpl @Inject constructor(
    private val stockDataStore: DataStore<Preferences>,
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