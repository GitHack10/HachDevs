package com.hachdevs.hachproject.presentation.global.views

import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.hachdevs.hachproject.R


class AnimatingRelativeLayout : ConstraintLayout {
    internal var context: Context
    lateinit var inAnimation: Animation
    lateinit var outAnimation: Animation

    val isVisible: Boolean
        get() = this.visibility == View.VISIBLE

    constructor(context: Context) : super(context) {
        this.context = context
        initAnimations()

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.context = context
        initAnimations()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        this.context = context
        initAnimations()
    }

    private fun initAnimations() {
        inAnimation = AnimationUtils.loadAnimation(context, R.anim.in_animation)
        outAnimation = AnimationUtils.loadAnimation(context, R.anim.in_animation)
    }

    fun show() {
        if (isVisible) return
        show(true)
    }

    fun show(withAnimation: Boolean) {
        if (withAnimation) this.startAnimation(inAnimation)
        this.visibility = View.VISIBLE
    }

    fun hide() {
        if (!isVisible) return
        hide(true)
    }

    fun hide(withAnimation: Boolean) {
        if (withAnimation) this.startAnimation(outAnimation)
        this.visibility = View.GONE
    }

    fun overrideDefaultInAnimation(inAnimation: Animation) {
        this.inAnimation = inAnimation
    }

    fun overrideDefaultOutAnimation(outAnimation: Animation) {
        this.outAnimation = outAnimation
    }
}