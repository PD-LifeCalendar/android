package com.example.lifecalendar.ui.fragment.old

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.databinding.FragmentRegistrationBirthdateBinding


class RegistrationBirthdateFragment : Fragment() {
    
    private lateinit var binding: FragmentRegistrationBirthdateBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBirthdateBinding.inflate(inflater, container, false)
    
        binding.nextBtn.setOnClickListener {
            navigateToRegistrationGenderFragment()
        }
    
        binding.icBack.setOnClickListener {
            navigateToRegistrationPasswordFragment()
        }
        
        return binding.root
    }
    
    private fun navigateToRegistrationGenderFragment() {
        val action = RegistrationBirthdateFragmentDirections.actionRegistrationBirthdateFragmentToRegistrationGenderFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToRegistrationPasswordFragment() {
        val action = RegistrationBirthdateFragmentDirections.actionRegistrationBirthdateFragmentToRegistrationPasswordFragment()
        findNavController().navigate(action)
    }
}