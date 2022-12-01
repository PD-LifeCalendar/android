package com.example.lifecalendar.di

import com.example.lifecalendar.domain.repository.AuthorizationRepository
import com.example.lifecalendar.domain.usecase.LoginUseCase
import com.example.lifecalendar.domain.usecase.RefreshTokenUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideLoginUseCase(authorizationRepository: AuthorizationRepository): LoginUseCase {
        return LoginUseCase(authorizationRepository = authorizationRepository)
    }
    
    @Provides
    fun provideRefreshTokenUseCase(authorizationRepository: AuthorizationRepository): RefreshTokenUseCase {
        return RefreshTokenUseCase(authorizationRepository = authorizationRepository)
    }
}