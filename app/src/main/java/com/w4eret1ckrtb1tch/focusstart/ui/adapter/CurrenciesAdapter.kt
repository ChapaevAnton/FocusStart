package com.w4eret1ckrtb1tch.focusstart.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.databinding.CurrencyItemBinding
import com.w4eret1ckrtb1tch.focusstart.domain.model.Rate
import com.w4eret1ckrtb1tch.focusstart.ui.fragment.OnItemClickListener
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped
import java.math.BigDecimal
import javax.inject.Inject

@FragmentScoped
class CurrenciesAdapter @Inject constructor(
    @ApplicationContext
    private val context: Context
) :
    ListAdapter<Rate, CurrenciesAdapter.CurrencyViewHolder>(CurrenciesDiffCallback) {

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

    inner class CurrencyViewHolder(private val binding: CurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(rate: Rate, listener: OnItemClickListener?) {
            val deviationRate = (rate.value - rate.previous)
            with(binding) {
                charCode.text = rate.charCode
                name.text = rate.name
                this.rate.text = context.getString(R.string.rate, deviationRate)
                value.text = context.getString(R.string.value, rate.value)
                rateArrow.setImageResource(if (deviationRate >= BigDecimal(0)) R.drawable.ic_up else R.drawable.ic_down)
                root.setOnClickListener {
                    listener?.onItemClick(rate)
                }
            }
        }
    }
}