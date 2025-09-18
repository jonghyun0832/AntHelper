package com.example.domain.repository.stock

import com.example.domain.model.Token

interface StockRepository {
    suspend fun getAuthToken(): Token
}