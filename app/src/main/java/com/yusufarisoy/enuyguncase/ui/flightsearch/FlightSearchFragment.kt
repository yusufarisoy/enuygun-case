package com.yusufarisoy.enuyguncase.ui.flightsearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusufarisoy.enuyguncase.R
import com.yusufarisoy.enuyguncase.core.BaseFragment
import com.yusufarisoy.enuyguncase.databinding.FragmentFlightSearchBinding
import com.yusufarisoy.enuyguncase.domain.model.FlightPriceUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlightSearchFragment : BaseFragment() {

    private val viewModel: FlightSearchViewModel by viewModels()
    private lateinit var binding: FragmentFlightSearchBinding
    private lateinit var adapter: SearchItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlightSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerAdapter()
        observeStateFlow()
    }

    private fun initRecyclerAdapter() {
        adapter = SearchItemAdapter(onClicked = {})
        binding.recyclerSearchFlight.layoutManager = LinearLayoutManager(context)
        binding.recyclerSearchFlight.adapter = adapter
    }

    private fun observeStateFlow() {
        viewModel.stateFlow.collectIn { state ->
            state?.let { uiState ->
                binding.header = uiState.header
                adapter.setData(uiState.flights)
                initTabLayout(uiState.header.departureDate, uiState.flights.first().price)
            }
        }
    }

    private fun initTabLayout(departureDate: String, price: FlightPriceUiModel) {
        val before = context?.resources?.getString(R.string.tab_before, price.total, price.currency)
        val current = "$departureDate ${price.total}"
        val after = context?.resources?.getString(R.string.tab_before, price.total, price.currency)
        binding.tabLayoutDates.addTab(binding.tabLayoutDates.newTab().setText(before))
        binding.tabLayoutDates.addTab(binding.tabLayoutDates.newTab().setText(current))
        binding.tabLayoutDates.addTab(binding.tabLayoutDates.newTab().setText(after))
        binding.tabLayoutDates.getTabAt(1)?.select()
    }
}
