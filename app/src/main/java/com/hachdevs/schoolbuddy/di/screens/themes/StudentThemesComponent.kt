package com.hachdevs.schoolbuddy.di.screens.themes

import com.hachdevs.schoolbuddy.di.global.scopes.FragmentScope
import com.hachdevs.schoolbuddy.di.screens.theme.ThemeComponent
import com.hachdevs.schoolbuddy.presentation.screens.themes.ui.StudentThemesFragment
import dagger.Subcomponent

@Subcomponent(modules = [StudentThemesModule::class])
@FragmentScope
interface StudentThemesComponent {
    fun inject(fragment: StudentThemesFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): StudentThemesComponent
    }
}