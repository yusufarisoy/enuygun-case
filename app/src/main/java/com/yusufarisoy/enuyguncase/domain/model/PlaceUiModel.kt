package com.yusufarisoy.enuyguncase.domain.model

data class PlaceUiModel(
    val type: PlaceType,
    val id: String,
    val isCity: Boolean,
    val cityName: String,
    val airportName: String,
    val countryName: String
)

enum class PlaceType {
    ORIGIN,
    DESTINATION
}
