package com.hachdevs.schoolbuddy.di.screens.profiles.student

import com.hachdevs.schoolbuddy.di.global.scopes.FragmentScope
import com.hachdevs.schoolbuddy.presentation.screens.profiles.student.ui.ProfileStudentFragment
import dagger.Subcomponent

@Subcomponent(modules = [ProfileStudentModule::class])
@FragmentScope
interface ProfileStudentComponent {
    fun inject(fragment: ProfileStudentFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ProfileStudentComponent
    }
}