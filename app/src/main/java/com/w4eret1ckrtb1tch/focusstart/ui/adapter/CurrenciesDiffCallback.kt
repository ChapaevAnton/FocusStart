package com.w4eret1ckrtb1tch.focusstart.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.w4eret1ckrtb1tch.focusstart.domain.model.Rate

object CurrenciesDiffCallback : DiffUtil.ItemCallback<Rate>() {
    override fun areItemsTheSame(oldItem: Rate, newItem: Rate): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Rate, newItem: Rate): Boolean {
        return oldItem == newItem
    }

}