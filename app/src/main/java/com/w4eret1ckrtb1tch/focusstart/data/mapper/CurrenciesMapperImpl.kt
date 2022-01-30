package com.w4eret1ckrtb1tch.focusstart.data.mapper

import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrenciesResponse
import com.w4eret1ckrtb1tch.focusstart.data.dto.RateDto
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.CurrenciesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currencies
import com.w4eret1ckrtb1tch.focusstart.domain.model.Rate
import javax.inject.Inject

class CurrenciesMapperImpl @Inject constructor() :
    CurrenciesMapper<@JvmSuppressWildcards CurrenciesResponse, @JvmSuppressWildcards RateDto> {

    override fun map(currencies: CurrenciesResponse): Currencies =
        Currencies(
            date = currencies.date,
            previousDate = currencies.previousDate,
            previousURL = currencies.previousURL,
            timeStamp = currencies.timeStamp,
            rate = currencies.rate.mapValues { map(it.value) }.toMap(HashMap())
        )

    override fun map(rate: RateDto): Rate =
        Rate(
            charCode = rate.charCode,
            id = rate.id,
            name = rate.name,
            nominal = rate.nominal,
            numCode = rate.numCode,
            previous = rate.previous,
            value = rate.value
        )
}