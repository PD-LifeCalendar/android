package com.example.lifecalendar.ui.fragment.old

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.databinding.FragmentGreetingPageSecondBinding


class GreetingSecondFragment : Fragment() {
    
    private lateinit var binding: FragmentGreetingPageSecondBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGreetingPageSecondBinding.inflate(inflater, container, false)
        
        binding.nextBtn.setOnClickListener {
            navigateToRegistrationNameFragment()
        }
        
        binding.icBack.setOnClickListener {
            navigateToGreetingFragment()
        }
    
        binding.skipBtn.setOnClickListener {
            navigateToRegistrationNameFragment()
        }
        
        return binding.root
    }
    
    private fun navigateToRegistrationNameFragment() {
        val action = GreetingSecondFragmentDirections.actionGreetingSecondFragmentToRegistrationNameFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToGreetingFragment() {
        val action = GreetingSecondFragmentDirections.actionGreetingSecondFragmentToGreetingFragment()
        findNavController().navigate(action)
    }
}