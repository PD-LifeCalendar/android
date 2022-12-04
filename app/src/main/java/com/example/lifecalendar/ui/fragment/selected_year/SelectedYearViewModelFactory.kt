package com.example.lifecalendar.ui.fragment.selected_year

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lifecalendar.domain.usecase.DeleteNodeByIdUseCase
import com.example.lifecalendar.domain.usecase.FetchYearNodesUseCase

class SelectedYearViewModelFactory(
    private val fetchYearNodesUseCase: FetchYearNodesUseCase,
    private val deleteNodeByIdUseCase: DeleteNodeByIdUseCase
) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SelectedYearViewModel::class.java))
            return SelectedYearViewModel(fetchYearNodesUseCase, deleteNodeByIdUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}