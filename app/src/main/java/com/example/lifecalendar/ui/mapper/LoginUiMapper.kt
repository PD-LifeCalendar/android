package com.example.lifecalendar.ui.mapper

import com.example.lifecalendar.domain.model.LoginDto
import com.example.lifecalendar.ui.model.LoginUiModel

object LoginUiMapper {
    
    fun mapLoginUiModel(name: String, password: String): LoginUiModel =
        LoginUiModel(name = name, password = password)
    
    fun mapLoginUiModelToDto(loginUiModel: LoginUiModel): LoginDto =
        LoginDto(name = loginUiModel.name, password = loginUiModel.password)
}