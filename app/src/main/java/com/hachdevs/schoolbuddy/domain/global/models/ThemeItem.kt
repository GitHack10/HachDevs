package com.hachdevs.schoolbuddy.domain.global.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ThemeItem(
    @SerializedName("id") var id: Long,
    @SerializedName("name") var name: String,
    @SerializedName("desc") var desc: String,
    @SerializedName("allDecided") var allDecided: Boolean
) : Parcelable