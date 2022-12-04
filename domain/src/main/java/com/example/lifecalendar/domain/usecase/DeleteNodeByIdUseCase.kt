package com.example.lifecalendar.domain.usecase

import com.example.lifecalendar.domain.repository.NodeRepository

class DeleteNodeByIdUseCase(private val nodeRepository: NodeRepository) {
    fun deleteNodeById(id: Int) {
        nodeRepository.deleteNodeById(id)
    }
}