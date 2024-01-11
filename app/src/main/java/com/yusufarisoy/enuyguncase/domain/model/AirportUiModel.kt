package com.yusufarisoy.enuyguncase.domain.model

data class AirportUiModel(
    val code: String,
    val isOrigin: Boolean,
    val name: String,
    val cityName: String,
    val countryCode: String
)
