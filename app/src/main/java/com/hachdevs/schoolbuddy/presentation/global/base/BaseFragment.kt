package com.hachdevs.schoolbuddy.presentation.global.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import com.arellomobile.mvp.MvpAppCompatFragment
import com.hachdevs.schoolbuddy.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.toolbar.view.*
import org.jetbrains.anko.support.v4.findOptional

abstract class BaseFragment : MvpAppCompatFragment() {
    protected abstract val layoutRes: Int
    protected val subscriptions = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutRes, container, false)

    override fun onDestroyView() {
        subscriptions.clear()
        super.onDestroyView()
    }

    protected fun setupToolbar(title: String, showNavIcon: Boolean = false, icon: Int = R.drawable.ic_back) {
        val toolbar: Toolbar? = findOptional(R.id.toolbar)
        toolbar?.run {
            if (showNavIcon) {
                setNavigationIcon(icon)
                setNavigationOnClickListener {
                    if (icon == R.drawable.ic_back) onBackPressed()
                }
                navIconPlaceholder.isVisible = false
            }
            titleText.text = title
        }
    }

    abstract fun onBackPressed()
}