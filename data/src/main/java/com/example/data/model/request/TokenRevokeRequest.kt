package com.example.data.model.request

import com.google.gson.annotations.SerializedName

data class TokenRevokeRequest(
    @SerializedName("appkey")
    val appKey: String,
    @SerializedName("secretkey")
    val secretKey: String,
    @SerializedName("token")
    val token: String
)