package com.example.lifecalendar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.FragmentRegistrationNameBinding

class RegistrationNameFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationNameBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationNameBinding.inflate(inflater, container, false)
        
        binding.nextBtn.setOnClickListener {
            navigateToRegistrationEmailFragment()
        }
        
        binding.icBack.setOnClickListener {
            navigateToGreetingSecondFragment()
        }
        
        return binding.root
    }
    
    private fun navigateToRegistrationEmailFragment() {
        val action = RegistrationNameFragmentDirections.actionRegistrationNameFragmentToRegistrationEmailFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToGreetingSecondFragment() {
        val action = RegistrationNameFragmentDirections.actionRegistrationNameFragmentToGreetingSecondFragment()
        findNavController().navigate(action)
    }
}