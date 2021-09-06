package com.w4eret1ckrtb1tch.focusstart.data.dto

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @field:SerializedName("CharCode")
    val charCode: String,

    @field:SerializedName("ID")
    val id: String,

    @field:SerializedName("Name")
    val name: String,

    @field:SerializedName("Nominal")
    val nominal: Int,

    @field:SerializedName("NumCode")
    val numCode: String,

    @field:SerializedName("Previous")
    val previous: Double,

    @field:SerializedName("Value")
    val value: Double
)