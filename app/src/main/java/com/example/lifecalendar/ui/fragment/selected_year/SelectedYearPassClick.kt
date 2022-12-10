package com.example.lifecalendar.ui.fragment.selected_year

import com.example.lifecalendar.ui.model.YearNode

interface SelectedYearPassClick {
    fun deleteNodeById(nodeId: Int)
    fun updateNode(yearNode: YearNode)
}