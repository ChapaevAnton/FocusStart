package com.w4eret1ckrtb1tch.focusstart.presentation.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w4eret1ckrtb1tch.focusstart.domain.model.Rate
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor() : ViewModel() {

    private val rate: MutableLiveData<Rate> = MutableLiveData()
    private val deviationRate: MutableLiveData<BigDecimal> = MutableLiveData(BigDecimal(0.0))
    private val amountCurrency: MutableLiveData<BigDecimal> = MutableLiveData(BigDecimal(0.0))
    private var textWatcher: TextWatcher? = null

    fun getCurrency(): LiveData<Rate> = rate
    fun getDeviationRate(): LiveData<BigDecimal> = deviationRate
    fun getAmountCurrency(): LiveData<BigDecimal> = amountCurrency

    fun setCurrency(valueRate: Rate) {
        rate.value = valueRate
        deviationRate.value = valueRate.value - valueRate.previous
    }

    fun getTextWatcher(): TextWatcher? {
        if (textWatcher == null) {
            Log.d("TAG", "initTextWatcher: ok")
            textWatcher = object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    input: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    input?.let {
                        if (it.isEmpty() || it.matches("^\\.".toRegex())) {
                            amountCurrency.value = BigDecimal(0.0)
                        } else {
                            amountCurrency.value =
                                (it.toString().toBigDecimal()) / rate.value!!.value
                        }
                    }
                }

                override fun afterTextChanged(input: Editable?) {}
            }
        }
        return textWatcher
    }

}