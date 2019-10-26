package com.hachdevs.hachproject.di.screens.main

import com.hachdevs.hachproject.di.global.scopes.ActivityScope
import com.hachdevs.hachproject.presentation.screens.main.ui.MainActivity
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