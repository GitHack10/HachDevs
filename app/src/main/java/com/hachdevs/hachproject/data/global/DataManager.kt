package com.hachdevs.hachproject.data.global

import com.hachdevs.hachproject.data.network.ApiEduc
import com.hachdevs.hachproject.data.prefs.PrefsHelper

class DataManager(
    private val prefsHelper: PrefsHelper,
    private val apiPeretz: ApiEduc
) {

    fun setIsLogin(isLogin: Boolean) {
        prefsHelper.setIsLogin(isLogin)
    }

    fun isLogin() = prefsHelper.getIsLogin()
}
