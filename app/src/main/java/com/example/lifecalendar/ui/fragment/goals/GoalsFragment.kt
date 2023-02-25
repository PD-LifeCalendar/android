package com.example.lifecalendar.ui.fragment.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lifecalendar.App
import com.example.lifecalendar.databinding.FragmentGoalsBinding
import com.example.lifecalendar.ui.model.GoalsItemsFuns
import com.example.lifecalendar.utils.FragmentMVVM
import com.example.lifecalendar.utils.ToastMaker
import javax.inject.Inject

class GoalsFragment : Fragment(), ToastMaker, FragmentMVVM {

    private lateinit var binding: FragmentGoalsBinding
    private lateinit var viewModel: GoalsViewModel
    private lateinit var goalsParentAdapter: GoalsParentAdapter

    @Inject
    lateinit var viewModelFactory: GoalsViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGoalsBinding.inflate(inflater, container, false)
        (requireContext().applicationContext as App).appComponent.inject(this)
        initViewModel()
        setupRecycler()
        return binding.root
    }

    override fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[GoalsViewModel::class.java]
    }

    private fun setupRecycler() {
        val allItems = GoalsItemsFuns.getAllItems()
        goalsParentAdapter = GoalsParentAdapter(allItems)
        val firstLayoutManager = GridLayoutManager(context, 1)
        binding.goalsList.layoutManager = firstLayoutManager
        binding.goalsList.adapter = goalsParentAdapter
    }
}