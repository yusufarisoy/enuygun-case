package com.yusufarisoy.enuyguncase.domain.model

data class FlightPriceUiModel(
    val total: Double,
    val base: Double,
    val tax: Double,
    val service: Double,
    val discount: Int,
    val currency: String
)
