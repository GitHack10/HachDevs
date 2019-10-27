package com.hachdevs.schoolbuddy.presentation.screens.profiles.student.mvp

import com.arellomobile.mvp.InjectViewState
import com.hachdevs.schoolbuddy.data.global.DataManager
import com.hachdevs.schoolbuddy.presentation.global.Screens
import com.hachdevs.schoolbuddy.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileStudentPresenter @Inject constructor(
    private val router: Router,
    private val dataManager: DataManager
) : BasePresenter<ProfileStudentView>(router) {

    fun onLogoutClicked() {
        dataManager.setIsLogin(false)
        dataManager.clearLoginType()
        router.newRootScreen(Screens.Welcome)
    }

    fun onNotificationsClicked() { }
}
