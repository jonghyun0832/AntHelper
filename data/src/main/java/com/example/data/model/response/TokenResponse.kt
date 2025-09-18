package com.example.data.model.response

import android.util.Log
import com.example.domain.model.Token
import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("expires_dt")
    val expiresDate: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("token")
    val token: String
)

fun TokenResponse.toDomain(): Token {
    Log.d("tjwh", "toDomain: $this")
    return Token(
        expiresDate = expiresDate,
        tokenType = tokenType,
        token = token
    )
}