package com.example.lifecalendar.ui.fragment.selected_year

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lifecalendar.App
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.FragmentGoalActionBinding
import com.example.lifecalendar.databinding.FragmentSelectedYearBinding
import com.example.lifecalendar.ui.model.Achievements
import com.example.lifecalendar.ui.model.Goals
import javax.inject.Inject


class GoalActionFragment : Fragment() {
    private lateinit var binding: FragmentGoalActionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGoalActionBinding.inflate(inflater, container, false)
        return binding.root
    }



}