package com.w4eret1ckrtb1tch.focusstart.data.repository

import com.w4eret1ckrtb1tch.focusstart.data.dto.temp.ValuteResponse_
import com.w4eret1ckrtb1tch.focusstart.data.dto.temp.ValutesResponse_
import com.w4eret1ckrtb1tch.focusstart.data.source.DailyApi
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.ValutesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.model.Valute
import com.w4eret1ckrtb1tch.focusstart.domain.repository.ValutesRepository
import io.reactivex.Single
import javax.inject.Inject

class ValutesRepositoryImpl
@Inject constructor(
    private val api: DailyApi,
    private val mapper: @JvmSuppressWildcards ValutesMapper<ValutesResponse_, ValuteResponse_>
) : ValutesRepository {

    override fun getValutes(): Single<List<Valute>> {
        return api.getValutes().map { mapper.map(it) }
    }
}