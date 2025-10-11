package com.example.data.model.response

import com.example.domain.model.RsiIndex
import com.google.gson.annotations.SerializedName

data class RsiIndexResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("rsi")
    val rsi: Double,
)

fun RsiIndexResponse.toDomain(): RsiIndex {
    return RsiIndex(
        date = date,
        rsi = rsi
    )
}