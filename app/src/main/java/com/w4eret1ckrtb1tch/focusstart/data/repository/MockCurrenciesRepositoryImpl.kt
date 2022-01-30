package com.w4eret1ckrtb1tch.focusstart.data.repository

import android.content.Context
import com.google.gson.Gson
import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrenciesResponse
import com.w4eret1ckrtb1tch.focusstart.data.dto.RateDto
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.CurrenciesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currencies
import com.w4eret1ckrtb1tch.focusstart.domain.repository.CurrenciesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.File
import javax.inject.Inject

class MockCurrenciesRepositoryImpl @Inject constructor(
    private val mapper: @JvmSuppressWildcards CurrenciesMapper<CurrenciesResponse, RateDto>,
    private val gson: Gson,
    @ApplicationContext
    private val context: Context
) : CurrenciesRepository {

    override fun getCurrencies(): Single<Currencies> =
        Single.just(getCurrenciesMock())
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())

    private fun getCurrenciesMock(): Currencies {
        val file = File("data.json")
        val reader = context.assets.open(file.name).bufferedReader().use { it.readText() }
        val currenciesResponse = gson.fromJson(reader, CurrenciesResponse::class.java)
        return mapper.map(currenciesResponse)
    }

}

