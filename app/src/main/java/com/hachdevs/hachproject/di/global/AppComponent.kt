package com.hachdevs.hachproject.di.global

import android.content.Context
import com.hachdevs.hachproject.di.global.modules.DataModule
import com.hachdevs.hachproject.di.global.modules.NavigationModule
import com.hachdevs.hachproject.di.global.modules.NetworkModule
import com.hachdevs.hachproject.di.global.modules.PrefsModule
import com.hachdevs.hachproject.di.screens.auth.AuthComponent
import com.hachdevs.hachproject.di.screens.home.HomeComponent
import com.hachdevs.hachproject.di.screens.main.MainComponent
import com.hachdevs.hachproject.di.screens.profiles.ProfileTeacherComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        NavigationModule::class,
        PrefsModule::class,
        DataModule::class
    ]
)
@Singleton
interface AppComponent {

    fun mainСomponentBuilder(): MainComponent.Builder
    fun homeComponentBuilder(): HomeComponent.Builder
    fun authComponentBuilder(): AuthComponent.Builder
    fun profileTeacherComponentBuilder(): ProfileTeacherComponent.Builder

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun bindsInstanceContext(context: Context): Builder
    }
}