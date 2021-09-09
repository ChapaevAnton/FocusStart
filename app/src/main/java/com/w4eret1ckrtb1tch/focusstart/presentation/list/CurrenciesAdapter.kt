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

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CurrencyItemBinding.inflate(inflater, parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = getItem(position)
        holder.bind(currency, listener)
    }

    class CurrencyViewHolder(private val binding: CurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: Currency, listener: OnItemClickListener?) {
            val deviationRate = (currency.value - currency.previous)
            with(binding) {
                charCode.text = currency.charCode
                name.text = currency.name
                rate.text = String.format("( %.4f ₽)", deviationRate)
                value.text = String.format("%.4f ₽", currency.value)
                rateArrow.setImageResource(if (deviationRate >= 0) R.drawable.ic_up else R.drawable.ic_down)
                root.setOnClickListener {
                    listener?.onItemClick(currency)
                }
            }
        }
    }
}