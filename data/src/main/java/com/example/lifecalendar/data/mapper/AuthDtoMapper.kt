package com.example.lifecalendar.data.mapper

import com.example.lifecalendar.data.source.remote.model.LoginRequest
import com.example.lifecalendar.data.source.remote.model.UserRegistrationResponse
import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.domain.model.UserDto

object AuthDtoMapper {
    fun mapLoginDtoToRequest(loginDto: LoginDto): LoginRequest =
        LoginRequest(email = loginDto.email, password = loginDto.password)
    
    fun mapLoginResponseToUserDto(userRegistrationResponse: UserRegistrationResponse): UserDto =
        UserDto(
            email = userRegistrationResponse.email,
            name = userRegistrationResponse.name,
            birthdate = userRegistrationResponse.birthdate,
            description = userRegistrationResponse.description ?: "",
            sex = userRegistrationResponse.sex,
            role = userRegistrationResponse.role,
        )
}