package com.example.lifecalendar.domain.repository

import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.domain.model.ResultWrapper
import com.example.lifecalendar.domain.model.UserDto

interface AuthorizationRepository {
    suspend fun login(loginDto: LoginDto): ResultWrapper<UserDto>?
    suspend fun refreshToken(): ResultWrapper<UserDto>?
}