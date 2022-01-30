package com.w4eret1ckrtb1tch.focusstart.domain.mapper

import com.w4eret1ckrtb1tch.focusstart.domain.model.Currencies
import com.w4eret1ckrtb1tch.focusstart.domain.model.Rate

interface CurrenciesMapper<in CURRENCIES, in RATE> {

    fun map(currencies: CURRENCIES): Currencies

    fun map(rate: RATE): Rate
}