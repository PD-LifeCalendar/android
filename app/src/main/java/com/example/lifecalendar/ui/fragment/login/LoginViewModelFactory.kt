package com.example.lifecalendar.ui.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lifecalendar.domain.usecase.LoginUseCase

class LoginViewModelFactory(val loginUseCase: LoginUseCase) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java))
            return LoginViewModel(loginUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}