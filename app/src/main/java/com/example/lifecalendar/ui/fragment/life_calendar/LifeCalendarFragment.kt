package com.example.lifecalendar.ui.fragment.life_calendar

import android.os.BugreportManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifecalendar.App
import com.example.lifecalendar.databinding.ActivityMainBinding
import com.example.lifecalendar.databinding.FragmentLifeCalendarBinding
import com.example.lifecalendar.utils.FragmentMVVM
import com.example.lifecalendar.utils.ToastMaker
import com.example.lifecalendar.databinding.ItemYearBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecalendar.ui.model.ArrayYear


import javax.inject.Inject

class LifeCalendarFragment : Fragment(), ToastMaker, FragmentMVVM {

    private lateinit var binding: FragmentLifeCalendarBinding
    private lateinit var viewModel: LifeCalendarViewModel
    private lateinit var adapter: LifeCalendarAdapter

    @Inject
    lateinit var viewModelFactory: LifeCalendarViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLifeCalendarBinding.inflate(inflater, container, false)
        (requireContext().applicationContext as App).appComponent.inject(this)
        initViewModel()
        setupRecycler()
        adapter.setData(ArrayYear.getArray().toMutableList())
        return binding.root
    }

    override fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[LifeCalendarViewModel::class.java]
    }

    private fun setupRecycler() {
        adapter = LifeCalendarAdapter()
        val layoutManager = GridLayoutManager(context, 8)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }
}