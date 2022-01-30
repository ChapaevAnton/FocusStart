package com.w4eret1ckrtb1tch.focusstart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.databinding.FragmentItemBinding
import com.w4eret1ckrtb1tch.focusstart.domain.model.Rate
import com.w4eret1ckrtb1tch.focusstart.presentation.viewmodel.ItemViewModel
import com.w4eret1ckrtb1tch.focusstart.utils.unsafeLazy
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigDecimal

@AndroidEntryPoint
class ItemFragment : Fragment(R.layout.fragment_item) {

    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ItemViewModel>()

    private val args: ItemFragmentArgs by navArgs()
    private val rate: Rate by lazy { args.rate }

    private val colorUp by unsafeLazy {
        ContextCompat.getColor(requireContext(), R.color.color_up)
    }
    private val colorDown by unsafeLazy {
        ContextCompat.getColor(requireContext(), R.color.color_down)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initListener()
    }

    private fun initListener() = with(binding) {
        evCash.addTextChangedListener(viewModel.getTextWatcher())
    }

    private fun initObserver() {
        viewModel.setCurrency(rate)
        viewModel.getCurrency().observe(viewLifecycleOwner) { bindRate(it) }
        viewModel.getDeviationRate().observe(viewLifecycleOwner) { bindDeviationRate(it) }
        viewModel.getAmountCurrency().observe(viewLifecycleOwner) { amount ->
            binding.tvAmountCurrency.text = getString(R.string.amount_currency, amount)
        }
    }

    private fun bindRate(rate: Rate) = with(binding) {
        tvName.text = rate.name
        tvNominal.text = getString(R.string.nominal, rate.nominal)
        tvValue.text = getString(R.string.value, rate.value)
        tvCharCode.text = rate.charCode
    }

    private fun bindDeviationRate(deviationRate: BigDecimal) = with(binding) {
        tvRate.text = getString(R.string.rate, deviationRate)
        tvRate.setTextColor(
            if (deviationRate >= BigDecimal(0)) {
                colorUp
            } else {
                colorDown
            }
        )
        ivRateArrow.setImageResource(
            if (deviationRate >= BigDecimal(0)) {
                R.drawable.ic_up
            } else {
                R.drawable.ic_down
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}