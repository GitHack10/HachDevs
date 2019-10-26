package com.hachdevs.schoolbuddy.data.global

import com.hachdevs.schoolbuddy.data.network.ApiEduc
import com.hachdevs.schoolbuddy.data.prefs.PrefsHelper

class DataManager(
    private val prefsHelper: PrefsHelper,
    private val apiPeretz: ApiEduc
) {

    fun setIsLogin(isLogin: Boolean) {
        prefsHelper.setIsLogin(isLogin)
    }

    fun isLogin() = prefsHelper.getIsLogin()
}