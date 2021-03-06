package com.w4eret1ckrtb1tch.focusstart.domain.repository

import com.w4eret1ckrtb1tch.focusstart.domain.model.Currencies
import io.reactivex.Single

interface CurrenciesRepository {

    fun getCurrencies(): Single<Currencies>
}