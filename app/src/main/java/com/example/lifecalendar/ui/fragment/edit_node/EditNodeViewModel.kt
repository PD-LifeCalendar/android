package com.example.lifecalendar.ui.fragment.edit_node

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifecalendar.domain.model.NodeDto
import com.example.lifecalendar.domain.repository.NodeRepository
import com.example.lifecalendar.domain.usecase.UpdateNodeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class EditNodeViewModel(private val updateNodeUseCase: UpdateNodeUseCase) : ViewModel() {
    
    private val messageChannel = Channel<String>()
    val messageFlow get() = messageChannel.receiveAsFlow()
    
    private val successChannel = Channel<Boolean>()
    val successFlow get() = successChannel.receiveAsFlow()
    
    fun updateNode(nodeId: Int, year: Int, title:String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (isTitleValid(title)) {
                try {
                    updateNodeUseCase.updateNode(
                        NodeDto(
                            nodeId = nodeId,
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