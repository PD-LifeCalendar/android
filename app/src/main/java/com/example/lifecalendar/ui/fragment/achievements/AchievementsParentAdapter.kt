package com.example.lifecalendar.ui.fragment.achievements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemAchievementsParentBinding
import com.example.lifecalendar.ui.fragment.achievements.AchievementsChildAdapter
import com.example.lifecalendar.ui.fragment.achievements.AchievementsParentItemViewHolder
import com.example.lifecalendar.ui.model.AchievementsParentItemUiModel

class AchievementsParentAdapter(private val parentItemList: List<AchievementsParentItemUiModel>) : RecyclerView.Adapter<AchievementsParentItemViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AchievementsParentItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAchievementsParentBinding.inflate(inflater, parent, false)
        return AchievementsParentItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AchievementsParentItemViewHolder, position: Int) {
        val parentItem = parentItemList[position]
        holder.listAchievements.layoutManager = GridLayoutManager(holder.itemView.context, 1)
        val adapter = AchievementsChildAdapter(parentItem.childItemsList)
        holder.listAchievements.adapter = adapter
        holder.yearNumber.text = parentItemList[position].yearNumber
    }

    override fun getItemCount(): Int = parentItemList.size

}