package com.example.lifecalendar.ui.fragment.edit_node

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lifecalendar.App
import com.example.lifecalendar.R
import com.example.lifecalendar.databinding.FragmentAddNodeBinding
import com.example.lifecalendar.ui.fragment.add_node.AddNodeViewModel
import com.example.lifecalendar.utils.ToastMaker
import javax.inject.Inject

class EditNodeFragment : Fragment(), ToastMaker {
    
    private lateinit var binding: FragmentAddNodeBinding
    private lateinit var viewModel: EditNodeViewModel
    private val args by navArgs<EditNodeFragmentArgs>()
    
    @Inject
    lateinit var viewModelFactory: EditNodeViewModelFactory
    
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
        setUi()
        lifecycleScope.launchWhenStarted {
            viewModel.successFlow.collect { isSuccess ->
                if (isSuccess) {
                    makeLongToast(requireContext(), "Успешно добавлено")
                } else makeLongToast(requireContext(), "Неизвестная ошибка")
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.messageFlow.collect { message ->
                makeLongToast(requireContext(), message)
            }
        }
        binding.addBtn.setOnClickListener { updateYearNode() }
        return binding.root
    }
    
    private fun updateYearNode() {
        val title = binding.titleInput.text.toString()
        val description = binding.descriptionInput.text.toString()
        viewModel.updateNode(
            nodeId = args.id,
            year = args.year,
            title,
            description
        )
    }
    
    private fun setUi() {
        binding.titleInput.setText(args.title)
        binding.descriptionInput.setText(args.description)
    }
    
    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[EditNodeViewModel::class.java]
    }
    
}