package com.hachdevs.schoolbuddy.presentation.screens.themes.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.hachdevs.schoolbuddy.App
import com.hachdevs.schoolbuddy.R
import com.hachdevs.schoolbuddy.domain.global.models.ThemeItem
import com.hachdevs.schoolbuddy.presentation.global.base.BaseFragment
import com.hachdevs.schoolbuddy.presentation.screens.themes.mvp.StudentThemesPresenter
import com.hachdevs.schoolbuddy.presentation.screens.themes.mvp.StudentThemesView
import kotlinx.android.synthetic.main.fragment_student_themes.view.*
import kotlinx.android.synthetic.main.toolbar.view.*
import javax.inject.Inject

class StudentThemesFragment : BaseFragment(), StudentThemesView, View.OnClickListener {
    override val layoutRes = R.layout.fragment_student_themes

    @Inject
    @InjectPresenter
    lateinit var presenter: StudentThemesPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    // ui
    private lateinit var toolbar: Toolbar
    private lateinit var themesRecycler: RecyclerView

    private val themeAdapter by lazy {
        ThemeAdapter(ArrayList()) {
            presenter.onItemThemeClicked(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.studentThemesComponentBuilder().build().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    override fun onClick(view: View?) {
        when (view?.id) {

        }
    }

    private fun initViews(view: View) {
        toolbar = view.toolbar
        themesRecycler = view.themesRecycler

        themesRecycler.adapter = themeAdapter

        init()
    }

    private fun init() {
        setupToolbar("Предметы", showNavIcon = true)
    }

    override fun showProgress(show: Boolean) {
        // TODO
    }

    override fun showThemes(themes: List<ThemeItem>) {
        themeAdapter.list = themes
        themeAdapter.submitList(themes)
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }
}
