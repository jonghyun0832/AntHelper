package com.example.data.di

import com.example.data.datasource.local.datasourceImpl.StockLocalDataSourceImpl
import com.example.data.datasource.local.datasource.StockLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindStockLocalDataSource(source: StockLocalDataSourceImpl): StockLocalDataSource
}