package com.example.lifecalendar.ui.fragment.selected_year


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifecalendar.App
import com.example.lifecalendar.databinding.FragmentSelectedYearBinding
import com.example.lifecalendar.ui.model.YearNode
import com.example.lifecalendar.utils.FragmentMVVM
import com.example.lifecalendar.utils.ToastMaker
import javax.inject.Inject

class SelectedYearFragment : Fragment(), ToastMaker, FragmentMVVM, SelectedYearPassClick {
    
    private lateinit var binding: FragmentSelectedYearBinding
    private lateinit var viewModel: SelectedYearViewModel
    private lateinit var selectedYearAdapter: SelectedYearAdapter
    private val args by navArgs<SelectedYearFragmentArgs>()
    
    @Inject
    lateinit var viewModelFactory: SelectedYearViewModelFactory
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        initViewModel()
        viewModel.fetchNodes(args.selectedYear)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectedYearBinding.inflate(inflater, container, false)
        setupRecycler()
        viewModel.selectedYearUiModelLiveData.observe(viewLifecycleOwner) {
            binding.yearText.text = it.selectedYear
            selectedYearAdapter.setData(it.nodes)
        }
        binding.addNewNode.setOnClickListener {
            val action = SelectedYearFragmentDirections.actionSelectedYearFragmentToAddNodeFragment(
                personAge = args.personAge,
                selectedYear = args.selectedYear
            )
            findNavController().navigate(action)
        }
        
        return binding.root
    }
    
    // TODO: Убрать кастыль
    override fun onStart() {
        super.onStart()
        viewModel.fetchNodes(args.selectedYear)
    }

    override fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[SelectedYearViewModel::class.java]
    }
    
    private fun setupRecycler() {
        selectedYearAdapter = SelectedYearAdapter(this)
        val layoutManager = LinearLayoutManager(context)
        binding.goals.layoutManager = layoutManager
        binding.goals.adapter = selectedYearAdapter
    }
    
    override fun deleteNodeById(nodeId: Int) {
        viewModel.deleteNodeById(nodeId)
    }
    
    override fun updateNode(yearNode: YearNode) {
        val selectedYear = viewModel.selectedYearUiModelLiveData.value?.selectedYear?.toInt()
        if (selectedYear != null) {
            val action = SelectedYearFragmentDirections.actionSelectedYearFragmentToEditNodeFragment(
                id = yearNode.nodeId,
                year = selectedYear,
                title = yearNode.title,
                description = yearNode.description
            )
            findNavController().navigate(action)
        } else {
            makeShortToast(requireContext(), "неизвестная ошибка")
        }
        
    }
}