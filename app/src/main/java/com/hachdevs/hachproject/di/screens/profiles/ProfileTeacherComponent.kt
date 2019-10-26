package com.hachdevs.hachproject.di.screens.profiles

import com.hachdevs.hachproject.di.global.scopes.FragmentScope
import com.hachdevs.hachproject.presentation.screens.profiles.teacher.ui.ProfileTeacherFragment
import dagger.Subcomponent

@Subcomponent(modules = [ProfileTeacherModule::class])
@FragmentScope
interface ProfileTeacherComponent {
    fun inject(fragment: ProfileTeacherFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ProfileTeacherComponent
    }
}