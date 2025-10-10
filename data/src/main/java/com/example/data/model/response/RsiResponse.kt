package com.example.data.model.response

import com.example.domain.model.Rsi
import com.google.gson.annotations.SerializedName

data class RsiResponse(
    @SerializedName("message")
    val message: String
)

fun RsiResponse.toDomain(): Rsi {
    return Rsi(
        message = message
    )
}