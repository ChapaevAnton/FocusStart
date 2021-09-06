package com.w4eret1ckrtb1tch.focusstart.data.mapper

import com.w4eret1ckrtb1tch.focusstart.data.dto.ValuteResponse
import com.w4eret1ckrtb1tch.focusstart.data.dto.ValutesResponse
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.ValutesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.model.Valute
import javax.inject.Inject

class ValutesMapperImpl
@Inject constructor() : ValutesMapper<@JvmSuppressWildcards ValutesResponse, @JvmSuppressWildcards ValuteResponse> {

    override fun map(items: ValutesResponse): List<Valute> {
        return items.valute.map { map(it) }
    }

    override fun map(valute: ValuteResponse): Valute {
        return with(valute) {
            Valute(charCode, id, name, nominal, numCode, previous, value)
        }
    }
}