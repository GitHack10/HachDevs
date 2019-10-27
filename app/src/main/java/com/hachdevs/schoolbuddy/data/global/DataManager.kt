package com.hachdevs.schoolbuddy.data.global

import com.hachdevs.schoolbuddy.data.network.ApiEduc
import com.hachdevs.schoolbuddy.data.prefs.PrefsHelper

class DataManager(
    private val prefsHelper: PrefsHelper,
    private val apiEduc: ApiEduc
) {

    fun setIsLogin(isLogin: Boolean) {
        prefsHelper.setIsLogin(isLogin)
    }

    fun isLogin() = prefsHelper.getIsLogin()

    fun setLoginType(authType: String) {
        prefsHelper.setLoginType(authType)
    }

    fun getLoginType() = prefsHelper.getLoginType()

    fun clearLoginType() = prefsHelper.setLoginType(null)
}