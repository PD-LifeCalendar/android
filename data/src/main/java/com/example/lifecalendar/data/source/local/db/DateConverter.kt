package com.example.lifecalendar.data.source.local.db

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneId

class DateConverter {
    @TypeConverter
    fun localDateTimeToTimestamp(date: LocalDateTime): Long =
        date.toEpochSecond(OffsetDateTime.now().offset)
    
    @TypeConverter
    fun timestampToLocalDateTime(timestamp: Long): LocalDateTime =
        Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime()
}