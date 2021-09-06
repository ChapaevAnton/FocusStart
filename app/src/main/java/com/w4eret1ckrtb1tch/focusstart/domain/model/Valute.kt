package com.w4eret1ckrtb1tch.focusstart.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

//"ID": "R01010",
//"NumCode": "036",
//"CharCode": "AUD",
//"Nominal": 1,
//"Name": "Австралийский доллар",
//"Value": 54.1527,
//"Previous": 53.8136

data class Valute(
    val id: String,
    val numCode: Int,
    val charCode: String,
    val nominal: Int,
    val name: String,
    val value: Double,
    val previous: Double
) : Serializable
