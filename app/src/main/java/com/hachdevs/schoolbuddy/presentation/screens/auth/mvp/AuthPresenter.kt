package com.hachdevs.schoolbuddy.presentation.screens.auth.mvp

import com.arellomobile.mvp.InjectViewState
import com.hachdevs.schoolbuddy.data.global.DataManager
import com.hachdevs.schoolbuddy.domain.global.common.AuthType
import com.hachdevs.schoolbuddy.presentation.global.Screens
import com.hachdevs.schoolbuddy.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class AuthPresenter @Inject constructor(
    private val router: Router,
    private val dataManager: DataManager
) : BasePresenter<AuthView>(router) {

    fun onSignInClicked(login: String, password: String, authType: String) {
        when {
            login == LOGIN && password == PASSWORD -> {
                dataManager.setIsLogin(true)
                dataManager.setLoginType(authType)
                when(authType) {
                    AuthType.teacher.type -> router.newRootScreen(Screens.ProfileTeacher)
                    AuthType.student.type -> router.newRootScreen(Screens.ProfileStudent)
                }
            }
            login != LOGIN -> viewState.showLoginError()
            password != PASSWORD -> viewState.showPasswordError()
            login != LOGIN && password != PASSWORD -> {
                viewState.showLoginError()
                viewState.showPasswordError()
            }
        }
    }

    companion object{
        const val LOGIN = "admin"
        const val PASSWORD = "password"
    }
}
