package com.example.lifecalendar.data.source.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class BirthdateEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val birthdate: LocalDateTime,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)