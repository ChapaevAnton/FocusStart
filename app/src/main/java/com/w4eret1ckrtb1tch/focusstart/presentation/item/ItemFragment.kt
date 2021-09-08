package com.w4eret1ckrtb1tch.focusstart.presentation.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.databinding.FragmentItemBinding
import com.w4eret1ckrtb1tch.focusstart.domain.model.Currency
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemFragment : Fragment(R.layout.fragment_item) {

    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ItemViewModel>()
    private val args: ItemFragmentArgs by navArgs()
    private lateinit var currency: Currency

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currency = args.currency
        viewModel.setCurrency(currency)

        viewModel.getCurrency().observe(viewLifecycleOwner) { currency ->
            with(binding) {
                name.text = currency.name
                nominal.text = getString(R.string.nominal, currency.nominal)
                value.text = getString(R.string.value, currency.value)
                charCode.text = currency.charCode
            }
        }
        viewModel.getRate().observe(viewLifecycleOwner) { rate ->
            binding.rate.text = getString(R.string.rate, rate)
        }

        viewModel.getSum().observe(viewLifecycleOwner) { sum ->
            binding.sum.text = getString(R.string.sum, sum)
        }

        binding.cash.addTextChangedListener(onTextChanged = { text, start, count, after ->
            text?.let {
                if (it.isNotEmpty())
                    viewModel.setSum(it.toString().toDouble()) else viewModel.setSum(0.0)
            }
        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}