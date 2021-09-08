package com.w4eret1ckrtb1tch.focusstart.presentation.item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.Executors
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor() : ViewModel() {

    private var currency: MutableLiveData<Currency> = MutableLiveData()
    private var rate: MutableLiveData<Double> = MutableLiveData()
    private var sum: MutableLiveData<Double> = MutableLiveData()

    init {
        sum.value = 0.0
        rate.value = 0.0
    }

    fun getCurrency(): LiveData<Currency> = currency
    fun getRate(): LiveData<Double> = rate
    fun getSum(): LiveData<Double> = sum

    fun setCurrency(valueCurrency: Currency) {
        Executors.newSingleThreadExecutor().execute {
            currency.postValue(valueCurrency)
            rate.postValue(valueCurrency.value - valueCurrency.previous)
        }
    }

    fun setSum(valueSum: Double) {
        Executors.newSingleThreadExecutor().execute {
            val currency = currency.value!!
            sum.postValue(valueSum / currency.value)
        }
    }

}