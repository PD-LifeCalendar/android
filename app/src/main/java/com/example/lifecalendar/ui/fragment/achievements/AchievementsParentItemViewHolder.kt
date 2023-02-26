package com.example.lifecalendar.ui.fragment.achievements

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.ItemAchievementsParentBinding

class AchievementsParentItemViewHolder(val binding: ItemAchievementsParentBinding) : RecyclerView.ViewHolder(binding.root){
    val listAchievements : RecyclerView = itemView.findViewById(R.id.listAchievementsRecyclerView)
    val yearNumber : TextView = itemView.findViewById(R.id.yearNumber)
}