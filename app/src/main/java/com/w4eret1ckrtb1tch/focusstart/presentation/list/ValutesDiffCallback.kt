package com.w4eret1ckrtb1tch.focusstart.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.w4eret1ckrtb1tch.focusstart.domain.model.Valute

object ValutesDiffCallback : DiffUtil.ItemCallback<Valute>() {
    override fun areItemsTheSame(oldItem: Valute, newItem: Valute): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Valute, newItem: Valute): Boolean {
        return oldItem == newItem
    }

}