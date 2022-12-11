package com.example.lifecalendar.data.repository

import com.example.lifecalendar.data.mapper.NodeDtoMapper
import com.example.lifecalendar.data.source.LocalDataSource
import com.example.lifecalendar.domain.model.NodeDto
import com.example.lifecalendar.domain.repository.NodeRepository

class NodeRepositoryImpl(private val localDataSource: LocalDataSource) : NodeRepository {
    override fun fetchYearNodes(selectedYear: Int): List<NodeDto> {
        val nodeEntityList = localDataSource.readNodesByYear(selectedYear)
        return NodeDtoMapper.mapNodeEntityListToDto(nodeEntityList)
    }
    
    override fun addYearNodeItem(nodeDto: NodeDto) {
        val nodeEntity = NodeDtoMapper.mapNodeDtoToEntity(nodeDto)
        localDataSource.addYearNodeItem(nodeEntity)
    }
    
    override fun deleteNodeById(id: Int) {
        val nodeEntity = localDataSource.fetchNodeById(id)
        localDataSource.deleteNode(nodeEntity)
    }
    
    override fun updateNode(nodeDto: NodeDto) {
        val nodeEntity = NodeDtoMapper.mapNodeDtoToEntityToUpdate(nodeDto)
        localDataSource.updateYearNodeItem(nodeEntity)
    }
}