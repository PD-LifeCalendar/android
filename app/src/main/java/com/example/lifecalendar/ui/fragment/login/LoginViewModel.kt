package com.example.lifecalendar.ui.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifecalendar.domain.model.ResultWrapper
import com.example.lifecalendar.domain.usecase.LoginUseCase
import com.example.lifecalendar.domain.usecase.RefreshTokenUseCase
import com.example.lifecalendar.ui.mapper.LoginUiMapper
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val refreshTokenUseCase: RefreshTokenUseCase
) : ViewModel() {
    
    private val loginSuccessChannel = Channel<String>()
    val loginSuccessFlow get() = loginSuccessChannel.receiveAsFlow()
    
    private val loginFailedChannel = Channel<String>()
    val loginFailedFlow get() = loginFailedChannel.receiveAsFlow()
    
    fun login(name: String, password: String) {
        viewModelScope.launch {
            val loginUiModel = LoginUiMapper.mapLoginUiModel(name = name, password = password)
            val loginDtoModel = LoginUiMapper.mapLoginUiModelToDto(loginUiModel)
            when (val loginInfo = loginUseCase.login(loginDtoModel)) {
                is ResultWrapper.Error -> {
                    loginInfo.message?.let { errorCode -> loginFailedChannel.send(errorCode) }
                }
                is ResultWrapper.Success -> {
                    loginSuccessChannel.send("Успешно")
                }
                null -> loginFailedChannel.send("Неизвестная ошибка, попробуйте позже")
            }
        }
    }
    
    fun refreshToken() {
        viewModelScope.launch {
            when (val loginInfo = refreshTokenUseCase.refreshToken()) {
                is ResultWrapper.Error -> {
                    loginInfo.message?.let { errorCode -> loginFailedChannel.send(errorCode) }
                }
                is ResultWrapper.Success -> {
                    loginSuccessChannel.send("Успешно")
                }
                null -> loginFailedChannel.send("Неизвестная ошибка, попробуйте позже")
            }
        }
    }
}