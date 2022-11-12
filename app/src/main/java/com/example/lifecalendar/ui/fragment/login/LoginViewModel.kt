package com.example.lifecalendar.ui.fragment.login

import androidx.lifecycle.ViewModel
import com.example.lifecalendar.domain.usecase.LoginUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    
    private val loginSuccessChannel = Channel<String>()
    val loginSuccessFlow get() = loginSuccessChannel.receiveAsFlow()
    
    private val loginFailedChannel = Channel<String>()
    val loginFailedFlow get() = loginFailedChannel.receiveAsFlow()
    
    fun login(email: String, password: String) {
        // TODO()
    }
}