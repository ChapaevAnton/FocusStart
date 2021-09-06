package com.w4eret1ckrtb1tch.focusstart.domain.mapper

import com.w4eret1ckrtb1tch.focusstart.domain.model.Valute

interface ValutesMapper<in LIST, in VALUTE> {

    fun map(items: LIST): List<Valute>

    fun map(valute: VALUTE): Valute
}