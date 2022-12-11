package com.example.lifecalendar.data.mapper

import com.example.lifecalendar.data.source.local.db.model.NodeEntity
import com.example.lifecalendar.domain.model.NodeDto

object NodeDtoMapper {
    fun mapNodeEntityListToDto(nodeEntityList: List<NodeEntity>): List<NodeDto> =
        nodeEntityList.map {
            NodeDto(
                nodeId = it.id,
                year = it.year,
                title = it.title,
                description = it.description
            )
        }
    
    fun mapNodeDtoToEntity(nodeDto: NodeDto): NodeEntity =
        NodeEntity(
            id = 0,
            year = nodeDto.year,
            title = nodeDto.title,
            description = nodeDto.description
        )
    
    fun mapNodeEntityToDto(nodeEntity: NodeEntity): NodeDto =
        NodeDto(
            nodeId = nodeEntity.id,
            title = nodeEntity.title,
            description = nodeEntity.description,
            year = nodeEntity.year,
        )
    
    fun mapNodeDtoToEntityToUpdate(nodeDto: NodeDto): NodeEntity =
        NodeEntity(
            id = nodeDto.nodeId,
            year = nodeDto.year,
            title = nodeDto.title,
            description = nodeDto.description
        )
}