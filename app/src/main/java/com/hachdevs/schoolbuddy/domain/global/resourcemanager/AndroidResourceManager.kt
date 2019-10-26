package com.hachdevs.schoolbuddy.domain.global.resourcemanager

import android.content.Context
import javax.inject.Inject

class AndroidResourceManager @Inject constructor(private val context: Context) : ResourceManager {

    override fun getQuantityString(number_of_foods: Int, count: Int): String =
        context.resources.getQuantityString(number_of_foods, count, count)

    override fun getStringFormatted(resourceId: Int, vararg formatArgs: Array<out Any?>): String =
        context.getString(resourceId, formatArgs)

    override fun getArrayOfStrings(resourceId: Int): Array<String> =
        context.resources.getStringArray(resourceId)

    override fun getString(resourceId: Int): String = context.getString(resourceId)
}