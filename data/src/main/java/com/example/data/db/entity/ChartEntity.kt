package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Chart

@Entity(tableName = "chart")
class ChartEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val bookmark: Boolean,
    val locale: String
)

fun ChartEntity.toDomain(): Chart {
    return Chart(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        bookmark = bookmark,
        locale = locale
    )
}

fun Chart.toEntity(): ChartEntity {
    return ChartEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        bookmark = bookmark,
        locale = locale
    )
}