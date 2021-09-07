package com.w4eret1ckrtb1tch.focusstart.data.repository

import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrenciesResponse
import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrencyResponse
import com.w4eret1ckrtb1tch.focusstart.data.source.DailyApi
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.CurrenciesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currencies
import com.w4eret1ckrtb1tch.focusstart.domain.repository.CurrenciesRepository
import io.reactivex.Single
import javax.inject.Inject

class CurrenciesRepositoryImpl
@Inject constructor(
    private val api: DailyApi,
    private val mapper: @JvmSuppressWildcards CurrenciesMapper<CurrenciesResponse, CurrencyResponse>
) : CurrenciesRepository {

    override fun getCurrencies(): Single<Currencies> {
        return api.getCurrencies().map { mapper.map(it) }
    }
}