package com.example.lifecalendar.di

import com.example.lifecalendar.ui.fragment.life_calendar.LifeCalendarFragment
import com.example.lifecalendar.ui.fragment.login.LoginFragment
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
}