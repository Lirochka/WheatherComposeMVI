package com.example.wheathercomposemvi

import android.app.Application
import com.example.wheathercomposemvi.di.ApplicationComponent
import com.example.wheathercomposemvi.di.DaggerApplicationComponent

class WeatherApp: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}