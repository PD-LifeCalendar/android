package com.example.lifecalendar.ui.fragment.life_calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemYearBinding
import com.example.lifecalendar.ui.model.LifeCalendarUiModel


class LifeCalendarAdapter : RecyclerView.Adapter<LifeCalendarViewHolder>() {

    private var lifeCalendarUiModelList = emptyList<LifeCalendarUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifeCalendarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemYearBinding.inflate(inflater, parent, false)
        return LifeCalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LifeCalendarViewHolder, position: Int) {
        lifeCalendarUiModelList.getOrNull(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = lifeCalendarUiModelList.size

    fun setData(lifeCalendarUiModelList: List<LifeCalendarUiModel>) {
        this.lifeCalendarUiModelList = lifeCalendarUiModelList
    }

}