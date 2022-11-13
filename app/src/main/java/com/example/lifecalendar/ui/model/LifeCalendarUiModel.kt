package com.example.lifecalendar.ui.model

data class LifeCalendarUiModel(
    val year: String
)

object ArrayYear {
    fun getArray(): List<LifeCalendarUiModel> {
        val array = mutableListOf<LifeCalendarUiModel>()

        for (i in 1..100) {
            val b = LifeCalendarUiModel(year = i.toString())
            array.add(b)
        }
        return array
    }
}