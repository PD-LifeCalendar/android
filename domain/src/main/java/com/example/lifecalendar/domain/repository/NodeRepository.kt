package com.example.lifecalendar.domain.repository

import com.example.lifecalendar.domain.model.NodeDto

interface NodeRepository {
    fun fetchYearNodes(selectedYear: Int): List<NodeDto>
    fun addYearNodeItem(nodeDto: NodeDto)
    fun deleteNodeById(id: Int)
    fun updateNode(nodeDto: NodeDto)
}