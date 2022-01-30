package com.w4eret1ckrtb1tch.focusstart.di

import com.w4eret1ckrtb1tch.focusstart.data.dto.CurrenciesResponse
import com.w4eret1ckrtb1tch.focusstart.data.dto.RateDto
import com.w4eret1ckrtb1tch.focusstart.data.mapper.CurrenciesMapperImpl
import com.w4eret1ckrtb1tch.focusstart.data.repository.CurrenciesRepositoryImpl
import com.w4eret1ckrtb1tch.focusstart.data.repository.MockCurrenciesRepositoryImpl
import com.w4eret1ckrtb1tch.focusstart.domain.mapper.CurrenciesMapper
import com.w4eret1ckrtb1tch.focusstart.domain.repository.CurrenciesRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Reusable
    @CurrentRepository
    abstract fun bindCurrenciesRepository(currenciesRepository: CurrenciesRepositoryImpl): CurrenciesRepository

    @Binds
    @Reusable
    abstract fun bindMockCurrenciesRepository(currenciesRepository: MockCurrenciesRepositoryImpl): CurrenciesRepository

    @Binds
    @Reusable
    abstract fun bindCurrenciesMapper(
        currenciesMapper: CurrenciesMapperImpl
    ): @JvmSuppressWildcards CurrenciesMapper<CurrenciesResponse, RateDto>
}

@Qualifier
annotation class CurrentRepository
