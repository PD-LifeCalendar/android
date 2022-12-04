package com.example.lifecalendar.di

import com.example.lifecalendar.domain.repository.AuthorizationRepository
import com.example.lifecalendar.domain.repository.NodeRepository
import com.example.lifecalendar.domain.usecase.*
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
    
    @Provides
    fun provideFetchYearNodesUseCase(nodeRepository: NodeRepository): FetchYearNodesUseCase {
        return FetchYearNodesUseCase(nodeRepository = nodeRepository)
    }
    
    @Provides
    fun provideAddYearNodeUseCase(nodeRepository: NodeRepository): AddYearNodeUseCase {
        return AddYearNodeUseCase(nodeRepository = nodeRepository)
    }
    
    @Provides
    fun provideDeleteNodeByIdUseCase(nodeRepository: NodeRepository): DeleteNodeByIdUseCase {
        return DeleteNodeByIdUseCase(nodeRepository = nodeRepository)
    }
}