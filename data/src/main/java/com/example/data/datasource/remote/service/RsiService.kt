package com.example.data.datasource.remote.service

import com.example.data.model.response.RsiResponse
import retrofit2.http.GET

interface RsiService {
    @GET("/ping")
    suspend fun test(): RsiResponse
}