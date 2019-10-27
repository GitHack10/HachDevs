package com.hachdevs.schoolbuddy.presentation.screens.themes.mvp

import com.arellomobile.mvp.InjectViewState
import com.hachdevs.schoolbuddy.data.global.DataManager
import com.hachdevs.schoolbuddy.domain.global.models.ThemeItem
import com.hachdevs.schoolbuddy.presentation.global.Screens
import com.hachdevs.schoolbuddy.presentation.global.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class StudentThemesPresenter @Inject constructor(
    private val router: Router,
    private val dataManager: DataManager
) : BasePresenter<StudentThemesView>(router) {

    private var themes: List<ThemeItem> = ArrayList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getThemes()
    }

    fun onItemThemeClicked(theme: ThemeItem) {
        router.navigateTo(Screens.Theme(theme))
    }

    private fun getThemes() {
        (themes as ArrayList).add(ThemeItem(1, "Математика", "Неусвоенны 2 темы", false))
        (themes as ArrayList).add(ThemeItem(2, "Русский язык", "Неусвоенны 3 темы", false))
        (themes as ArrayList).add(ThemeItem(3, "Биология", "Все отлично", true))
        (themes as ArrayList).add(ThemeItem(4, "Химия", "Все отлично", true))

        viewState.showThemes(themes)
    }
}
