package com.yusufarisoy.enuyguncase.domain.model

data class SearchHeaderUiModel(
    val origin: PlaceUiModel,
    val destination: PlaceUiModel,
    val departureDate: String,
    val passengerCount: Int,
    val isOneWay: Boolean,
    val returnDate: String?
)
