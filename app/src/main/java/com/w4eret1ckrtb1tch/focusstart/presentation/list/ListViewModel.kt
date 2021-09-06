package com.w4eret1ckrtb1tch.focusstart.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w4eret1ckrtb1tch.focusstart.domain.model.Valute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel
@Inject constructor(

) : ViewModel() {

    private val valutes: MutableLiveData<List<Valute>> = MutableLiveData()
    fun getValutes(): LiveData<List<Valute>> = valutes

}