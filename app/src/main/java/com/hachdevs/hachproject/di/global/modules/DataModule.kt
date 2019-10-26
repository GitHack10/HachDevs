package com.hachdevs.hachproject.di.global.modules

import com.hachdevs.hachproject.data.global.DataManager
import com.hachdevs.hachproject.data.network.ApiEduc
import com.hachdevs.hachproject.data.prefs.PrefsHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDataManager(prefsHelper: PrefsHelper, apiPeretz: ApiEduc) =
        DataManager(
            prefsHelper,
            apiPeretz
        )
}