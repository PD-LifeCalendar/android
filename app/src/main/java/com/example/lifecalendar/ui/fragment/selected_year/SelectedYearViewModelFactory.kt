package com.example.lifecalendar.ui.fragment.selected_year

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SelectedYearViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SelectedYearViewModel::class.java))
            return SelectedYearViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}