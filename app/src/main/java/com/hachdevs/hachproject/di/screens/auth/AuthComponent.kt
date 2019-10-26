package com.hachdevs.hachproject.di.screens.auth

import com.hachdevs.hachproject.di.global.scopes.FragmentScope
import com.hachdevs.hachproject.presentation.screens.auth.ui.AuthFragment
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