package com.example.domain.model

data class Chart(
    val id: String,
    val title: String,
    val imageUrl: String,
    val bookmark: Boolean,
    val locale: String
)