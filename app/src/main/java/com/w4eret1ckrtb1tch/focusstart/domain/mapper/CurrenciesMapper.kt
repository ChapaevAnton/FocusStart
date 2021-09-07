package com.w4eret1ckrtb1tch.focusstart.domain.mapper

import com.w4eret1ckrtb1tch.focusstart.domain.model.Currencies
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency

interface CurrenciesMapper<in CURRENCIES, in CURRENCY> {

    fun map(currencies: CURRENCIES): Currencies

    fun map(currency: CURRENCY): Currency
}