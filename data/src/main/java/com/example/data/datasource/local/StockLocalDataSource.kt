package com.example.data.datasource.local

interface StockLocalDataSource {
    suspend fun saveToken(token: String)
    suspend fun getToken(): String?
    suspend fun clearToken()
}