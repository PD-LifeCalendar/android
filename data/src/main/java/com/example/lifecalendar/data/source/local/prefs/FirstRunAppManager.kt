package com.example.lifecalendar.data.source.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.data.R

class FirstRunAppManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    
    companion object {
        const val IS_FIRST_RUN = "isFirstRun"
    }
    
    fun fixFirstRunApp() {
        prefs.edit().putBoolean(IS_FIRST_RUN, false).apply()
    }
    
    fun isFirstRunApp(): Boolean = prefs.getBoolean(IS_FIRST_RUN, true)
}