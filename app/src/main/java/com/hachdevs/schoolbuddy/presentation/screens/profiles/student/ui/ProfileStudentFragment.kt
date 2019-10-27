package com.hachdevs.schoolbuddy.presentation.screens.profiles.student.ui

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
import com.hachdevs.schoolbuddy.presentation.screens.profiles.student.mvp.ProfileStudentPresenter
import com.hachdevs.schoolbuddy.presentation.screens.profiles.student.mvp.ProfileStudentView
import kotlinx.android.synthetic.main.fragment_profile_student.view.*
import kotlinx.android.synthetic.main.toolbar.view.*
import org.jetbrains.anko.find
import javax.inject.Inject

class ProfileStudentFragment : BaseFragment(), ProfileStudentView, View.OnClickListener {
    override val layoutRes = R.layout.fragment_profile_student

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfileStudentPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    // ui
    private lateinit var toolbar: Toolbar
    private lateinit var menuIconPlaceholder: Space
    private lateinit var nameText: AppCompatTextView
    private lateinit var schoolText: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.profileStudentComponentBuilder().build().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.subjectsItem -> presenter.onSubjectsItemClicked()
        }
    }

    private fun initViews(view: View) {
        toolbar = view.toolbar
        menuIconPlaceholder = view.menuIconPlaceholder
        nameText = view.userNameText
        schoolText = view.schoolNameText

        val subjectsItemText = view.subjectsItem.find<TextView>(R.id.itemMenuText)
        val performanceItemText = view.performanceItem.find<TextView>(R.id.itemMenuText)
        val progressStudentItemText = view.progressStudentItem.find<TextView>(R.id.itemMenuText)

        subjectsItemText.text = "Предметы"
        performanceItemText.text = "Успеваемость"
        progressStudentItemText.text = "Достижения"

        nameText.text = DEFAULT_USER_NAME
        schoolText.text = DEFAULT_SCHOOL_NAME

        view.subjectsItem.setOnClickListener(this)

        init()
    }

    private fun init() {
        setupToolbar("Личный кабинет", showNavIcon = true, icon = R.drawable.ic_notifications)
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
                        R.id.icon_notifications -> {
                            presenter.onNotificationsClicked()
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

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {
        const val DEFAULT_USER_NAME = "Джанаев Магомедрасул Магомедович"
        const val DEFAULT_SCHOOL_NAME = "СОШ №10 класс 11 Г"
    }
}
