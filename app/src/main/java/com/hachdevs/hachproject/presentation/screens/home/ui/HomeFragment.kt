package com.hachdevs.hachproject.presentation.screens.home.ui

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.hachdevs.hachproject.App
import com.hachdevs.hachproject.R
import com.hachdevs.hachproject.presentation.global.base.BaseFragment
import com.hachdevs.hachproject.presentation.screens.home.mvp.HomePresenter
import com.hachdevs.hachproject.presentation.screens.home.mvp.HomeView
import kotlinx.android.synthetic.main.fragment_home.view.*
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeView, View.OnClickListener {
    override val layoutRes = R.layout.fragment_home

    @Inject
    @InjectPresenter
    lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.homeComponentBuilder().build().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.studentButton -> presenter.onStudentButtonClicked()
            R.id.teacherButton -> presenter.onTeacherButtonClicked()
            R.id.parentButton -> presenter.onParentButtonClicked()
        }
    }

    private fun init(view: View) {
        setupToolbar("Добро пожаловать")

        view.studentButton.setOnClickListener(this)
        view.teacherButton.setOnClickListener(this)
        view.parentButton.setOnClickListener(this)
    }

    override fun onBackPressed() = presenter.onBackPressed()
}
