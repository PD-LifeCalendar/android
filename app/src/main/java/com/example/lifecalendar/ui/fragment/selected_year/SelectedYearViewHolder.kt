package com.example.lifecalendar.ui.fragment.selected_year

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemGoalBinding
import com.example.lifecalendar.ui.model.YearNode

class SelectedYearViewHolder(private val binding: ItemGoalBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(node: YearNode, listener: SelectedYearPassClick) = binding.run {
        binding.goalText.text = node.title
        binding.goalDescription.text = node.description
        goalDescription.isVisible = node.description.isNotEmpty()
        
        deleteBtn.setOnClickListener { listener.deleteNodeById(node.nodeId) }
        
        itemView.setOnClickListener { listener.updateNode(node) }
    }
}