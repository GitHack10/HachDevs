package com.hachdevs.schoolbuddy.data.prefs

import android.content.SharedPreferences

class PrefsHelper(private val sharedPrefs: SharedPreferences) {

    fun setIsLogin(isLogin: Boolean) {
        sharedPrefs.edit()
            .putBoolean(PREF_IS_LOGIN, isLogin)
            .apply()
    }

    fun getIsLogin() = sharedPrefs.getBoolean(PREF_IS_LOGIN, false)

    companion object {
        const val PREF_IS_LOGIN = "is login"
    }
}
