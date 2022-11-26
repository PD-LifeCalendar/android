package com.example.lifecalendar.di

import com.example.lifecalendar.ui.fragment.life_calendar.LifeCalendarFragment
import com.example.lifecalendar.ui.fragment.login.LoginFragment
import com.example.lifecalendar.ui.fragment.selected_year.SelectedYearFragment
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(lifeCalendarFragment: LifeCalendarFragment)
    fun inject(selectedYearFragment: SelectedYearFragment)
}