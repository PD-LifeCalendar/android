package com.example.lifecalendar.ui.fragment.edit_node

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lifecalendar.domain.usecase.UpdateNodeUseCase

class EditNodeViewModelFactory(private val updateNodeUseCase: UpdateNodeUseCase) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditNodeViewModel::class.java))
            return EditNodeViewModel(updateNodeUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}