package com.example.lifecalendar.ui.mapper

import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.ui.model.LoginUiModel

object LoginUiMapper {
    
    fun mapLoginUiModel(email: String, password: String): LoginUiModel =
        LoginUiModel(email = email, password = password)
    
    fun mapLoginUiModelToDto(loginUiModel: LoginUiModel): LoginDto =
        LoginDto(email = loginUiModel.email, password = loginUiModel.password)
}