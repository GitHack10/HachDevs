package com.hachdevs.hachproject.di.screens.home

import com.hachdevs.hachproject.di.global.scopes.FragmentScope
import com.hachdevs.hachproject.presentation.screens.home.ui.HomeFragment
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