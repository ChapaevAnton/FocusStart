package com.w4eret1ckrtb1tch.focusstart.domain.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Currencies(
    val date: Date,
    val previousDate: String,
    val previousURL: String,
    val timeStamp: Date,
    val rate: HashMap<String, Rate>
) : Parcelable