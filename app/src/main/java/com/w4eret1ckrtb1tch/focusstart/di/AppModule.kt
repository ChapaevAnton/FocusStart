package com.w4eret1ckrtb1tch.focusstart.di

import com.w4eret1ckrtb1tch.focusstart.data.dto.temp.ValuteResponse_
import com.w4eret1ckrtb1tch.focusstart.data.dto.temp.ValutesResponse_
import com.w4eret1ckrtb1tch.focusstart.data.mapper.ValutesMapperImpl
import com.w4eret1ckrtb1tch.focusstart.data.repository.ValutesRepositoryImpl
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.ValutesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.repository.ValutesRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Reusable
    abstract fun bindValutesRepository(valutesRepository: ValutesRepositoryImpl): ValutesRepository

    @Binds
    @Reusable
    abstract fun bindValutesMapper(
        valutesMapper: ValutesMapperImpl
    ): @JvmSuppressWildcards ValutesMapper<ValutesResponse_, ValuteResponse_>
}