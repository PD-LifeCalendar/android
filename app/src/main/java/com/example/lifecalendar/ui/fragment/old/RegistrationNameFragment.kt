package com.example.lifecalendar.ui.fragment.old

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        
        return binding.root
    }
    
    private fun navigateToRegistrationEmailFragment() {
        val action = RegistrationNameFragmentDirections.actionRegistrationNameFragmentToRegistrationEmailFragment()
        findNavController().navigate(action)
    }
}