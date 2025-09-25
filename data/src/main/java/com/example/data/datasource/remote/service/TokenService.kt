package com.example.data.datasource.remote.service

import com.example.data.model.request.TokenRequest
import com.example.data.model.response.TokenResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface TokenService {
    @POST("/oauth2/token")
    suspend fun getAuthToken(
        @Header("api-id") apiId: String = "au10001",
        @Header("Content-Type") contentType: String = "application/json;charset=UTF-8",
        @Body request: TokenRequest
    ): TokenResponse
}