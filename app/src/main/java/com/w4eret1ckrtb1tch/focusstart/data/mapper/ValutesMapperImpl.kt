package com.w4eret1ckrtb1tch.focusstart.data.mapper

import com.w4eret1ckrtb1tch.focusstart.data.dto.temp.ValuteResponse_
import com.w4eret1ckrtb1tch.focusstart.data.dto.temp.ValutesResponse_
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.ValutesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.model.Valute
import javax.inject.Inject

class ValutesMapperImpl
@Inject constructor() :
    ValutesMapper<@JvmSuppressWildcards ValutesResponse_, @JvmSuppressWildcards ValuteResponse_> {

    override fun map(items: ValutesResponse_): List<Valute> {
        return listOf(map(items.valute))
    }

    override fun map(valute: ValuteResponse_): Valute {
        return with(valute.aMD) {
            Valute(id, numCode, charCode, nominal, name, value, previous)
        }
    }
}