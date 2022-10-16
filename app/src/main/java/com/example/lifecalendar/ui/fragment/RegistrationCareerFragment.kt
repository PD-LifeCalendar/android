package com.example.lifecalendar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.FragmentRegistrationCareerBinding

class RegistrationCareerFragment : Fragment() {
    
    private lateinit var binding: FragmentRegistrationCareerBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationCareerBinding.inflate(inflater, container, false)
    
        binding.nextBtn.setOnClickListener {
            navigateToRegistrationStatusFragment()
        }
    
        /*binding.icBack.setOnClickListener {
            navigateToRegistrationGenderFragment()
        }*/
        
        return binding.root
    }
    
    private fun navigateToRegistrationStatusFragment() {
        val action = RegistrationCareerFragmentDirections.actionRegistrationCareerFragmentToRegistrationStatusFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToRegistrationGenderFragment() {
        val action = RegistrationCareerFragmentDirections.actionRegistrationCareerFragmentToRegistrationGenderFragment()
        findNavController().navigate(action)
    }
}