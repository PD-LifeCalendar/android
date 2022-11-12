package com.example.lifecalendar.domain.repository

import com.example.lifecalendar.domain.model.DtoWrapper
import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.domain.model.UserDto

interface AuthorizationRepository {
    suspend fun login(loginDto: LoginDto): DtoWrapper<UserDto>?
}