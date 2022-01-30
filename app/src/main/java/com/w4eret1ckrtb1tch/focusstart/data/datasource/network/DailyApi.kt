package com.w4eret1ckrtb1tch.focusstart.data.datasource.network

import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrenciesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface DailyApi {

    @GET("daily_json.js")
    fun getCurrencies(): Single<CurrenciesResponse>

    companion object {
        const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX"
        const val BASE_URL = "https://www.cbr-xml-daily.ru/"
    }
}