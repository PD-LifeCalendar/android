package com.example.lifecalendar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.FragmentRegistrationMailCodeBinding

class RegistrationMailCode : Fragment() {

    private lateinit var binding: FragmentRegistrationMailCodeBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRegistrationMailCodeBinding.inflate(inflater, container, false)
    
        binding.nextBtn.setOnClickListener {
            navigateToRegistrationMailCode()
        }
    
        binding.icBack.setOnClickListener {
            navigateToRegistrationNameFragment()
        }
        
        return binding.root
    }
    
    private fun navigateToRegistrationMailCode() {
        val action = RegistrationMailCodeDirections.actionRegistrationMailCodeToRegistrationPasswordFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToRegistrationNameFragment() {
        val action = RegistrationMailCodeDirections.actionRegistrationMailCodeToFragmentRegistrationEmail()
        findNavController().navigate(action)
    }
}