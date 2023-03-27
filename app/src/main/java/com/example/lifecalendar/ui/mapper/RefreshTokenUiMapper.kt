package com.example.lifecalendar.ui.mapper

import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.domain.model.RefreshTokenDto
import com.example.lifecalendar.ui.model.LoginUiModel
import com.example.lifecalendar.ui.model.RefreshTokenUiModel

object RefreshTokenUiMapper {

    fun mapRefreshTokenUiModel(refreshToken: String): RefreshTokenUiModel =
        RefreshTokenUiModel(refreshToken = refreshToken)

    fun mapRefreshTokenLoginUiModelToDto(refreshTokenUiModel: RefreshTokenUiModel): RefreshTokenDto =
        RefreshTokenDto(refresh_token = refreshTokenUiModel.refreshToken)
}