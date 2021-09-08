package com.w4eret1ckrtb1tch.focusstart.presentation.list

import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency

fun interface OnItemClickListener {

    fun onItemClick(currency: Currency)
}