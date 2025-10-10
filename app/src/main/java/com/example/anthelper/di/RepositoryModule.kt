package com.example.anthelper.di

import com.example.data.repositoryImpl.ChartRepositoryImpl
import com.example.data.repositoryImpl.HomeRepositoryImpl
import com.example.data.repositoryImpl.RsiRepositoryImpl
import com.example.data.repositoryImpl.StockRepositoryImpl
import com.example.domain.repository.chart.ChartRepository
import com.example.domain.repository.home.HomeRepository
import com.example.domain.repository.rsi.RsiRepository
import com.example.domain.repository.stock.StockRepository
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

    @Binds
    @Singleton
    fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    fun bindStockRepository(stockRepositoryImpl: StockRepositoryImpl): StockRepository

    @Binds
    @Singleton
    fun bindRsiRepository(rsiRepositoryImpl: RsiRepositoryImpl): RsiRepository
}