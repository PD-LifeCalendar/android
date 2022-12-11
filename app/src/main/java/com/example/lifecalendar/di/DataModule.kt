package com.example.lifecalendar.di

import android.content.Context
import com.example.lifecalendar.data.repository.AuthorizationRepositoryImpl
import com.example.lifecalendar.data.repository.NodeRepositoryImpl
import com.example.lifecalendar.data.source.LocalDataSource
import com.example.lifecalendar.data.source.RemoteDataSource
import com.example.lifecalendar.data.source.local.db.dao.NodeDao
import com.example.lifecalendar.data.source.local.prefs.BirthdateManager
import com.example.lifecalendar.data.source.local.prefs.FirstRunAppManager
import com.example.lifecalendar.data.source.local.prefs.SessionManager
import com.example.lifecalendar.data.source.local.prefs.YearsCountManager
import com.example.lifecalendar.data.source.remote.LifeCalendarService
import com.example.lifecalendar.domain.repository.AuthorizationRepository
import com.example.lifecalendar.domain.repository.NodeRepository
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class, DatabaseModule::class])
class DataModule {
    
    @Provides
    fun provideRemoteDataSource(api: LifeCalendarService): RemoteDataSource {
        return RemoteDataSource(api = api)
    }
    
    @Provides
    fun provideLocalDataSource(nodeDao: NodeDao): LocalDataSource {
        return LocalDataSource(nodeDao = nodeDao)
    }
    
    @Provides
    fun provideSessionManager(context: Context): SessionManager {
        return SessionManager(context)
    }
    
    @Provides
    fun provideBirthdateManager(context: Context): BirthdateManager {
        return BirthdateManager(context)
    }
    
    @Provides
    fun provideYearsCountManager(context: Context): YearsCountManager {
        return YearsCountManager(context)
    }
    
    @Provides
    fun provideFirstRunAppManager(context: Context): FirstRunAppManager {
        return FirstRunAppManager(context)
    }
    
    @Provides
    fun provideAuthorizationRepository(
        remoteDataSource: RemoteDataSource,
        sessionManager: SessionManager
    ): AuthorizationRepository {
        return AuthorizationRepositoryImpl(
            remoteDataSource = remoteDataSource,
            sessionManager = sessionManager
        )
    }
    
    @Provides
    fun provideNodeRepository(localDataSource: LocalDataSource): NodeRepository {
        return NodeRepositoryImpl(localDataSource = localDataSource)
    }
}