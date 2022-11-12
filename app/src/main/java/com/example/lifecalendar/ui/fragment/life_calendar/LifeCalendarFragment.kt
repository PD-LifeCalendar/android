package com.example.lifecalendar.ui.fragment.life_calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lifecalendar.App
import com.example.lifecalendar.databinding.FragmentLifeCalendarBinding
import com.example.lifecalendar.utils.FragmentMVVM
import com.example.lifecalendar.utils.ToastMaker
import javax.inject.Inject

class LifeCalendarFragment : Fragment(), ToastMaker, FragmentMVVM {
    
    private lateinit var binding: FragmentLifeCalendarBinding
    private lateinit var viewModel: LifeCalendarViewModel
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
        return binding.root
    }
    
     override fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[LifeCalendarViewModel::class.java]
    }
    
    fun setupRecycler() {
        /*
        TODO: Вадим
            - init recycler here
        */
    }
}