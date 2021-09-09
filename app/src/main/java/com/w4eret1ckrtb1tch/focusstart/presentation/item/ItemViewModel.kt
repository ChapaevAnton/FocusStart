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
    private var deviationRate: MutableLiveData<Double> = MutableLiveData(0.0)
    private var amountCurrency: MutableLiveData<Double> = MutableLiveData(0.0)

    fun getCurrency(): LiveData<Currency> = currency
    fun getDeviationRate(): LiveData<Double> = deviationRate
    fun getAmountCurrency(): LiveData<Double> = amountCurrency

    fun setCurrency(valueCurrency: Currency) {
        currency.value = valueCurrency
        deviationRate.value = valueCurrency.value - valueCurrency.previous
    }

    fun setAmountCurrency(cash: Double) {
        val currency = currency.value!!
        amountCurrency.value = cash / currency.value
    }

}