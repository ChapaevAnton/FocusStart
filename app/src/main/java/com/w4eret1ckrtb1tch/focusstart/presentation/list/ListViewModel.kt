package com.w4eret1ckrtb1tch.focusstart.presentation.list

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency
import com.w4eret1ckrtb1tch.focusstart.domain.repository.CurrenciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class ListViewModel
@Inject constructor(
    private val repository: CurrenciesRepository
) : ViewModel() {

    private val currencies: MutableLiveData<List<Currency>> = MutableLiveData()
    private val date: MutableLiveData<String> = MutableLiveData()

    init {
        loadCurrencies()
    }

    fun getCurrencies(): LiveData<List<Currency>> = currencies
    fun getDate(): LiveData<String> = date

    @SuppressLint("CheckResult")
    private fun loadCurrencies() {
        repository.getCurrencies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    currencies.value = it.currency.values.toList()
                    date.value = dateTimeFormatter(it.date)
                },
                { error ->
                    Log.d("TAG", error.toString())
                })
    }

    private fun dateTimeFormatter(date: String): String {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val localDate =
            LocalDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        return localDate.format(formatter)
    }

}