package com.w4eret1ckrtb1tch.focusstart.presentation.list


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.w4eret1ckrtb1tch.focusstart.databinding.ValuteItemBinding
import com.w4eret1ckrtb1tch.focusstart.domain.model.Valute

class ValutesAdapter : ListAdapter<Valute, ValutesAdapter.ValuteViewHolder>(ValutesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ValuteItemBinding.inflate(inflater, parent, false)
        return ValuteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ValuteViewHolder, position: Int) {
        val valute = getItem(position)
        holder.bind(valute)
    }

    class ValuteViewHolder(private val binding: ValuteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(valute: Valute) {
            with(binding) {
                name.text = valute.name
                charCode.text = valute.charCode
                numCode.text = valute.numCode.toString()
                nominal.text = valute.nominal.toString()
                value.text = valute.value.toString()
                previous.text = valute.previous.toString()
            }
        }
    }
}