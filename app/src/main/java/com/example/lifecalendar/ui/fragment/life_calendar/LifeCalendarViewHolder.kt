package com.example.lifecalendar.ui.fragment.life_calendar

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.databinding.ItemYearBinding
import com.example.lifecalendar.ui.model.LifeCalendarUiModel

class LifeCalendarViewHolder(private val binding: ItemYearBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(lifeCalendarUiModel: LifeCalendarUiModel) = binding.run {
        yearButton.text = lifeCalendarUiModel.year
    
        if (lifeCalendarUiModel.year.toInt() <= lifeCalendarUiModel.personAge.toInt())
            yearButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFD789"))
        else yearButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#f4f4f4"))
    
        yearButton.setOnClickListener {
            val action =
                LifeCalendarFragmentDirections.actionLifeCalendarFragmentToSelectedYearFragment(
                    lifeCalendarUiModel.personAge.toInt(),
                    lifeCalendarUiModel.year.toInt()
                )
            itemView.findNavController().navigate(action)
        }
    }
}