package com.hachdevs.schoolbuddy.presentation.global.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.hachdevs.schoolbuddy.R

fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

fun View.accessible(access: Boolean) {
        val color = if (access) R.color.colorBlue else R.color.buttonDisable
        setBackgroundColor(context.color(color))
        isClickable = access
}

fun View.isEnabled(enable: Boolean) {
        val background = if (enable) R.drawable.button_enabled else R.drawable.button_disabled
        val textColor = if (enable) resources.getColor(R.color.colorWhite) else resources.getColor(R.color.textDesc)
        setBackgroundResource(background)
        if (this is AppCompatButton) this.setTextColor(textColor)
        isClickable = enable
}