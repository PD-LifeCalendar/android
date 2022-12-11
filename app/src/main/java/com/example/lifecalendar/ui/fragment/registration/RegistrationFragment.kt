package com.example.lifecalendar.ui.fragment.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lifecalendar.databinding.FragmentRegistrationBinding
import com.example.lifecalendar.utils.ToastMaker

class RegistrationFragment : Fragment(), ToastMaker {
    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        binding.regButton.setOnClickListener { reg() }
        return binding.root
    }

    private fun reg() {
        val name = binding.nameInput.text.toString().trim()
        val password = binding.regPasswordInput.text.toString().trim()
        val mail = binding.mailInput.text.toString().trim()
        if(!isValidName(name)) {
            makeLongToast(requireContext() , "is not valid name")
        } else if (!isValidPassword(password)) {
            makeLongToast(requireContext() , "is not valid password")
        } else if (!isValidMail(mail)) {
            makeLongToast(requireContext() , "is not valid mail")
        }
    }

    private fun isValidPassword(password: String?) : Boolean {
        password?.let {
            val passwordPattern = "[A-Za-z0-9!@#\$%^&*(){}\\[\\]]+"
            val passwordMatcher = Regex(passwordPattern)
            if (password.length < 8) return false
            if (password.length > 255) return false
            return passwordMatcher.find(password) != null
        } ?: return false }

    private fun isValidMail(mail: String?) : Boolean {
        mail?.let {
            val namePattern = "[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}"
            val nameMatcher = Regex(namePattern)
            if (mail.length < 2) return false
            if (mail.length > 64) return false
            return nameMatcher.find(mail) != null
        } ?: return false
    }
    private fun isValidName(name: String?) : Boolean {
        name?.let {
            val namePattern = "([а-яa-zА-ЯA-Z]+)(?:\\s|-)?([\\sа-яa-zА-ЯA-Z]+)([a-zа-я]\$)"
            val nameMatcher = Regex(namePattern)
            if (name.length < 2) return false
            if (name.length > 64) return false
            return nameMatcher.find(name) != null
        } ?: return false
    }

}