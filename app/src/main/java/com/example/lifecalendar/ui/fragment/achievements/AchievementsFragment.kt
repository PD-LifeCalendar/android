package com.example.lifecalendar.ui.fragment.achievements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lifecalendar.App
import com.example.lifecalendar.databinding.FragmentAchievementsBinding
import com.example.lifecalendar.ui.model.AchievementsItemsFuns
import com.example.lifecalendar.utils.FragmentMVVM
import com.example.lifecalendar.utils.ToastMaker
import javax.inject.Inject

class AchievementsFragment : Fragment(), ToastMaker, FragmentMVVM {

    private lateinit var binding: FragmentAchievementsBinding
    private lateinit var viewModel: AchievementsViewModel
    private lateinit var achievementsParentAdapter: AchievementsParentAdapter

    @Inject
    lateinit var viewModelFactory: AchievementsViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAchievementsBinding.inflate(inflater, container, false)
        (requireContext().applicationContext as App).appComponent.inject(this)
        initViewModel()
        setupRecycler()
        return binding.root
    }

    override fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[AchievementsViewModel::class.java]
    }

    private fun setupRecycler() {
        val allItems = AchievementsItemsFuns.getAllItems()
        achievementsParentAdapter = AchievementsParentAdapter(allItems)
        val firstLayoutManager = GridLayoutManager(context, 1)
        binding.achievementsList.layoutManager = firstLayoutManager
        binding.achievementsList.adapter = achievementsParentAdapter
    }
}