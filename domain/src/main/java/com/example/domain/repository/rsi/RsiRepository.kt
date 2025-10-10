package com.example.domain.repository.rsi

import com.example.domain.model.Rsi

interface RsiRepository {
    suspend fun test(): Rsi
}