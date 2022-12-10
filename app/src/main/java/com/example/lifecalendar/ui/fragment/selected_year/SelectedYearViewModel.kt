package com.example.lifecalendar.ui.fragment.selected_year

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifecalendar.domain.usecase.DeleteNodeByIdUseCase
import com.example.lifecalendar.domain.usecase.FetchYearNodesUseCase
import com.example.lifecalendar.ui.mapper.SelectedYearUiMapper
import com.example.lifecalendar.ui.model.SelectedYearUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SelectedYearViewModel(
    private val fetchYearNodesUseCase: FetchYearNodesUseCase,
    private val deleteNodeByIdUseCase: DeleteNodeByIdUseCase
) : ViewModel() {
    
    private val _selectedYearUiModelLiveData: MutableLiveData<SelectedYearUiModel> =
        MutableLiveData()
    val selectedYearUiModelLiveData: LiveData<SelectedYearUiModel> get() = _selectedYearUiModelLiveData
    
    fun fetchNodes(selectedYear: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val nodeListDto = fetchYearNodesUseCase.fetchYearNodes(selectedYear)
            val selectedYearUiModel = SelectedYearUiMapper.mapUiModel(nodeListDto, selectedYear)
            _selectedYearUiModelLiveData.postValue(selectedYearUiModel)
        }
    }
    
    fun deleteNodeById(nodeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNodeByIdUseCase.deleteNodeById(nodeId)
            selectedYearUiModelLiveData.value?.let { selectedYearUiModel ->
                fetchNodes(selectedYearUiModel.selectedYear.toInt())
            }
        }
    }
}