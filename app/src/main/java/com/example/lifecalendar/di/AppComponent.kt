package com.example.lifecalendar.di

import com.example.lifecalendar.App
import com.example.lifecalendar.MainActivity
import com.example.lifecalendar.ui.fragment.achievements.AchievementsFragment
import com.example.lifecalendar.ui.fragment.add_node.AddNodeFragment
import com.example.lifecalendar.ui.fragment.birthdate.RegistrationBirthdateFragment
import com.example.lifecalendar.ui.fragment.edit_node.EditNodeFragment
import com.example.lifecalendar.ui.fragment.goals.GoalsFragment
import com.example.lifecalendar.ui.fragment.greeting.GreetingFragment
import com.example.lifecalendar.ui.fragment.life_calendar.LifeCalendarFragment
import com.example.lifecalendar.ui.fragment.login.LoginFragment
import com.example.lifecalendar.ui.fragment.profile.ProfileFragment
import com.example.lifecalendar.ui.fragment.selected_year.SelectedYearFragment
import com.example.lifecalendar.ui.fragment.settings.SettingsFragment
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(application: App)
    fun inject(mainActivity: MainActivity)
    fun inject(loginFragment: LoginFragment)
    fun inject(lifeCalendarFragment: LifeCalendarFragment)
    fun inject(selectedYearFragment: SelectedYearFragment)
    fun inject(goalsFragment: GoalsFragment)
    fun inject(achievementsFragment: AchievementsFragment)
    fun inject(greetingFragment: GreetingFragment)
    fun inject(registrationBirthdateFragment: RegistrationBirthdateFragment)
    fun inject(addNodeFragment: AddNodeFragment)
    fun inject(editNodeFragment: EditNodeFragment)
    fun inject(settingsFragment: SettingsFragment)
    fun inject(profileFragment: ProfileFragment)
}