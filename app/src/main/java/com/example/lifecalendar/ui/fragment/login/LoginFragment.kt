package com.example.lifecalendar.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.App
import com.example.lifecalendar.databinding.FragmentLoginBinding
import com.example.lifecalendar.utils.ToastMaker
import javax.inject.Inject

class LoginFragment : Fragment(), ToastMaker {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        checkToken()
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginBtn.setOnClickListener { login() }
        binding.registrationText.setOnClickListener { navigateToRegistrationFragment() }

        lifecycleScope.launchWhenStarted {
            viewModel.loginFailedFlow.collect { errorMessage ->
                makeLongToast(requireContext(), "error code - $errorMessage")
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.loginSuccessFlow.collect { successMessage ->
                makeLongToast(requireContext(), successMessage)
//                navigateToLifeCalendarFragment()
            }
        }

        return binding.root
    }

    private fun login() {
        val name = binding.nameInput.text.toString().trim()
        val password = binding.passwordInput.text.toString().trim()
        if(!isValidName(name)) {
            makeLongToast(requireContext() , "is not valid name")
        } else if (!isValidPassword(password)) {
            makeLongToast(requireContext() , "is not valid password")
        } else viewModel.login(name = name, password = password)
    }

    private fun isValidPassword(password: String?) : Boolean {
        password?.let {
            val passwordPattern = "[A-Za-z0-9!@#\$%^&*(){}\\[\\]]+"
            val passwordMatcher = Regex(passwordPattern)
            if (password.length < 8) return false
            if (password.length > 255) return false
            return passwordMatcher.find(password) != null
        } ?: return false }

    private fun isValidName(name: String?) : Boolean {
        name?.let {
            val namePattern = "[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}"
            val nameMatcher = Regex(namePattern)
            if (name.length < 2) return false
            if (name.length > 64) return false
            return nameMatcher.find(name) != null
        } ?: return false
    }

    private fun checkToken() {
        // TODO()
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]
    }

    private fun navigateToLifeCalendarFragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToLifeCalendarFragment()
        findNavController().navigate(action)
    }

    private fun navigateToRegistrationFragment() {
            val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
            findNavController().navigate(action)

    }
}