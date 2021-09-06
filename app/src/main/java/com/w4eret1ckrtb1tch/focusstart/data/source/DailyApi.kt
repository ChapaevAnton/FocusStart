package com.w4eret1ckrtb1tch.focusstart.data.source

import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrenciesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface DailyApi {

    @GET("daily_json.js")
    fun getCurrencies(): Single<CurrenciesResponse>


}