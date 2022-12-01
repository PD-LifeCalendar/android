package com.example.lifecalendar.ui.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lifecalendar.domain.usecase.LoginUseCase
import com.example.lifecalendar.domain.usecase.RefreshTokenUseCase

class LoginViewModelFactory(
    val loginUseCase: LoginUseCase,
    val refreshTokenUseCase: RefreshTokenUseCase
) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java))
            return LoginViewModel(loginUseCase, refreshTokenUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}