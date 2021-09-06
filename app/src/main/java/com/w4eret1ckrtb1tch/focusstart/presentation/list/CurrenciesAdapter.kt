package com.w4eret1ckrtb1tch.focusstart.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.w4eret1ckrtb1tch.focusstart.databinding.ValuteItemBinding
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency

class CurrenciesAdapter :
    ListAdapter<Currency, CurrenciesAdapter.CurrencyViewHolder>(CurrenciesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ValuteItemBinding.inflate(inflater, parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = getItem(position)
        holder.bind(currency)
    }

    class CurrencyViewHolder(private val binding: ValuteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: Currency) {
            with(binding) {
                charCode.text = currency.charCode
                name.text = currency.name
                nominal.text = currency.nominal.toString()
                numCode.text = currency.numCode
                previous.text = currency.previous.toString()
                value.text = currency.value.toString()
            }
        }
    }
}