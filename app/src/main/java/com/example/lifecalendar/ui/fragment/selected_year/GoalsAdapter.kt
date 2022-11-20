package com.example.lifecalendar.ui.fragment.selected_year

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemGoalBinding
import com.example.lifecalendar.ui.model.GoalsListUiModel

class GoalsAdapter : RecyclerView.Adapter<SelectedYearViewHolder>() {

    private var years = mutableListOf<GoalsListUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedYearViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGoalBinding.inflate(inflater, parent, false)
        return SelectedYearViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectedYearViewHolder, position: Int) {
        val year = years[position].goal
        val icon = years[position].icon
//        years.getOrNull(position)?.let {  }
        with(holder.binding) {
            goalText.text = year
            goalText.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0,0)
            goalText.compoundDrawablePadding = 9
        }
    }

    override fun getItemCount(): Int = years.size

    fun setData(years: MutableList<GoalsListUiModel>) {
        this.years = years
    }

}
