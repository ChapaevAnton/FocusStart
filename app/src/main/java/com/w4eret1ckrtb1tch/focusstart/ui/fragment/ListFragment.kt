package com.w4eret1ckrtb1tch.focusstart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.databinding.FragmentListBinding
import com.w4eret1ckrtb1tch.focusstart.presentation.viewmodel.ListViewModel
import com.w4eret1ckrtb1tch.focusstart.ui.adapter.CurrenciesAdapter
import com.w4eret1ckrtb1tch.focusstart.ui.adapter.MarginsItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        CurrenciesAdapter { rate ->
            val action = ListFragmentDirections.actionOpenItem(rate)
            findNavController().navigate(action)
        }
    }
    private val decorator by lazy(LazyThreadSafetyMode.NONE) {
        MarginsItemDecoration(MARGIN_RATE_ITEM)
    }
    private val viewModel by viewModels<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
        initObserver()
    }

    private fun initView() = with(binding) {
        rvListCurrencies.adapter = adapter
        rvListCurrencies.addItemDecoration(decorator)
    }

    private fun initListener() = with(binding) {
        loadCurrenciesButton.setOnClickListener { viewModel.loadCurrencies() }
    }

    private fun initObserver() = with(binding) {
        viewModel.getCurrencies()
            .observe(viewLifecycleOwner) { currencies ->
                adapter.submitList(currencies)
            }
        viewModel.getDate().observe(viewLifecycleOwner) { date ->
            tvDate.text = getString(R.string.title_date, date)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val MARGIN_RATE_ITEM = 5
    }
}