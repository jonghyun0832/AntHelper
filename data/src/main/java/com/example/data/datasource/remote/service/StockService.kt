package com.example.data.datasource.remote.service

import com.example.data.model.request.TokenRevokeRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface StockService {
    @POST("/oauth2/revoke")
    suspend fun revokeAccessToken(
        @Header("api-id") apiId: String = "au10002",
        @Body request: TokenRevokeRequest,
    )
}