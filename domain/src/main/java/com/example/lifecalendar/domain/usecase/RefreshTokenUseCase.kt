package com.example.lifecalendar.domain.usecase

import com.example.lifecalendar.domain.model.ResultWrapper
import com.example.lifecalendar.domain.model.UserDto
import com.example.lifecalendar.domain.repository.AuthorizationRepository

class RefreshTokenUseCase(private val authorizationRepository: AuthorizationRepository) {
     suspend fun refreshToken(): ResultWrapper<UserDto>? {
         return authorizationRepository.refreshToken()
     }
}