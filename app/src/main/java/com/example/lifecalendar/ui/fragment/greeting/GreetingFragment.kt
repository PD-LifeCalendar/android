package com.example.lifecalendar.ui.fragment.greeting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.App
import com.example.lifecalendar.data.source.local.prefs.FirstRunAppManager
import com.example.lifecalendar.databinding.FragmentGreetingPageBinding
import javax.inject.Inject


class GreetingFragment : Fragment() {
    
    private lateinit var binding: FragmentGreetingPageBinding
    
    @Inject
    lateinit var firstRunAppManager: FirstRunAppManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        checkFirstRunApp()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGreetingPageBinding.inflate(inflater, container, false)
        
        binding.nextBtn.setOnClickListener {
            navigateToGreetingSecondFragment()
        }
        
        binding.skipBtn.setOnClickListener {
            navigateToRegistration()
        }
        
        return binding.root
    }
    
    private fun checkFirstRunApp() {
        if (!firstRunAppManager.isFirstRunApp()) navigateToRegistration()
        firstRunAppManager.fixFirstRunApp()
    }
    
    private fun navigateToGreetingSecondFragment() {
        val action = GreetingFragmentDirections.actionGreetingFragmentToGreetingSecondFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToRegistration() {
        val action =
            GreetingFragmentDirections.actionGreetingFragmentToRegistrationBirthdateFragment()
        findNavController().navigate(action)
    }
}