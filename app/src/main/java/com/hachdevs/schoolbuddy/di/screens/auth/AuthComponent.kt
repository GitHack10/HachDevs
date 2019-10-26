package com.hachdevs.schoolbuddy.di.screens.auth

import com.hachdevs.schoolbuddy.di.global.scopes.FragmentScope
import com.hachdevs.schoolbuddy.presentation.screens.auth.ui.AuthFragment
import dagger.Subcomponent

@Subcomponent(modules = [AuthModule::class])
@FragmentScope
interface AuthComponent {

    fun inject(fragment: AuthFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): AuthComponent
    }
}