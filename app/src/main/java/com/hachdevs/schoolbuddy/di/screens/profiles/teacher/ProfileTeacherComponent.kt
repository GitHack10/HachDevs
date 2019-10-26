package com.hachdevs.schoolbuddy.di.screens.profiles.teacher

import com.hachdevs.schoolbuddy.di.global.scopes.FragmentScope
import com.hachdevs.schoolbuddy.presentation.screens.profiles.teacher.ui.ProfileTeacherFragment
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