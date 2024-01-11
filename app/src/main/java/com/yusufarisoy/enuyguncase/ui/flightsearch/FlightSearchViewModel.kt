package com.yusufarisoy.enuyguncase.ui.flightsearch

import com.yusufarisoy.enuyguncase.core.BaseViewModel
import com.yusufarisoy.enuyguncase.core.secureLaunch
import com.yusufarisoy.enuyguncase.data.repository.ApiRepository
import com.yusufarisoy.enuyguncase.domain.mapper.SearchResponseToUiStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FlightSearchViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val mapper: SearchResponseToUiStateMapper
) : BaseViewModel() {

    private val _stateFlow: MutableStateFlow<FlightSearchUiState?> = MutableStateFlow(null)
    val stateFlow: StateFlow<FlightSearchUiState?>
        get() = _stateFlow.asStateFlow()

    init {
        search()
    }

    private fun search() {
        secureLaunch {
            val state = withContext(Dispatchers.IO) {
                val response = repository.search()
                mapper.map(response)
            }
            _stateFlow.emit(state)
        }
    }
}
