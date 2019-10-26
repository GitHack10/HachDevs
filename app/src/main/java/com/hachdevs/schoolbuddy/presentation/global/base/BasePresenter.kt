package com.hachdevs.schoolbuddy.presentation.global.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Router

open class BasePresenter<V : MvpView>(private val router: Router) : MvpPresenter<V>() {

    protected val subscriptions = CompositeDisposable()

    override fun onDestroy() {
        subscriptions.dispose()
    }

    open fun onBackPressed() {
        router.exit()
    }
}