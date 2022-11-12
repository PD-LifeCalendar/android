package com.example.lifecalendar.ui.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifecalendar.domain.model.DtoWrapper
import com.example.lifecalendar.domain.usecase.LoginUseCase
import com.example.lifecalendar.ui.mapper.LoginUiMapper
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    
    private val loginSuccessChannel = Channel<String>()
    val loginSuccessFlow get() = loginSuccessChannel.receiveAsFlow()
    
    private val loginFailedChannel = Channel<String>()
    val loginFailedFlow get() = loginFailedChannel.receiveAsFlow()
    
    fun login(email: String, password: String) {
    
        viewModelScope.launch {
            val loginUiModel = LoginUiMapper.mapLoginUiModel(email = email, password = password)
            val loginDtoModel = LoginUiMapper.mapLoginUiModelToDto(loginUiModel)
            when (val loginInfo = loginUseCase.login(loginDtoModel)) {
                is DtoWrapper.Error -> {
                    loginInfo.errorCode?.let { errorCode -> loginFailedChannel.send(errorCode) }
                }
                is DtoWrapper.Success -> {
                    loginSuccessChannel.send("Успешно")
                }
                null -> loginFailedChannel.send("Неизвестная ошибка, попробуйте позже")
            }
        }
    }
}