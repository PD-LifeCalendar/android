package com.example.lifecalendar.data.source.local.db.dao

import androidx.room.*
import com.example.lifecalendar.data.source.local.db.model.BirthdateEntity

@Dao
interface BirthdateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBirthdateItem(birthdateEntity: BirthdateEntity)
    
    @Update
    fun updateBirthdateItem(birthdateEntity: BirthdateEntity)
    
    @Query("SELECT * FROM BirthdateEntity LIMIT 1")
    fun readBirthdate(): BirthdateEntity
}