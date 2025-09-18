package com.example.domain.model

data class Token(
    val expiresDate: String,
    val tokenType: String,
    val token: String
)