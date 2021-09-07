package com.w4eret1ckrtb1tch.focusstart.domain.model


import java.io.Serializable

data class Currencies(
    val date: String,
    val previousDate: String,
    val previousURL: String,
    val timeStamp: String,
    val currency: HashMap<String, Currency>
) : Serializable