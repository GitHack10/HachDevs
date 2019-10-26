package com.hachdevs.hachproject.presentation.global.util

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.openBrowser(url: String) {
    try {
        startActivity(
                Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = Uri.parse(url)
                }
        )
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
    }
}

fun Fragment.openBrowser(url: String) {
    try {
        startActivity(
                Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = Uri.parse(url)
                }
        )
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
    }
}