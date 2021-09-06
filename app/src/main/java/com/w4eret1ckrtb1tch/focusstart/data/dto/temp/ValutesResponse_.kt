package com.w4eret1ckrtb1tch.focusstart.data.dto.temp

import com.google.gson.annotations.SerializedName

data class ValutesResponse_ (

	@field:SerializedName("Date") val date : String,
	@field:SerializedName("PreviousDate") val previousDate : String,
	@field:SerializedName("PreviousURL") val previousURL : String,
	@field:SerializedName("Timestamp") val timeStamp : String,
	@field:SerializedName("Valute") val valute : ValuteResponse_
)