package com.hachdevs.schoolbuddy.presentation.screens.main.mvp

import com.arellomobile.mvp.InjectViewState
import com.hachdevs.schoolbuddy.data.global.DataManager
import com.hachdevs.schoolbuddy.domain.global.common.AuthType
import com.hachdevs.schoolbuddy.presentation.global.Screens
import com.hachdevs.schoolbuddy.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val router: Router,
        private val dataManager: DataManager
) : BasePresenter<MainView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        when {
            dataManager.isLogin() && dataManager.getLoginType() == AuthType.teacher.type -> {
                router.replaceScreen(Screens.ProfileTeacher)
            }
            dataManager.isLogin() && dataManager.getLoginType() == AuthType.student.type -> {
                router.replaceScreen(Screens.ProfileStudent)
            }

            else -> router.replaceScreen(Screens.Welcome)
        }
    }
}
