package com.example.lifecalendar.domain.usecase

import com.example.lifecalendar.domain.model.NodeDto
import com.example.lifecalendar.domain.repository.NodeRepository

class AddYearNodeUseCase(private val nodeRepository: NodeRepository) {
    fun addYearNodeItem(nodeDto: NodeDto) {
        nodeRepository.addYearNodeItem(nodeDto)
    }
}