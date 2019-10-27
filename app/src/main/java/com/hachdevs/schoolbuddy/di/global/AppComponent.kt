package com.hachdevs.schoolbuddy.di.global

import android.content.Context
import com.hachdevs.schoolbuddy.di.global.modules.DataModule
import com.hachdevs.schoolbuddy.di.global.modules.NavigationModule
import com.hachdevs.schoolbuddy.di.global.modules.NetworkModule
import com.hachdevs.schoolbuddy.di.global.modules.PrefsModule
import com.hachdevs.schoolbuddy.di.screens.auth.AuthComponent
import com.hachdevs.schoolbuddy.di.screens.home.HomeComponent
import com.hachdevs.schoolbuddy.di.screens.main.MainComponent
import com.hachdevs.schoolbuddy.di.screens.profiles.student.ProfileStudentComponent
import com.hachdevs.schoolbuddy.di.screens.profiles.teacher.ProfileTeacherComponent
import com.hachdevs.schoolbuddy.di.screens.theme.ThemeComponent
import com.hachdevs.schoolbuddy.di.screens.themes.StudentThemesComponent
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
    fun profileStudentComponentBuilder(): ProfileStudentComponent.Builder
    fun studentThemesComponentBuilder(): StudentThemesComponent.Builder
    fun themeComponentBuilder(): ThemeComponent.Builder

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun bindsInstanceContext(context: Context): Builder
    }
}