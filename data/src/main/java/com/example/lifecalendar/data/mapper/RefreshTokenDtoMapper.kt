package com.example.lifecalendar.data.mapper

import com.example.lifecalendar.data.source.remote.model.LoginRequest
import com.example.lifecalendar.data.source.remote.model.RefreshTokenRequest
import com.example.lifecalendar.data.source.remote.model.UserRegistrationResponse
import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.domain.model.RefreshTokenDto
import com.example.lifecalendar.domain.model.UserDto

object RefreshTokenDtoMapper {
    fun mapRefreshTokenDtoToRequest(refreshTokenDto: RefreshTokenDto): RefreshTokenRequest =
        RefreshTokenRequest(refresh_token = refreshTokenDto.refresh_token)
}