package com.hachdevs.hachproject

import android.app.Application
import com.hachdevs.hachproject.di.global.AppComponent
import com.hachdevs.hachproject.di.global.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        appComponent = DaggerAppComponent
            .builder()
            .bindsInstanceContext(this)
            .build()
    }
}