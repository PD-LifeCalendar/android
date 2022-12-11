package com.example.lifecalendar.ui.fragment.settings

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lifecalendar.App
import com.example.lifecalendar.data.source.local.db.DateConverter
import com.example.lifecalendar.data.source.local.prefs.BirthdateManager
import com.example.lifecalendar.data.source.local.prefs.YearsCountManager
import com.example.lifecalendar.databinding.FragmentSettingsBinding
import com.example.lifecalendar.utils.ToastMaker
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject

class SettingsFragment : Fragment(), ToastMaker {
    
    private lateinit var binding: FragmentSettingsBinding
    private var year = 0
    private var month = 0
    private var day = 0
    private var birthdateTimestamp = 0L
    
    @Inject
    lateinit var yearsCountManager: YearsCountManager
    
    @Inject
    lateinit var birthdateManager: BirthdateManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        getDateCalendar()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        setupDateChooser()
        
        val displayingYearsCount = yearsCountManager.getYearsCount()
        if (displayingYearsCount != null) binding.yearsEditText.setText(displayingYearsCount)
        else binding.yearsEditText.setText("100")
        
        val displayingBirthdate = DateConverter().timestampToLocalDateTime(birthdateManager.getBirthdate())
        val displayingYear = displayingBirthdate.year.toString()
        val displayingMonth = displayingBirthdate.monthValue.toString()
        val displayingDays = displayingBirthdate.dayOfMonth.toString()
        binding.birthdateEditText.setText("$displayingDays.$displayingMonth.$displayingYear")
        
        binding.saveBtn.setOnClickListener {
            val yearsCount = binding.yearsEditText.text.toString()
            if (isYearsCountValid(yearsCount)) {
                yearsCountManager.saveYearsCount(yearsCount)
                makeShortToast(requireContext(), "Изменения вступили в силу")
            }
            if (birthdateTimestamp != 0L) {
                birthdateManager.saveBirthdate(birthdateTimestamp)
                makeShortToast(requireContext(), "Изменения вступили в силу")
            }
        }
        
        return binding.root
    }
    
    private fun getDateCalendar() {
        val calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
    }
    
    private fun setupDateChooser() {
        binding.birthdateInputLayout.setOnClickListener { dateChooser() }
        binding.birthdateEditText.setOnClickListener { dateChooser() }
    }
    
    private fun dateChooser() {
        val dateNow = LocalDateTime.now()
        val minDate = DateConverter().localDateTimeToTimestamp(dateNow.minusYears(90)) * 1000
        DatePickerDialog(requireContext(), { _, mYear, mMonth, mDay ->
            binding.birthdateEditText.setText("$mDay.$mMonth.$mYear")
            val birthdate = LocalDateTime.of(mYear, mMonth + 1, mDay, 0, 0, 0)
            birthdateTimestamp = DateConverter().localDateTimeToTimestamp(birthdate)
        }, year, month, day).apply {
            datePicker.maxDate = Date().time
            datePicker.minDate = minDate
        }.show()
    }
    
    private fun isYearsCountValid(yearsCount: String): Boolean {
        return if (yearsCount.toInt() > 200) {
            makeShortToast(requireContext(), "Слишком много лет")
            false
        } else if (yearsCount.toInt() < 6) {
            makeShortToast(requireContext(), "Возраст не может быть меньше 6")
            false
        } else if (yearsCount.isEmpty()) {
            makeShortToast(requireContext(), "Не введено значение")
            false
        } else true
    }
}