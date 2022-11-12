package com.example.lifecalendar.ui.fragment.old

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.databinding.FragmentRegistrationStatusBinding

class RegistrationStatusFragment : Fragment() {
    
    private lateinit var binding: FragmentRegistrationStatusBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationStatusBinding.inflate(inflater, container, false)
    
        binding.nextBtn.setOnClickListener {
            navigateToRegistrationAvatarFragment()
        }
    
        binding.icBack.setOnClickListener {
            navigateToRegistrationGenderFragment()
        }
        
        return binding.root
    }
    
    private fun navigateToRegistrationAvatarFragment() {
        val action = RegistrationStatusFragmentDirections.actionRegistrationStatusFragmentToRegistrationAvatarFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToRegistrationGenderFragment() {
        val action = RegistrationStatusFragmentDirections.actionRegistrationStatusFragmentToRegistrationCareerFragment()
        findNavController().navigate(action)
    }
}