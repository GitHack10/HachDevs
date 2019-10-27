package com.hachdevs.schoolbuddy.presentation.screens.themes.mvp

import com.arellomobile.mvp.MvpView
import com.hachdevs.schoolbuddy.domain.global.models.ThemeItem

interface StudentThemesView : MvpView {
    fun showThemes(themes: List<ThemeItem>)

    fun showProgress(show: Boolean)
}