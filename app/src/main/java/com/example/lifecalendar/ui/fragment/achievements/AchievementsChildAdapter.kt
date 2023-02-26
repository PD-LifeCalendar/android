package com.example.lifecalendar.ui.fragment.achievements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemAchievementsChildBinding
import com.example.lifecalendar.ui.fragment.achievements.AchievementsChildItemViewHolder
import com.example.lifecalendar.ui.model.AchievementsChildItemUiModel


class AchievementsChildAdapter(private val childList: List<AchievementsChildItemUiModel>) : RecyclerView.Adapter<AchievementsChildItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AchievementsChildItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAchievementsChildBinding.inflate(inflater, parent, false)
        return AchievementsChildItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AchievementsChildItemViewHolder, position: Int) {
        val achievementName = childList[position].name
        holder.achievementName.text = achievementName
    }

    override fun getItemCount(): Int = childList.size

}
