package com.hachdevs.hachproject.presentation.screens.auth.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.hachdevs.hachproject.App
import com.hachdevs.hachproject.R
import com.hachdevs.hachproject.domain.global.common.AuthType
import com.hachdevs.hachproject.presentation.global.base.BaseFragment
import com.hachdevs.hachproject.presentation.global.util.accessible
import com.hachdevs.hachproject.presentation.global.util.isEnabled
import com.hachdevs.hachproject.presentation.global.util.withArgs
import com.hachdevs.hachproject.presentation.screens.auth.mvp.AuthPresenter
import com.hachdevs.hachproject.presentation.screens.auth.mvp.AuthView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_auth.view.*
import javax.inject.Inject

class AuthFragment : BaseFragment(), AuthView, View.OnClickListener {
    override val layoutRes = R.layout.fragment_auth

    @Inject
    @InjectPresenter
    lateinit var presenter: AuthPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    // ui
    private lateinit var loginEdit: AppCompatEditText
    private lateinit var passwordEdit: AppCompatEditText
    private lateinit var authTypeText: AppCompatTextView
    private lateinit var signInButton: Button

    private var authType: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.authComponentBuilder().build().inject(this)

        (this as Fragment).arguments?.let {
            authType = it.getString(AUTH_TYPE, "")
        }
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.signInButton -> presenter.onSignInClicked(loginEdit.text.toString(), passwordEdit.text.toString())
        }
    }

    override fun showLoginError() {
        loginEdit.error = "Неверный логин"
    }

    override fun showPasswordError() {
        passwordEdit.error = "Неверный пароль"
    }

    private fun initViews(view: View) {
        loginEdit = view.loginEdit
        passwordEdit = view.passwordEdit
        authTypeText = view.authTypeText
        signInButton = view.signInButton

        init()
    }

    private fun init() {
        setupToolbar("Авторизация", showNavIcon = true)

        signInButton.setOnClickListener(this)

        authTypeText.text = authType

        // Отслеживает данные в обязательных полях, чтобы сделать кнопку "Войти" доступной,
        // когда они все будут заполнены
        subscriptions += Observables.combineLatest(
            RxTextView.textChanges(loginEdit),
            RxTextView.textChanges(passwordEdit)
        ) { login, password ->
            login.isNotBlank() && password.isNotBlank()
        }
            .subscribeBy { signInButton.isEnabled(it) }

        // Отслеживат данные в полях "Логин" и "Пароль", чтобы выделить поле,
        // после ввода текста, и убрать выделение, когда поле пусто
        subscriptions += RxTextView.textChanges(loginEdit)
            .subscribeBy { loginEdit.isSelected = it.isNotBlank() }
        subscriptions += RxTextView.textChanges(passwordEdit)
            .subscribeBy { passwordEdit.isSelected = it.isNotBlank() }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    companion object {
        fun newInstance(authType: AuthType) = (AuthFragment() as Fragment).withArgs {
            putString(AUTH_TYPE, authType.type)
        }

        const val AUTH_TYPE = "auth_type"
    }
}
