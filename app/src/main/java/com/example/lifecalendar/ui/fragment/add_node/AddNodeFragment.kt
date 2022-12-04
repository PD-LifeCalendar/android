package com.example.lifecalendar.ui.fragment.add_node

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lifecalendar.App
import com.example.lifecalendar.databinding.FragmentAddNodeBinding
import com.example.lifecalendar.utils.ToastMaker
import javax.inject.Inject


class AddNodeFragment : Fragment(), ToastMaker {
    
    private lateinit var binding: FragmentAddNodeBinding
    private lateinit var viewModel: AddNodeViewModel
    private val args by navArgs<AddNodeFragmentArgs>()
    
    @Inject
    lateinit var viewModelFactory: AddNodeViewModelFactory
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        initViewModel()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNodeBinding.inflate(inflater, container, false)
        binding.addBtn.setOnClickListener { addYearNode() }
        lifecycleScope.launchWhenStarted {
            viewModel.successFlow.collect { isSuccess ->
                if (isSuccess) {
                    makeLongToast(requireContext(), "Успешно добавлено")
                    binding.descriptionInput.setText("")
                    binding.titleInput.setText("")
                } else makeLongToast(requireContext(), "Неизвестная ошибка")
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.messageFlow.collect { message ->
                makeLongToast(requireContext(), message)
            }
        }
        
        return binding.root
    }
    
    
    
    private fun addYearNode() {
        val title = binding.titleInput.text.toString()
        val description = binding.descriptionInput.text.toString()
        viewModel.addYearNode(args.selectedYear, title, description)
    }
    
    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[AddNodeViewModel::class.java]
    }
    
}