package com.example.lifecalendar.ui.fragment.selected_year

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lifecalendar.App
import com.example.lifecalendar.utils.FragmentMVVM
import com.example.lifecalendar.utils.ToastMaker
import com.example.lifecalendar.databinding.FragmentSelectedYearBinding
import com.example.lifecalendar.ui.model.Achievements
import com.example.lifecalendar.ui.model.Goals


import javax.inject.Inject

class SelectedYearFragment : Fragment(), ToastMaker, FragmentMVVM {

    private lateinit var binding: FragmentSelectedYearBinding
    private lateinit var viewModel: SelectedYearViewModel
    private lateinit var goalsAdapter: GoalsAdapter
    private lateinit var achievementsAdapter: AchievementsAdapter

    @Inject
    lateinit var viewModelFactory: SelectedYearViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectedYearBinding.inflate(inflater, container, false)
        (requireContext().applicationContext as App).appComponent.inject(this)
        initViewModel()
        setupRecycler()
        goalsAdapter.setData(Goals.getArray().toMutableList())
        achievementsAdapter.setData(Achievements.getArray().toMutableList())
        return binding.root
    }

    override fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[SelectedYearViewModel::class.java]
    }

    private fun setupRecycler() {
        goalsAdapter = GoalsAdapter()
        achievementsAdapter = AchievementsAdapter()
        val firstLayoutManager = GridLayoutManager(context, 1)
        val secondLayoutManager = GridLayoutManager(context, 1)
        binding.goals.layoutManager = firstLayoutManager
        binding.achievements.layoutManager = secondLayoutManager
        binding.goals.adapter = goalsAdapter
        binding.achievements.adapter = achievementsAdapter
    }
}