package com.example.lifecalendar.ui.fragment.birthdate

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lifecalendar.App
import com.example.lifecalendar.data.source.local.db.DateConverter
import com.example.lifecalendar.data.source.local.prefs.BirthdateManager
import com.example.lifecalendar.databinding.FragmentRegistrationBirthdateBinding
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject


class RegistrationBirthdateFragment : Fragment() {
    
    private lateinit var binding: FragmentRegistrationBirthdateBinding
    private var year = 0
    private var month = 0
    private var day = 0
    private var birthdateTimestamp = 0L
    
    @Inject
    lateinit var birthdateManager: BirthdateManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        getDateCalendar()
        checkBirthdate()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBirthdateBinding.inflate(inflater, container, false)
        setupDateChooser()
        binding.nextBtn.setOnClickListener {
            birthdateManager.saveBirthdate(birthdateTimestamp)
            navigateToLifeCalendar()
        }
        return binding.root
    }
    
    private fun checkBirthdate() {
        if (birthdateManager.getBirthdate() != 0L) navigateToLifeCalendar()
    }
    
    private fun getDateCalendar() {
        val calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
    }
    
    private fun setupDateChooser() {
        binding.inputLayoutDay.setOnClickListener { dateChooser() }
        binding.inputLayoutMonth.setOnClickListener { dateChooser() }
        binding.inputLayoutYear.setOnClickListener { dateChooser() }
        binding.editTextDay.setOnClickListener { dateChooser() }
        binding.editTextMonth.setOnClickListener { dateChooser() }
        binding.editTextYear.setOnClickListener { dateChooser() }
        binding.birthdate.setOnClickListener { dateChooser() }
    }
    
    private fun dateChooser() {
        val dateNow = LocalDateTime.now()
        val minDate = DateConverter().localDateTimeToTimestamp(dateNow.minusYears(90)) * 1000
        DatePickerDialog(requireContext(), { _, mYear, mMonth, mDay ->
            binding.editTextDay.setText(mDay.toString())
            binding.editTextMonth.setText("${mMonth + 1}")
            binding.editTextYear.setText(mYear.toString())
            binding.nextBtn.isEnabled = true
            val birthdate = LocalDateTime.of(mYear, mMonth + 1, mDay, 0, 0, 0)
            birthdateTimestamp = DateConverter().localDateTimeToTimestamp(birthdate)
        }, year, month, day).apply {
            datePicker.maxDate = Date().time
            datePicker.minDate = minDate
        }.show()
    }
    
    private fun navigateToLifeCalendar() {
        val action =
            RegistrationBirthdateFragmentDirections.actionRegistrationBirthdateFragmentToLifeCalendarFragment()
        findNavController().navigate(action)
    }
}