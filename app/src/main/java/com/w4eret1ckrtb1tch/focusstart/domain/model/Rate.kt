package com.w4eret1ckrtb1tch.focusstart.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.math.BigInteger

@Parcelize
data class Rate(
    val charCode: String,
    val id: String,
    val name: String,
    val nominal: BigInteger,
    val numCode: String,
    val previous: BigDecimal,
    var value: BigDecimal
) : Parcelable
