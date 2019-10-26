package ru.diitcenter.gooddeeds.presentation.screens.main.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.ProgressBar

class MyProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ProgressBar(context, attrs, defStyleAttr) {

    var onProgressChange: ((Int) -> Unit)? = null

    override fun setProgress(progress: Int) {
        super.setProgress(progress)
        onProgressChange?.let { it(progress) }
    }
}