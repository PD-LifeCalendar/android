package com.example.lifecalendar.ui.fragment.achievements

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.ItemAchievementsChildBinding

class AchievementsChildItemViewHolder(val binding: ItemAchievementsChildBinding) : RecyclerView.ViewHolder(binding.root){
    val achievementName: TextView = itemView.findViewById(R.id.achievementName)
}