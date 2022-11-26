package com.example.lifecalendar.ui.fragment.selected_year

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemGoalBinding
import com.example.lifecalendar.ui.model.AchievementsListUiModel
import com.example.lifecalendar.ui.model.GoalsListUiModel

class AchievementsAdapter : RecyclerView.Adapter<SelectedYearViewHolder>() {

    private var achievements = mutableListOf<AchievementsListUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedYearViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGoalBinding.inflate(inflater, parent, false)
        return SelectedYearViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectedYearViewHolder, position: Int) {
        val achievement = achievements[position].achievement
        val icon = achievements[position].icon
        with(holder.binding) {
            goalText.text = achievement
            goalText.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0,0)
            goalText.compoundDrawablePadding = 9
        }
    }

    override fun getItemCount(): Int = achievements.size

    fun setData(years: MutableList<AchievementsListUiModel>) {
        this.achievements = years
    }

}
