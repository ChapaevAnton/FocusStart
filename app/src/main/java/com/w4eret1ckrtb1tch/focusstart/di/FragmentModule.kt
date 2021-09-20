package com.w4eret1ckrtb1tch.focusstart.di

import android.content.Context
import com.w4eret1ckrtb1tch.focusstart.presentation.list.CurrenciesAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {

    @Provides
    @FragmentScoped
    fun provideCurrenciesAdapter(@ActivityContext context: Context): CurrenciesAdapter {
        return CurrenciesAdapter(context)
    }

}