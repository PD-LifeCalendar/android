package com.example.lifecalendar.ui.fragment.goals

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.ItemGoalsChildBinding

class GoalsChildItemViewHolder(val binding: ItemGoalsChildBinding) : RecyclerView.ViewHolder(binding.root){
    val goalName: TextView = itemView.findViewById(R.id.goalName)
}