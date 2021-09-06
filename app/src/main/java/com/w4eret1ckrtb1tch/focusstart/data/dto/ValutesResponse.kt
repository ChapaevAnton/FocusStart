package com.w4eret1ckrtb1tch.focusstart.data.dto

import com.google.gson.annotations.SerializedName
import com.w4eret1ckrtb1tch.focusstart.data.dto.temp.ValuteResponse_

data class ValutesResponse(
    @field:SerializedName("Date")
    val date: String,

    @field:SerializedName("PreviousDate")
    val previousDate: String,

    @field:SerializedName("PreviousURL")
    val previousURL: String,

    @field:SerializedName("Timestamp")
    val timeStamp: String,

    @field:SerializedName("Valute")
    val valute: List<ValuteResponse> = emptyList()
)