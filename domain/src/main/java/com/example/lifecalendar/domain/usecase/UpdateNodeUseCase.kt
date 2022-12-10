package com.example.lifecalendar.domain.usecase

import com.example.lifecalendar.domain.model.NodeDto
import com.example.lifecalendar.domain.repository.NodeRepository

class UpdateNodeUseCase(private val nodeRepository: NodeRepository) {
    fun updateNode(nodeDto: NodeDto) {
        nodeRepository.updateNode(nodeDto)
    }
}