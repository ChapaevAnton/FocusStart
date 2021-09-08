package com.w4eret1ckrtb1tch.focusstart.domain.model


import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Currencies(
    val date: String,
    val previousDate: String,
    val previousURL: String,
    val timeStamp: String,
    val currency: HashMap<String, Currency>
) : Serializable