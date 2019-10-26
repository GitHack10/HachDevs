package com.hachdevs.schoolbuddy.di.screens.home

import com.hachdevs.schoolbuddy.di.global.scopes.FragmentScope
import com.hachdevs.schoolbuddy.presentation.screens.home.ui.HomeFragment
import dagger.Subcomponent

@Subcomponent(modules = [HomeModule::class])
@FragmentScope
interface HomeComponent {

    fun inject(fragment: HomeFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): HomeComponent
    }
}