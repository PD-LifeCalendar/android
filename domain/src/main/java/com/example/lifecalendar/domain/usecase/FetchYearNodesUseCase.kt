package com.example.lifecalendar.domain.usecase

import com.example.lifecalendar.domain.model.NodeDto
import com.example.lifecalendar.domain.repository.NodeRepository

class FetchYearNodesUseCase(private val nodeRepository: NodeRepository) {
    fun fetchYearNodes(selectedYear: Int): List<NodeDto> =
        nodeRepository.fetchYearNodes(selectedYear)
}