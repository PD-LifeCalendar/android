package com.example.lifecalendar.ui.fragment.edit_node

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.FragmentAddNodeBinding
import com.example.lifecalendar.utils.ToastMaker

class EditNodeFragment : Fragment(), ToastMaker {
    
    private lateinit var binding: FragmentAddNodeBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNodeBinding.inflate(inflater, container, false)
        return binding.root
    }
    
}