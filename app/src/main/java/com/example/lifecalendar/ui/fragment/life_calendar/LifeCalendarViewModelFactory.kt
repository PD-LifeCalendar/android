package com.example.lifecalendar.ui.fragment.life_calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LifeCalendarViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LifeCalendarViewModel::class.java))
            return LifeCalendarViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}