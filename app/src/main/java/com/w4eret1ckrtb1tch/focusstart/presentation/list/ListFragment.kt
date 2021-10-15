package com.w4eret1ckrtb1tch.focusstart.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    @Inject lateinit var adapter:CurrenciesAdapter
    private val decorator by lazy { MarginsItemDecoration(5) }
    private val viewModel by viewModels<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.listener =
            OnItemClickListener { currency ->
                val action = ListFragmentDirections.actionOpenItem(currency)
                findNavController().navigate(action)
            }
        binding.listOfCurrencies.adapter = adapter
        binding.listOfCurrencies.addItemDecoration(decorator)
        binding.loadCurrencies.setOnClickListener { viewModel.loadCurrencies() }
        viewModel.getCurrencies()
            .observe(viewLifecycleOwner) { currencies ->
                adapter.submitList(currencies)
            }
        viewModel.getDate().observe(viewLifecycleOwner) { date ->
            binding.date.text = getString(R.string.title_date, date)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        adapter.listener = null
    }
}