package com.example.data.model.response

import com.google.gson.annotations.SerializedName

data class DefaultResponse(
    @SerializedName("return_code")
    val returnCode: Int,
    @SerializedName("return_msg")
    val returnMessage: String
)