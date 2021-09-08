package com.w4eret1ckrtb1tch.focusstart.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.databinding.CurrencyItemBinding

import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency

class CurrenciesAdapter :
    ListAdapter<Currency, CurrenciesAdapter.CurrencyViewHolder>(CurrenciesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CurrencyItemBinding.inflate(inflater, parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = getItem(position)
        holder.bind(currency)
    }

    class CurrencyViewHolder(private val binding: CurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: Currency) {
            val rate = (currency.value - currency.previous)
            with(binding) {
                charCode.text = currency.charCode
                name.text = currency.name
                previous.text = String.format("( %.4f ₽)", rate)
                value.text = String.format("%.4f ₽", currency.value)
                rates.setImageResource(if (rate >= 0) R.drawable.ic_up else R.drawable.ic_down)
            }
        }
    }
}