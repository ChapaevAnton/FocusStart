package com.w4eret1ckrtb1tch.focusstart.data.mapper

import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrenciesResponse
import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrencyResponse
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.CurrenciesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency
import javax.inject.Inject

class CurrenciesMapperImpl
@Inject constructor() :
    CurrenciesMapper<@JvmSuppressWildcards CurrenciesResponse, @JvmSuppressWildcards CurrencyResponse> {

    override fun map(currencies: CurrenciesResponse): List<Currency> {
        return currencies.currency.values.map { map(it) }
    }

    override fun map(currency: CurrencyResponse): Currency {
        return with(currency) {
            Currency(charCode, id, name, nominal, numCode, previous, value)
        }
    }
}