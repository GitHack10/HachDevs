package com.hachdevs.schoolbuddy.di.screens.theme

import com.hachdevs.schoolbuddy.di.global.scopes.FragmentScope
import com.hachdevs.schoolbuddy.di.screens.themes.ThemeModule
import com.hachdevs.schoolbuddy.presentation.screens.theme.ui.ThemeFragment
import dagger.Subcomponent

@Subcomponent(modules = [ThemeModule::class])
@FragmentScope
interface ThemeComponent {
    fun inject(fragment: ThemeFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ThemeComponent
    }
}