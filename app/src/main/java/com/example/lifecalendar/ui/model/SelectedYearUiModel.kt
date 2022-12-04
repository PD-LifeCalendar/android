package com.example.lifecalendar.ui.model

data class SelectedYearUiModel(
    val selectedYear: String,
    val nodes: List<YearNode>,
)

data class YearNode(
    val nodeId: Int,
    val title: String,
    val description: String
)