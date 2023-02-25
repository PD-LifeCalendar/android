package com.example.lifecalendar.ui.model

import com.example.lifecalendar.R

data class GoalsParentItemUiModel(
    val childItemsList: List<GoalsChildItemUiModel>,
    val yearNumber: String
)

data class GoalsChildItemUiModel(
    val name: String,
    val icon: Int
)

object GoalsItemsFuns {
    fun getAllItems(): List<GoalsParentItemUiModel> {
        val array = mutableListOf<GoalsParentItemUiModel>()
        array.add(GoalsParentItemUiModel(getItem(), "15"))
        array.add(GoalsParentItemUiModel(getItem(), "16"))
        array.add(GoalsParentItemUiModel(getItem(), "17"))
        return array
    }
    fun getItem(): List<GoalsChildItemUiModel> {
        val array = mutableListOf<GoalsChildItemUiModel>()
        array.add(GoalsChildItemUiModel(name = "Переехать в место с лучшими условиями которые только могут быть в этом мире.", R.drawable.first_goal_icon))
        array.add(GoalsChildItemUiModel(name = "Купить собаку", R.drawable.first_goal_icon))
        array.add(GoalsChildItemUiModel(name = "Выжить", R.drawable.second_goal_icon))
        array.add(GoalsChildItemUiModel(name = "Прокачать себя", R.drawable.third_goal_icon))
        array.add(GoalsChildItemUiModel(name = "Подкачать себя", R.drawable.third_goal_icon))
        array.add(GoalsChildItemUiModel(name = "Устала придумывать цели", R.drawable.first_goal_icon))
        return array
    }
}
