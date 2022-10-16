package com.example.lifecalendar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.FragmentRegistrationGenderBinding

class RegistrationGenderFragment : Fragment() {
    
    private lateinit var binding: FragmentRegistrationGenderBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationGenderBinding.inflate(inflater, container, false)
    
        binding.nextBtn.setOnClickListener {
            navigateToRegistrationCareerFragment()
        }
    
        /*binding.icBack.setOnClickListener {
            navigateToRegistrationBirthdateFragment()
        }*/
        
        return binding.root
    }
    
    private fun navigateToRegistrationCareerFragment() {
        val action = RegistrationGenderFragmentDirections.actionRegistrationGenderFragmentToRegistrationCareerFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToRegistrationBirthdateFragment() {
        val action = RegistrationGenderFragmentDirections.actionRegistrationGenderFragmentToRegistrationBirthdateFragment()
        findNavController().navigate(action)
    }
}