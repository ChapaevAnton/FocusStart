package com.w4eret1ckrtb1tch.focusstart.domain.repository

import com.w4eret1ckrtb1tch.focusstart.domain.model.Valute
import io.reactivex.Single

interface ValutesRepository {

    fun getValutes(): Single<List<Valute>>
}