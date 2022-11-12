package com.example.lifecalendar

import android.app.Application
import com.example.lifecalendar.di.AppComponent
import com.example.lifecalendar.di.AppModule
import com.example.lifecalendar.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    
    override fun onCreate() {
        super.onCreate()
    
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}