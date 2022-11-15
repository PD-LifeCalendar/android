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
import com.example.lifecalendar.data.source.local.SessionManager
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
        val email = binding.emailInput.text.toString().trim()
        val password = binding.passwordInput.text.toString().trim()
        viewModel.login(email = email, password = password)
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
        // TODO()
    }
}