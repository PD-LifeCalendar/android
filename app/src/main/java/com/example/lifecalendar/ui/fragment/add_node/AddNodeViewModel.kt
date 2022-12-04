package com.example.lifecalendar.ui.fragment.add_node

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifecalendar.domain.model.NodeDto
import com.example.lifecalendar.domain.usecase.AddYearNodeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AddNodeViewModel(private val addYearNodeUseCase: AddYearNodeUseCase) : ViewModel() {
    
    private val messageChannel = Channel<String>()
    val messageFlow get() = messageChannel.receiveAsFlow()
    
    private val successChannel = Channel<Boolean>()
    val successFlow get() = successChannel.receiveAsFlow()
    
    fun addYearNode(year: Int, title: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (isTitleValid(title)) {
                try {
                    addYearNodeUseCase.addYearNodeItem(
                        NodeDto(
                            nodeId = 0,
                            year = year,
                            title = title,
                            description = description
                        )
                    )
                    successChannel.send(true)
                } catch (e: Exception) {
                    successChannel.send(false)
                }
            }
            
        }
    }
    
    private suspend fun isTitleValid(title: String): Boolean {
        if (title.isEmpty()) {
            messageChannel.send("Поле цель/достижение не может быть пустым")
            return false
        }
        return true
    }
}