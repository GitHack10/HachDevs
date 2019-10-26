package com.hachdevs.hachproject.presentation.screens.auth.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface AuthView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showLoginError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showPasswordError()
}
