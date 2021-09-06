package com.w4eret1ckrtb1tch.focusstart.presentation.list

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w4eret1ckrtb1tch.focusstart.domain.model.Valute
import com.w4eret1ckrtb1tch.focusstart.domain.repository.ValutesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ListViewModel
@Inject constructor(
    private val repository: ValutesRepository
) : ViewModel() {

    private val valutes: MutableLiveData<List<Valute>> = MutableLiveData()

    init {
        loadValutes()
    }

    fun getValutes(): LiveData<List<Valute>> = valutes

    @SuppressLint("CheckResult")
    private fun loadValutes() {
        repository.getValutes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    valutes.value = it
                },
                { error ->
                    Log.e("Error", error.toString())
                })
    }

}