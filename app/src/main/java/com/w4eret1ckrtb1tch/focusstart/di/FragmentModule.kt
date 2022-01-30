package com.w4eret1ckrtb1tch.focusstart.di

import androidx.recyclerview.widget.ListAdapter
import com.w4eret1ckrtb1tch.focusstart.domain.model.Rate
import com.w4eret1ckrtb1tch.focusstart.ui.adapter.CurrenciesAdapter
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class FragmentModule {

    @Binds
    @Reusable
    abstract fun bindCurrenciesAdapter(
        currenciesAdapter: CurrenciesAdapter
    ): ListAdapter<Rate, CurrenciesAdapter.CurrencyViewHolder>

}