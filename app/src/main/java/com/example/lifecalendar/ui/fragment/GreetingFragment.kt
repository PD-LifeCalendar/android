package com.example.lifecalendar.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.databinding.FragmentGreetingPageBinding


class GreetingFragment : Fragment() {
    
    private lateinit var binding: FragmentGreetingPageBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGreetingPageBinding.inflate(inflater, container, false)
        
        binding.nextBtn.setOnClickListener {
            navigateToGreetingSecondFragment()
        }
        
        return binding.root
    }
    
    private fun navigateToGreetingSecondFragment() {
        val action = GreetingFragmentDirections.actionGreetingFragmentToGreetingSecondFragment()
        findNavController().navigate(action)
    }
}