package com.hachdevs.hachproject.presentation.screens.home.mvp

import com.arellomobile.mvp.InjectViewState
import com.hachdevs.hachproject.data.global.DataManager
import com.hachdevs.hachproject.domain.global.common.AuthType
import com.hachdevs.hachproject.presentation.global.Screens
import com.hachdevs.hachproject.presentation.global.base.BasePresenter
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
