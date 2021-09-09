package com.w4eret1ckrtb1tch.focusstart.presentation.item

import android.text.Editable
import android.text.TextWatcher
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
    private var inputCash: MutableLiveData<String> = MutableLiveData()

    fun getCurrency(): LiveData<Currency> = currency
    fun getDeviationRate(): LiveData<Double> = deviationRate
    fun getAmountCurrency(): LiveData<Double> = amountCurrency
    fun getInputCash(): LiveData<String> = inputCash

    fun setCurrency(valueCurrency: Currency) {
        currency.value = valueCurrency
        deviationRate.value = valueCurrency.value - valueCurrency.previous
    }

    fun getTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(input: CharSequence?, p1: Int, p2: Int, p3: Int) {
                input?.let {
                    if (it.isEmpty() || it.matches("^\\.".toRegex())) {
                        amountCurrency.value = 0.0
                    } else
                        amountCurrency.value = (it.toString().toDouble()) / currency.value!!.value
                }
            }

            override fun afterTextChanged(input: Editable?) {
                input?.toString()?.let {

                    if (it.matches("^\\.".toRegex())) {
                        amountCurrency.value = 0.0
                        inputCash.value = "0."
                    }
                }
            }
        }
    }

}