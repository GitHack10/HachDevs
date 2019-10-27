package com.hachdevs.schoolbuddy.data.prefs

import android.content.SharedPreferences

class PrefsHelper(private val sharedPrefs: SharedPreferences) {

    fun setIsLogin(isLogin: Boolean) {
        sharedPrefs.edit()
            .putBoolean(PREF_IS_LOGIN, isLogin)
            .apply()
    }

    fun getIsLogin() = sharedPrefs.getBoolean(PREF_IS_LOGIN, false)

    fun setLoginType(authType: String?) {
        sharedPrefs.edit()
            .putString(PREF_LOGIN_TYPE, authType)
            .apply()
    }

    fun getLoginType() = sharedPrefs.getString(PREF_LOGIN_TYPE, null)

    companion object {
        const val PREF_IS_LOGIN = "is_login"
        const val PREF_LOGIN_TYPE = "login_type"
    }
}