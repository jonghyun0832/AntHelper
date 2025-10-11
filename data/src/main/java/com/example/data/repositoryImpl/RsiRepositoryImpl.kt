package com.example.data.repositoryImpl

import com.example.data.datasource.remote.service.RsiService
import com.example.data.di.NoAuthService
import com.example.data.model.response.toDomain
import com.example.domain.model.Rsi
import com.example.domain.repository.rsi.RsiRepository
import javax.inject.Inject

class RsiRepositoryImpl @Inject constructor(
    @param:NoAuthService private val rsiService: RsiService
) : RsiRepository {
    override suspend fun getRsi(): Rsi {
        return rsiService.getRsi().toDomain()
    }
}