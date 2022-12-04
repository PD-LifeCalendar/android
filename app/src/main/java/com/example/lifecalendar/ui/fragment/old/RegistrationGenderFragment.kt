package com.example.lifecalendar.ui.fragment.old

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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
        
        return binding.root
    }
    
    private fun navigateToRegistrationCareerFragment() {
        val action = RegistrationGenderFragmentDirections.actionRegistrationGenderFragmentToRegistrationCareerFragment()
        findNavController().navigate(action)
    }
    
    
}