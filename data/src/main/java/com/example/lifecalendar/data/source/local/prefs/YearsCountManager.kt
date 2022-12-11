package com.example.lifecalendar.data.source.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.data.R

class YearsCountManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    
    companion object {
        const val YEARS_COUNT = "years_count"
    }
    
    fun saveYearsCount(yearsCount: String) {
        prefs.edit().putString(YEARS_COUNT, yearsCount).apply()
    }
    
    fun getYearsCount(): String? = prefs.getString(YEARS_COUNT, null)
    
    fun deleteYearsCount() {
        prefs.edit().putString(YEARS_COUNT, null).apply()
    }
}