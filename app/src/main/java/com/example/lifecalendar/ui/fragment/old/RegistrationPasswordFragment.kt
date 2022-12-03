package com.example.lifecalendar.ui.fragment.old

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.databinding.FragmentRegistrationPasswordBinding


class RegistrationPasswordFragment : Fragment() {
    
    private lateinit var binding: FragmentRegistrationPasswordBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationPasswordBinding.inflate(inflater, container, false)
    
        binding.icBack.setOnClickListener {
            navigateToRegistrationMailCode()
        }
    
        return binding.root
    }
    
    private fun navigateToRegistrationMailCode() {
        val action = RegistrationPasswordFragmentDirections.actionRegistrationPasswordFragmentToRegistrationMailCode()
        findNavController().navigate(action)
    }
}