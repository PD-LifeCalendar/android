package com.example.lifecalendar.data.source.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.data.R

class BirthdateManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    
    companion object {
        const val BIRTHDATE = "birthdate"
    }
    
    fun saveBirthdate(birthdate: Long) {
        prefs.edit().putLong(BIRTHDATE, birthdate).apply()
    }
    
    fun getBirthdate(): Long = prefs.getLong(BIRTHDATE, 0)
}