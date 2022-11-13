package com.example.lifecalendar.ui.fragment.life_calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemYearBinding
import com.example.lifecalendar.ui.model.ArrayYear
import com.example.lifecalendar.ui.model.LifeCalendarUiModel


class LifeCalendarAdapter : RecyclerView.Adapter<LifeCalendarViewHolder>() {

    private var years = mutableListOf<LifeCalendarUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifeCalendarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemYearBinding.inflate(inflater, parent, false)
        return LifeCalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LifeCalendarViewHolder, position: Int) {
        val year = years[position]
//        years.getOrNull(position)?.let {  }
        with(holder.binding) {
            yearText.text = year.year
        }
    }

    override fun getItemCount(): Int = years.size

    fun setData(years:MutableList<LifeCalendarUiModel>) {
        this.years = years
    }

}