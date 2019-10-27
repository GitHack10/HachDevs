package com.hachdevs.schoolbuddy.presentation.screens.theme.ui

import android.os.Bundle
import android.view.View
import android.widget.Space
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.hachdevs.schoolbuddy.App
import com.hachdevs.schoolbuddy.R
import com.hachdevs.schoolbuddy.domain.global.models.ThemeItem
import com.hachdevs.schoolbuddy.presentation.global.base.BaseFragment
import com.hachdevs.schoolbuddy.presentation.global.util.withArgs
import com.hachdevs.schoolbuddy.presentation.screens.theme.mvp.ThemePresenter
import com.hachdevs.schoolbuddy.presentation.screens.theme.mvp.ThemeView
import kotlinx.android.synthetic.main.fragment_profile_student.view.*
import kotlinx.android.synthetic.main.fragment_profile_student.view.performanceItem
import kotlinx.android.synthetic.main.fragment_profile_student.view.progressStudentItem
import kotlinx.android.synthetic.main.fragment_theme.view.*
import kotlinx.android.synthetic.main.toolbar.view.*
import org.jetbrains.anko.find
import javax.inject.Inject

class ThemeFragment : BaseFragment(), ThemeView, View.OnClickListener {
    override val layoutRes = R.layout.fragment_theme

    @Inject
    @InjectPresenter
    lateinit var presenter: ThemePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    // ui
    private lateinit var toolbar: Toolbar
    private lateinit var menuIconPlaceholder: Space
    private lateinit var nameText: AppCompatTextView
    private lateinit var schoolText: AppCompatTextView

    private var themeItem: ThemeItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (this as Fragment).arguments?.let {
            themeItem = it.getParcelable(THEME_ITEM)
        }

        App.appComponent.themeComponentBuilder().build().inject(this)
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

        val lessonsStudentItemText = view.lessonsStudentItem.find<TextView>(R.id.itemMenuText)
        val testsStudentItemText = view.testsStudentItem.find<TextView>(R.id.itemMenuText)
        val performanceStudentItemText = view.performanceStudentItem.find<TextView>(R.id.itemMenuText)
        val progressStudentItemText = view.progressStudentItem.find<TextView>(R.id.itemMenuText)

        lessonsStudentItemText.text = "Уроки"
        testsStudentItemText.text = "Тесты"
        performanceStudentItemText.text = "Успеваемость"
        progressStudentItemText.text = "Достижения"
        init()
    }

    private fun init() {
        setupToolbar(themeItem?.name ?: "Предмет", showNavIcon = true)
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {
        fun newInstance(themeItem: ThemeItem) = (ThemeFragment() as Fragment).withArgs {
            putParcelable(THEME_ITEM, themeItem)
        }

        const val THEME_ITEM = "theme_item"
    }
}
