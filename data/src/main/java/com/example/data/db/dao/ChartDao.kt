package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.db.entity.ChartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChartDao {
    @Query("SELECT * FROM chart")
    fun getCharts(): Flow<List<ChartEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChart(chart: ChartEntity)

    @Query("DELETE FROM chart WHERE id = :id")
    suspend fun deleteChart(id: String)

    @Query("UPDATE chart SET bookmark = :isBookmarked WHERE id = :id")
    suspend fun updateBookmark(id: String, isBookmarked: Boolean)

    @Query("UPDATE chart SET description = :description WHERE id = :id")
    suspend fun updateChartDescription(id: String, description: String)
}