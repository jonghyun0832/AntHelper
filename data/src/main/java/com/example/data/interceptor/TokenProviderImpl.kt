package com.example.data.interceptor

import com.example.data.datasource.local.datasource.StockLocalDataSource
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenProviderImpl @Inject constructor(
    private val stockLocalDataSource: StockLocalDataSource,
) : TokenProvider {
    override fun getTokenBlocking(): String? {
        return runBlocking {
            stockLocalDataSource.getToken()
        }
    }
}