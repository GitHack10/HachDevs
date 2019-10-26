package com.hachdevs.schoolbuddy.di.screens.main

import com.hachdevs.schoolbuddy.di.global.scopes.ActivityScope
import com.hachdevs.schoolbuddy.presentation.screens.main.ui.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
@ActivityScope
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): MainComponent
    }
}