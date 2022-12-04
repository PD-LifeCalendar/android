package com.example.lifecalendar.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lifecalendar.data.source.local.db.dao.BirthdateDao
import com.example.lifecalendar.data.source.local.db.model.BirthdateEntity

@Database(
    entities = [BirthdateEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class LifeCalendarDatabase : RoomDatabase() {
    
    abstract val birthdateDao: BirthdateDao
    
    companion object {
        @Volatile
        private var INSTANCE: LifeCalendarDatabase? = null
        private const val DATABASE_NAME = "life_calendar_database"
        
        fun getDatabase(context: Context): LifeCalendarDatabase {
            var tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LifeCalendarDatabase::class.java,
                    DATABASE_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}