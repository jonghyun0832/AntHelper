package com.example.anthelper.di

import android.content.Context
import androidx.room.Room
import com.example.data.datasource.ChartDatabase
import com.example.data.db.dao.ChartDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideChartDatabase(
        @ApplicationContext context: Context
    ) : ChartDatabase {
        return Room.databaseBuilder(
            context,
            ChartDatabase::class.java,
            ChartDatabase.DB_NAME
        ).fallbackToDestructiveMigration(dropAllTables = false).build() // 서비스중에는 마이그레이션으로 변경
    }

    @Provides
    @Singleton
    fun provideChartDao(database: ChartDatabase) : ChartDao {
        return database.chartDao()
    }
}