package com.example.data.service

import retrofit2.http.GET

interface StockService {
    @GET("/api/stocks")
    suspend fun getStocks(): List<String>
}