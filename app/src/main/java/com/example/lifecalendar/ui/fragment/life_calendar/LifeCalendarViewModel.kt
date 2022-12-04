package com.example.lifecalendar.ui.fragment.life_calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifecalendar.data.source.local.db.DateConverter
import com.example.lifecalendar.ui.model.LifeCalendarUiModel
import java.time.LocalDateTime

class LifeCalendarViewModel : ViewModel() {
    
    private val _lifeCalendarUiModelLiveData: MutableLiveData<List<LifeCalendarUiModel>> = MutableLiveData()
    val lifeCalendarUiModelLiveData: LiveData<List<LifeCalendarUiModel>> get() = _lifeCalendarUiModelLiveData
    
    fun calculateYearsOld(birthdateTimestamp: Long) {
        val birthdate = DateConverter().timestampToLocalDateTime(birthdateTimestamp)
        val yearNow = LocalDateTime.now().year
        val birthdateYear = birthdate.year
        val yearsOld = yearNow - birthdateYear
        val uiModelList = getUiModelList(yearsOld)
        _lifeCalendarUiModelLiveData.postValue(uiModelList)
    }
    
    private fun getUiModelList(yearsOld: Int): List<LifeCalendarUiModel> {
        val lifeCalendarUiModelList = mutableListOf<LifeCalendarUiModel>()
        for (year in 1..100) {
            val lifeCalendarUiModel = LifeCalendarUiModel(year = year.toString(), yearsOld.toString())
            lifeCalendarUiModelList.add(lifeCalendarUiModel)
        }
        return lifeCalendarUiModelList
    }
}