package com.example.anthelper.di

import com.example.data.repositoryImpl.ChartRepositoryImpl
import com.example.domain.repository.chart.ChartRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindChartRepository(chartRepositoryImpl: ChartRepositoryImpl): ChartRepository
}