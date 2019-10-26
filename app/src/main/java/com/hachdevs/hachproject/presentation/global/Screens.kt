package com.hachdevs.hachproject.presentation.global

import android.content.Context
import android.content.Intent
import com.hachdevs.hachproject.domain.global.common.AuthType
import com.hachdevs.hachproject.presentation.screens.auth.ui.AuthFragment
import com.hachdevs.hachproject.presentation.screens.home.ui.HomeFragment
import com.hachdevs.hachproject.presentation.screens.main.ui.MainActivity
import com.hachdevs.hachproject.presentation.screens.profiles.teacher.ui.ProfileTeacherFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object Main : SupportAppScreen() {
        override fun getActivityIntent(context: Context?) = Intent(context, MainActivity::class.java)
    }

    object Welcome : SupportAppScreen() {
        override fun getFragment() = HomeFragment()
    }

    data class Auth(private val authType: AuthType) : SupportAppScreen() {
        override fun getFragment() = AuthFragment.newInstance(authType)
    }

    object ProfileTeacher : SupportAppScreen() {
        override fun getFragment() = ProfileTeacherFragment()
    }
}