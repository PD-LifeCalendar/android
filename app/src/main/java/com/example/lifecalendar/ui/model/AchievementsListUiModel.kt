package com.example.lifecalendar.ui.model

import com.example.lifecalendar.R

data class AchievementsParentItemUiModel(
    val childItemsList: List<AchievementsChildItemUiModel>,
    val yearNumber: String
)

data class AchievementsChildItemUiModel(
    val name: String,
    val icon: Int
)

object AchievementsItemsFuns {
    fun getAllItems(): List<AchievementsParentItemUiModel> {
        val array = mutableListOf<AchievementsParentItemUiModel>()
        array.add(AchievementsParentItemUiModel(getItem(), "15"))
        array.add(AchievementsParentItemUiModel(getItem(), "16"))
        array.add(AchievementsParentItemUiModel(getItem(), "17"))
        return array
    }
    fun getItem(): List<AchievementsChildItemUiModel> {
        val array = mutableListOf<AchievementsChildItemUiModel>()
        array.add(AchievementsChildItemUiModel(name = "Переехать в место с лучшими условиями которые только могут быть в этом мире.", R.drawable.first_goal_icon))
        array.add(AchievementsChildItemUiModel(name = "Купить собаку", R.drawable.first_goal_icon))
        array.add(AchievementsChildItemUiModel(name = "Выжить", R.drawable.second_goal_icon))
        array.add(AchievementsChildItemUiModel(name = "Прокачать себя", R.drawable.third_goal_icon))
        array.add(AchievementsChildItemUiModel(name = "Подкачать себя", R.drawable.third_goal_icon))
        array.add(AchievementsChildItemUiModel(name = "Устала придумывать цели", R.drawable.first_goal_icon))
        return array
    }
}
