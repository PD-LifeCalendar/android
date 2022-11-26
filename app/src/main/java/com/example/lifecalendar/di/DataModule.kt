package com.example.lifecalendar.di

import android.content.Context
import com.example.lifecalendar.data.repository.AuthorizationRepositoryImpl
import com.example.lifecalendar.data.source.RemoteDataSource
import com.example.lifecalendar.data.source.local.SessionManager
import com.example.lifecalendar.data.source.remote.LifeCalendarService
import com.example.lifecalendar.domain.repository.AuthorizationRepository
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class DataModule {
    
    @Provides
    fun provideRemoteDataSource(api: LifeCalendarService): RemoteDataSource {
        return RemoteDataSource(api = api)
    }
    
    @Provides
    fun provideSessionManager(context: Context): SessionManager {
        return SessionManager(context)
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
}