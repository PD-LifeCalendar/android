package com.example.lifecalendar.ui.fragment.achievements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lifecalendar.ui.fragment.achievements.AchievementsViewModel

class AchievementsViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AchievementsViewModel::class.java))
            return AchievementsViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}