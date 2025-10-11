package com.example.data.model.response

import com.example.domain.model.Rsi
import com.google.gson.annotations.SerializedName

data class RsiResponse(
    @SerializedName("kospi")
    val kospi: RsiIndexResponse,
    @SerializedName("kosdaq")
    val kosdaq: RsiIndexResponse
)

fun RsiResponse.toDomain(): Rsi {
    return Rsi(
        kospi = kospi.toDomain(),
        kosdaq = kosdaq.toDomain()
    )
}