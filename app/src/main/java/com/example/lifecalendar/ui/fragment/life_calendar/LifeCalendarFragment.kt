package com.example.lifecalendar.ui.fragment.life_calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lifecalendar.App
import com.example.lifecalendar.databinding.FragmentLifeCalendarBinding
import com.example.lifecalendar.utils.FragmentMVVM
import com.example.lifecalendar.utils.ToastMaker
import com.example.lifecalendar.data.source.local.prefs.BirthdateManager
import javax.inject.Inject

class LifeCalendarFragment : Fragment(), ToastMaker, FragmentMVVM {

    private lateinit var binding: FragmentLifeCalendarBinding
    private lateinit var viewModel: LifeCalendarViewModel
    private lateinit var adapter: LifeCalendarAdapter

    @Inject
    lateinit var viewModelFactory: LifeCalendarViewModelFactory
    
    @Inject
    lateinit var birthdateManager: BirthdateManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        initViewModel()
        viewModel.calculateYearsOld(birthdateManager.getBirthdate())
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLifeCalendarBinding.inflate(inflater, container, false)
        setupRecycler()
        viewModel.lifeCalendarUiModelLiveData.observe(viewLifecycleOwner) { adapter.setData(it) }
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