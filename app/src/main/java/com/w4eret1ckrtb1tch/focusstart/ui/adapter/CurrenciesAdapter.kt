package com.w4eret1ckrtb1tch.focusstart.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.databinding.CurrencyItemBinding
import com.w4eret1ckrtb1tch.focusstart.domain.model.Rate
import java.math.BigDecimal


class CurrenciesAdapter(private val onRateClickListener: (rate: Rate) -> Unit) :
    ListAdapter<Rate, CurrenciesAdapter.CurrencyHolder>(CurrenciesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder =
        CurrencyHolder.create(parent, onRateClickListener)

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CurrencyHolder private constructor(
        private val binding: CurrencyItemBinding,
        onRateClickListener: (rate: Rate) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var model: Rate

        init {
            itemView.setOnClickListener {
                onRateClickListener.invoke(model)
            }
        }

        fun bind(rate: Rate) {
            model = rate
            val deviationRate = (model.value - model.previous)
            with(binding) {
                tvCharCode.text = model.charCode
                tvName.text = model.name
                tvRate.text = itemView.context.getString(R.string.rate, deviationRate)
                tvValue.text = itemView.context.getString(R.string.value, rate.value)
                ivRateArrow.setImageResource(if (deviationRate >= BigDecimal(0)) R.drawable.ic_up else R.drawable.ic_down)
            }
        }

        companion object {

            fun create(
                parent: ViewGroup,
                onRateClickListener: (rate: Rate) -> Unit
            ): CurrencyHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = CurrencyItemBinding.inflate(inflater, parent, false)
                return CurrencyHolder(binding, onRateClickListener)
            }
        }
    }
}