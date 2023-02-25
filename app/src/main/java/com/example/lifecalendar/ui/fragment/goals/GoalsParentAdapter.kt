package com.example.lifecalendar.ui.fragment.goals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemGoalsParentBinding
import com.example.lifecalendar.ui.model.GoalsParentItemUiModel

class GoalsParentAdapter(private val parentItemList: List<GoalsParentItemUiModel>) : RecyclerView.Adapter<GoalsParentItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalsParentItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGoalsParentBinding.inflate(inflater, parent, false)
        return GoalsParentItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GoalsParentItemViewHolder, position: Int) {
        val parentItem = parentItemList[position]
        holder.listGoals.layoutManager = GridLayoutManager(holder.itemView.context, 1)
        val adapter = GoalsChildAdapter(parentItem.childItemsList)
        holder.listGoals.adapter = adapter
        holder.yearNumber.text = parentItemList[position].yearNumber
    }

    override fun getItemCount(): Int = parentItemList.size


}