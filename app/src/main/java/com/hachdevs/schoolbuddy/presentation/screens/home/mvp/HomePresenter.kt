package com.hachdevs.schoolbuddy.presentation.screens.home.mvp

import com.arellomobile.mvp.InjectViewState
import com.hachdevs.schoolbuddy.data.global.DataManager
import com.hachdevs.schoolbuddy.domain.global.common.AuthType
import com.hachdevs.schoolbuddy.presentation.global.Screens
import com.hachdevs.schoolbuddy.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class HomePresenter @Inject constructor(
    private val router: Router,
    private val dataManager: DataManager
) : BasePresenter<HomeView>(router) {

    fun onStudentButtonClicked() = router.navigateTo(Screens.Auth(AuthType.student))
    fun onTeacherButtonClicked() = router.navigateTo(Screens.Auth(AuthType.teacher))
    fun onParentButtonClicked() = router.navigateTo(Screens.Auth(AuthType.parent))
}
