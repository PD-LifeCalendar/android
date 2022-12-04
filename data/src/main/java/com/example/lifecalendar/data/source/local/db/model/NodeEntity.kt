package com.example.lifecalendar.data.source.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class NodeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val year: Int,
    val title: String,
    val description: String,
)