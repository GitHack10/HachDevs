package com.hachdevs.schoolbuddy

import android.app.Application
import com.hachdevs.schoolbuddy.di.global.AppComponent
import com.hachdevs.schoolbuddy.di.global.DaggerAppComponent

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