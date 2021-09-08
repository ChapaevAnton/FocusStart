package com.w4eret1ckrtb1tch.focusstart.presentation.item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor() : ViewModel() {

    private var currency: MutableLiveData<Currency> = MutableLiveData()

    fun getCurrency(): LiveData<Currency> = currency

    fun setCurrency(currency: Currency) {
        this.currency.value = currency
    }

}