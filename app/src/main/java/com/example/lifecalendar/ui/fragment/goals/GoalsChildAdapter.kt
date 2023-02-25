package com.example.lifecalendar.ui.fragment.goals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemGoalsChildBinding
import com.example.lifecalendar.ui.model.GoalsChildItemUiModel


class GoalsChildAdapter(private val childList: List<GoalsChildItemUiModel>) : RecyclerView.Adapter<GoalsChildItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalsChildItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGoalsChildBinding.inflate(inflater, parent, false)
        return GoalsChildItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GoalsChildItemViewHolder, position: Int) {
        val goalName = childList[position].name
        holder.goalName.text = goalName
    }

    override fun getItemCount(): Int = childList.size


}