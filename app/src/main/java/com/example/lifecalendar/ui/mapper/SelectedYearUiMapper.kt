package com.example.lifecalendar.ui.mapper

import com.example.lifecalendar.domain.model.NodeDto
import com.example.lifecalendar.ui.model.SelectedYearUiModel
import com.example.lifecalendar.ui.model.YearNode

object SelectedYearUiMapper {
    private fun mapNodeDtoToYearNode(nodeDtoList: List<NodeDto>): List<YearNode> =
        nodeDtoList.map { YearNode(nodeId = it.nodeId, title = it.title, description = it.description) }
    
    fun mapUiModel(nodeDtoList: List<NodeDto>, selectedYear: Int): SelectedYearUiModel =
        SelectedYearUiModel(
            selectedYear = selectedYear.toString(),
            nodes = mapNodeDtoToYearNode(nodeDtoList)
        )
}