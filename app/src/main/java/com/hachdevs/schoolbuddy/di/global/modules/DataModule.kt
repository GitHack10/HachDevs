package com.hachdevs.schoolbuddy.di.global.modules

import com.hachdevs.schoolbuddy.data.global.DataManager
import com.hachdevs.schoolbuddy.data.network.ApiEduc
import com.hachdevs.schoolbuddy.data.prefs.PrefsHelper
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