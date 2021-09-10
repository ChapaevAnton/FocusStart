package com.w4eret1ckrtb1tch.focusstart.presentation.item

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor() : ViewModel() {

    private val currency: MutableLiveData<Currency> = MutableLiveData()
    private val deviationRate: MutableLiveData<Double> = MutableLiveData(0.0)
    private val amountCurrency: MutableLiveData<Double> = MutableLiveData(0.0)
    private var textWatcher: TextWatcher? = null

    fun getCurrency(): LiveData<Currency> = currency
    fun getDeviationRate(): LiveData<Double> = deviationRate
    fun getAmountCurrency(): LiveData<Double> = amountCurrency

    fun setCurrency(valueCurrency: Currency) {
        currency.value = valueCurrency
        deviationRate.value = valueCurrency.value - valueCurrency.previous
    }

    fun getTextWatcher(): TextWatcher? {
        if (textWatcher == null) {
            Log.d("TAG", "initTextWatcher: ok")
            textWatcher = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(input: CharSequence?, start: Int, before: Int, count: Int) {
                    input?.let {
                        if (it.isEmpty() || it.matches("^\\.".toRegex())) {
                            amountCurrency.value = 0.0
                        } else {
                            amountCurrency.value =
                                (it.toString().toDouble()) / currency.value!!.value
                        }
                    }
                }

                override fun afterTextChanged(input: Editable?) {}
            }
        }
        return textWatcher
    }

}