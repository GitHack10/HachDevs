package com.hachdevs.schoolbuddy.presentation.screens.theme.mvp

import com.arellomobile.mvp.InjectViewState
import com.hachdevs.schoolbuddy.data.global.DataManager
import com.hachdevs.schoolbuddy.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ThemePresenter @Inject constructor(
    private val router: Router,
    private val dataManager: DataManager
) : BasePresenter<ThemeView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}