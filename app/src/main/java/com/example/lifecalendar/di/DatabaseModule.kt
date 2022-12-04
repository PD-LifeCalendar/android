package com.example.lifecalendar.di

import android.content.Context
import com.example.lifecalendar.data.source.local.db.LifeCalendarDatabase
import com.example.lifecalendar.data.source.local.db.dao.NodeDao
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    
    @Provides
    fun provideNodeDao(context: Context): NodeDao {
        return LifeCalendarDatabase.getDatabase(context).nodeDao
    }
}