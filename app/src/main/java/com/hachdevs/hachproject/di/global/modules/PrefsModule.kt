package com.hachdevs.hachproject.di.global.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.hachdevs.hachproject.data.prefs.PrefsHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Модуль предоставляет SharedPreferences-хранилище в
 * приложении
 */
@Module
class PrefsModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun providePrefsHelper(sharedPrefs: SharedPreferences) = PrefsHelper(sharedPrefs)
}