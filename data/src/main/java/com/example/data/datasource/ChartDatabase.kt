package com.example.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.dao.ChartDao
import com.example.data.db.entity.ChartEntity

@Database(
    entities = [
        ChartEntity::class
    ],
    version = 1
)
abstract class ChartDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "ChartDatabase.db"
    }

    abstract fun chartDao(): ChartDao
}