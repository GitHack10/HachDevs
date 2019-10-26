package com.hachdevs.hachproject.presentation.screens.auth.mvp

import com.arellomobile.mvp.InjectViewState
import com.hachdevs.hachproject.data.global.DataManager
import com.hachdevs.hachproject.presentation.global.Screens
import com.hachdevs.hachproject.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class AuthPresenter @Inject constructor(
    private val router: Router,
    private val dataManager: DataManager
) : BasePresenter<AuthView>(router) {

    fun onSignInClicked(login: String, password: String) {
        when {
            login == LOGIN && password == PASSWORD -> {
                dataManager.setIsLogin(true)
                router.newRootScreen(Screens.ProfileTeacher)
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
