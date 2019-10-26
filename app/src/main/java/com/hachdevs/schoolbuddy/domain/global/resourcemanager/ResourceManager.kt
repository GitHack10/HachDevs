package com.hachdevs.schoolbuddy.domain.global.resourcemanager

interface ResourceManager {
    fun getString(resourceId: Int): String
    fun getArrayOfStrings(resourceId: Int): Array<String>
    fun getStringFormatted(resourceId: Int, vararg formatArgs: Array<out Any?>): String
    fun getQuantityString(number_of_foods: Int, count: Int): String
}