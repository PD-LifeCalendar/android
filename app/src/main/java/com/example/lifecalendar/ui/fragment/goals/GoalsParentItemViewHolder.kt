package com.example.lifecalendar.ui.fragment.goals

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.ItemGoalsParentBinding

class GoalsParentItemViewHolder(val binding: ItemGoalsParentBinding) : RecyclerView.ViewHolder(binding.root){
        val listGoals : RecyclerView = itemView.findViewById(R.id.listGoalsRecyclerView)
        val yearNumber : TextView = itemView.findViewById(R.id.yearNumber)
}