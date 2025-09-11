package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.db.entity.ChartEntity

@Dao
interface ChartDao {
    @Query("SELECT * FROM chart")
    suspend fun getCharts(): List<ChartEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChart(chart: ChartEntity)

    @Query("DELETE FROM chart WHERE id = :id")
    suspend fun deleteChart(id: String)
}