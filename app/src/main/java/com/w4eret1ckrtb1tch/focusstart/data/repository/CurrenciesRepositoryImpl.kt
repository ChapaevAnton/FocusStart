package com.w4eret1ckrtb1tch.focusstart.data.repository

import com.w4eret1ckrtb1tch.focusstart.data.network.DailyApi
import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrenciesResponse
import com.w4eret1ckrtb1tch.focusstart.data.dto.RateDto
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.CurrenciesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currencies
import com.w4eret1ckrtb1tch.focusstart.domain.repository.CurrenciesRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CurrenciesRepositoryImpl
@Inject constructor(
    private val api: DailyApi,
    private val mapper: @JvmSuppressWildcards CurrenciesMapper<CurrenciesResponse, RateDto>
) : CurrenciesRepository {

    override fun getCurrencies(): Single<Currencies> =
        api.getCurrencies()
            .map { mapper.map(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}