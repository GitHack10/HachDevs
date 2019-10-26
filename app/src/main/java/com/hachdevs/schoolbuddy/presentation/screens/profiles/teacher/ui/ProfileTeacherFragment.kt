package com.hachdevs.schoolbuddy.presentation.screens.profiles.teacher.ui

import android.os.Bundle
import android.view.View
import android.widget.Space
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.hachdevs.schoolbuddy.App
import com.hachdevs.schoolbuddy.R
import com.hachdevs.schoolbuddy.presentation.global.base.BaseFragment
import com.hachdevs.schoolbuddy.presentation.global.dialogs.TwoActionDialog
import com.hachdevs.schoolbuddy.presentation.screens.profiles.teacher.mvp.ProfileTeacherPresenter
import com.hachdevs.schoolbuddy.presentation.screens.profiles.teacher.mvp.ProfileTeacherView
import kotlinx.android.synthetic.main.fragment_profile_teacher.view.*
import kotlinx.android.synthetic.main.toolbar.view.*
import org.jetbrains.anko.find
import javax.inject.Inject

class ProfileTeacherFragment : BaseFragment(), ProfileTeacherView, View.OnClickListener {
    override val layoutRes = R.layout.fragment_profile_teacher

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfileTeacherPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    // ui
    private lateinit var toolbar: Toolbar
    private lateinit var menuIconPlaceholder: Space
    private lateinit var firstNameText: AppCompatTextView
    private lateinit var middletNameText: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.profileTeacherComponentBuilder().build().inject(this)
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
        menuIconPlaceholder = view.menuIconPlaceholder
        firstNameText = view.userFirstNameText
        middletNameText = view.userMiddleNameText

        val lessonsItemText = view.lessonsItem.find<TextView>(R.id.itemMenuText)
        val testsItemText = view.testsItem.find<TextView>(R.id.itemMenuText)
        val performanceItemText = view.performanceItem.find<TextView>(R.id.itemMenuText)
        val rewardsItemText = view.rewardsItem.find<TextView>(R.id.itemMenuText)

        lessonsItemText.text = "Уроки"
        testsItemText.text = "Тесты"
        performanceItemText.text = "Успеваемость"
        rewardsItemText.text = "Награды"

        firstNameText.text = DEFAULT_FIRST_NAME
        middletNameText.text = DEFAULT_MIDDLE_NAME

        init()
    }

    private fun init() {
        setupToolbar("Личный кабинет")
        setupToolbarMenu()
    }

    private fun setupToolbarMenu() {
        menuIconPlaceholder.isVisible = false
        toolbar.run {
            // Не добавляет меню, если уже имеется
            if (menu.size() <= 0) {
                inflateMenu(R.menu.logout)
                setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.icon_logout -> {
                            showLogoutAlert(this)
                            true
                        }

                        else -> false
                    }
                }
            }
        }
    }

    private fun showLogoutAlert(view: View) {
        TwoActionDialog.newInstance(
            title = view.resources.getString(R.string.profile_logout),
            subtitle = view.resources.getString(R.string.profile_logout_message),
            texLeftButton = view.resources.getString(R.string.action_cancel),
            textRightButton = view.resources.getString(R.string.action_yes),
            onPositiveClickListener = {
                presenter.onLogoutClicked()
            }
        ).show((this as Fragment).fragmentManager!!, "TwoActionDialog.javaClass.simpleName")
    }

    override fun onBackPressed() = presenter.onBackPressed()

    companion object {
        const val DEFAULT_FIRST_NAME = "Карахан"
        const val DEFAULT_MIDDLE_NAME = "Якубович"
    }
}
