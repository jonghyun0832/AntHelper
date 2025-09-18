package com.example.data.model.request

import com.google.gson.annotations.SerializedName

data class TokenRequest(
    @SerializedName("grant_type")
    val grantType: String = "client_credentials",
    @SerializedName("appkey")
    val appKey: String,
    @SerializedName("secretkey")
    val secretKey: String
)