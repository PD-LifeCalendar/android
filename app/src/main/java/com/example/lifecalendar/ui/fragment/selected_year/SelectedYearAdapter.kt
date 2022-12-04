package com.example.lifecalendar.ui.fragment.selected_year

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemGoalBinding
import com.example.lifecalendar.ui.model.YearNode

class SelectedYearAdapter(private val listener: SelectedYearPassClick) :
    RecyclerView.Adapter<SelectedYearViewHolder>() {
    
    private var yearNodes = mutableListOf<YearNode>()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedYearViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGoalBinding.inflate(inflater, parent, false)
        return SelectedYearViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: SelectedYearViewHolder, position: Int) {
        yearNodes.getOrNull(position)?.let {
            holder.bind(it, listener)
        }
    }
    
    override fun getItemCount(): Int = yearNodes.size
    
    fun setData(yearNodes: List<YearNode>) {
        this.yearNodes = yearNodes.toMutableList()
        notifyDataSetChanged()
    }
    
}
