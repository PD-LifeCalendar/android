package com.example.lifecalendar.ui.fragment.old

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lifecalendar.databinding.FragmentNavDrawerBinding

class FragmentNavDrawer : Fragment() {

    private lateinit var binding: FragmentNavDrawerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNavDrawerBinding.inflate(inflater, container, false)
        return binding.root
    }
}