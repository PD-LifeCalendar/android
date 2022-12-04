package com.example.lifecalendar.ui.fragment.add_node

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lifecalendar.domain.usecase.AddYearNodeUseCase
import com.example.lifecalendar.ui.fragment.selected_year.SelectedYearViewModel

class AddNodeViewModelFactory(private val addYearNodeUseCase: AddYearNodeUseCase) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddNodeViewModel::class.java))
            return AddNodeViewModel(addYearNodeUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}