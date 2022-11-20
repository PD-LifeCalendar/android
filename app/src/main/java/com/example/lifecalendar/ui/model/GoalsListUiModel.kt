package com.example.lifecalendar.ui.model

import com.example.lifecalendar.R


data class GoalsListUiModel(
    val goal: String,
    val icon: Int
)

data class AchievementsListUiModel(
    val achievement: String,
    val icon: Int
)

object Goals {
    fun getArray(): List<GoalsListUiModel> {
        val array = mutableListOf<GoalsListUiModel>()
        array.add(GoalsListUiModel(goal = "Переехать в место с лучшими условиями которые только могут быть в этом мире.", R.drawable.first_goal_icon))
        array.add(GoalsListUiModel(goal = "Купить собаку", R.drawable.first_goal_icon))
        array.add(GoalsListUiModel(goal = "Выжить", R.drawable.second_goal_icon))
        array.add(GoalsListUiModel(goal = "Прокачать себя", R.drawable.third_goal_icon))
        array.add(GoalsListUiModel(goal = "Подкачать себя", R.drawable.third_goal_icon))
        array.add(GoalsListUiModel(goal = "Устала придумывать цели", R.drawable.first_goal_icon))
        return array
    }
}

object Achievements {
    fun getArray(): List<AchievementsListUiModel> {
        val array = mutableListOf<AchievementsListUiModel>()
        array.add(AchievementsListUiModel(achievement = "В достижениях находятся цели которые уже выполненны", R.drawable.first_goal_icon))
        array.add(AchievementsListUiModel(achievement  = "А вот тут ещё одно выполненное достижение", R.drawable.second_goal_icon))
        array.add(AchievementsListUiModel(achievement  = "ЦелиЦелиЦелиЦелиЦелиЦели", R.drawable.third_goal_icon))
        array.add(AchievementsListUiModel(achievement  = "Достижения", R.drawable.third_goal_icon))
        array.add(AchievementsListUiModel(achievement  = "ДостиженияДостижения", R.drawable.second_goal_icon))
        array.add(AchievementsListUiModel(achievement  = "Достижения", R.drawable.first_goal_icon))
        return array
    }
}