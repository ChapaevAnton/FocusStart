package com.w4eret1ckrtb1tch.focusstart.domain.model

import java.io.Serializable

data class Currency(
    val charCode: String,
    val id: String,
    val name: String,
    val nominal: Int,
    val numCode: String,
    val previous: Double,
    val value: Double
) : Serializable
