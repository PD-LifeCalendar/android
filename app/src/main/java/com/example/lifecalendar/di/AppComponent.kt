package com.example.lifecalendar.di

import com.example.lifecalendar.App
import com.example.lifecalendar.MainActivity
import com.example.lifecalendar.ui.fragment.birthdate.RegistrationBirthdateFragment
import com.example.lifecalendar.ui.fragment.greeting.GreetingFragment
import com.example.lifecalendar.ui.fragment.life_calendar.LifeCalendarFragment
import com.example.lifecalendar.ui.fragment.login.LoginFragment
import com.example.lifecalendar.ui.fragment.selected_year.SelectedYearFragment
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(application: App)
    fun inject(mainActivity: MainActivity)
    fun inject(loginFragment: LoginFragment)
    fun inject(lifeCalendarFragment: LifeCalendarFragment)
    fun inject(selectedYearFragment: SelectedYearFragment)
    fun inject(greetingFragment: GreetingFragment)
    fun inject(registrationBirthdateFragment: RegistrationBirthdateFragment)
}