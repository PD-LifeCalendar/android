package com.example.lifecalendar.ui.fragment.goals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GoalsViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GoalsViewModel::class.java))
            return GoalsViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}