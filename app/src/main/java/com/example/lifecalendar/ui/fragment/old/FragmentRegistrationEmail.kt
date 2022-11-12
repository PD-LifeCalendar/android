package com.example.lifecalendar.ui.fragment.old

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.databinding.FragmentRegistrationEmailBinding

class FragmentRegistrationEmail : Fragment() {
    
    private lateinit var binding: FragmentRegistrationEmailBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationEmailBinding.inflate(inflater, container, false)
    
        binding.nextBtn.setOnClickListener {
            navigateToRegistrationMailCode()
        }
    
        binding.icBack.setOnClickListener {
            navigateToRegistrationNameFragment()
        }
        
        return binding.root
    }
    
    private fun navigateToRegistrationMailCode() {
        val action = FragmentRegistrationEmailDirections.actionFragmentRegistrationEmailToRegistrationMailCode()
        findNavController().navigate(action)
    }
    
    private fun navigateToRegistrationNameFragment() {
        val action = FragmentRegistrationEmailDirections.actionRegistrationEmailFragmentToRegistrationNameFragment()
        findNavController().navigate(action)
    }
}