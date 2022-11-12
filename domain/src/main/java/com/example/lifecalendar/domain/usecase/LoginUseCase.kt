package com.example.lifecalendar.domain.usecase

import com.example.lifecalendar.domain.model.DtoWrapper
import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.domain.model.UserDto
import com.example.lifecalendar.domain.repository.AuthorizationRepository

class LoginUseCase(private val authorizationRepository: AuthorizationRepository) {
    suspend fun login(loginDto: LoginDto): DtoWrapper<UserDto>? {
        return authorizationRepository.login(loginDto)
    }
}