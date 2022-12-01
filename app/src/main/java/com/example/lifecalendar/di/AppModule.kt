package com.example.lifecalendar.di

import android.content.Context
import com.example.lifecalendar.domain.usecase.LoginUseCase
import com.example.lifecalendar.domain.usecase.RefreshTokenUseCase
import com.example.lifecalendar.ui.fragment.life_calendar.LifeCalendarViewModelFactory
import com.example.lifecalendar.ui.fragment.login.LoginViewModelFactory
import com.example.lifecalendar.ui.fragment.selected_year.SelectedYearViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    
    @Provides
    fun provideContext(): Context {
        return context
    }
    
    @Provides
    fun provideLoginViewModelFactory(
        loginUseCase: LoginUseCase,
        refreshTokenUseCase: RefreshTokenUseCase
    ): LoginViewModelFactory {
        return LoginViewModelFactory(
            loginUseCase = loginUseCase,
            refreshTokenUseCase = refreshTokenUseCase
        )
    }
    
    @Provides
    fun provideLifeCalendarViewModelFactory(): LifeCalendarViewModelFactory {
        return LifeCalendarViewModelFactory()
    }
    @Provides
    fun provideSelectedYearModuleFactory(): SelectedYearViewModelFactory {
        return SelectedYearViewModelFactory()
    }
    
}