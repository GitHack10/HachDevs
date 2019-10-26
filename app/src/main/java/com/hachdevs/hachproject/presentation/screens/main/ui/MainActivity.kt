package com.hachdevs.hachproject.presentation.screens.main.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.hachdevs.hachproject.App
import com.hachdevs.hachproject.R
import com.hachdevs.hachproject.presentation.global.base.BaseActivity
import com.hachdevs.hachproject.presentation.global.base.BaseFragment
import com.hachdevs.hachproject.presentation.screens.main.mvp.MainPresenter
import com.hachdevs.hachproject.presentation.screens.main.mvp.MainView
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {
    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.frame_main_container) as? BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.mainСomponentBuilder().build().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(SupportAppNavigator(this, R.id.frame_main_container))
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}