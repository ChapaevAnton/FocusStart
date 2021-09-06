package com.w4eret1ckrtb1tch.focusstart.data.source

import com.w4eret1ckrtb1tch.focusstart.data.dto.ValutesResponse
import com.w4eret1ckrtb1tch.focusstart.data.dto.temp.ValutesResponse_
import io.reactivex.Single
import retrofit2.http.GET

interface DailyApi {

    @GET("daily_json.js")
    fun getValutes(): Single<ValutesResponse_>


}