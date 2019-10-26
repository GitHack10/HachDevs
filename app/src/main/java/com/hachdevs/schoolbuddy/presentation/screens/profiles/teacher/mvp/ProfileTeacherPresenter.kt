package com.hachdevs.schoolbuddy.presentation.screens.profiles.teacher.mvp

import com.arellomobile.mvp.InjectViewState
import com.hachdevs.schoolbuddy.data.global.DataManager
import com.hachdevs.schoolbuddy.presentation.global.Screens
import com.hachdevs.schoolbuddy.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileTeacherPresenter @Inject constructor(
    private val router: Router,
    private val dataManager: DataManager
) : BasePresenter<ProfileTeacherView>(router) {

    fun onLogoutClicked() {
        dataManager.setIsLogin(false)
        router.newRootScreen(Screens.Welcome)
    }
}
