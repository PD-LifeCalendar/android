package com.example.lifecalendar.utils

import android.content.Context
import android.widget.Toast

internal interface ToastMaker {
    fun makeLongToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }
    
    fun makeShortToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}