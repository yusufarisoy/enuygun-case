package com.yusufarisoy.enuyguncase.ui.flightsearch

import com.yusufarisoy.enuyguncase.domain.model.FlightUiModel
import com.yusufarisoy.enuyguncase.domain.model.SearchHeaderUiModel

data class FlightSearchUiState(
    val header: SearchHeaderUiModel,
    val flights: List<FlightUiModel>
)
