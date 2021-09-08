package com.w4eret1ckrtb1tch.focusstart.domain.model

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Currency(
    val charCode: String,
    val id: String,
    val name: String,
    val nominal: Int,
    val numCode: String,
    val previous: Double,
    var value: Double
) : Serializable
