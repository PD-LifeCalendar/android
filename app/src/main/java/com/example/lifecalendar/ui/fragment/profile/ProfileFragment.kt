package com.example.lifecalendar.ui.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecalendar.App
import com.example.lifecalendar.data.source.local.prefs.BirthdateManager
import com.example.lifecalendar.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : Fragment() {
    
    private lateinit var binding: FragmentProfileBinding
    
    @Inject
    lateinit var birthdateManager: BirthdateManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        
        return binding.root
    }


}