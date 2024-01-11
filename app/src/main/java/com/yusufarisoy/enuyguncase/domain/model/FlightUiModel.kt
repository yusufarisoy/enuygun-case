package com.yusufarisoy.enuyguncase.domain.model

data class FlightUiModel(
    val enuid: String,
    val airline: AirlineUiModel,
    val originAirport: AirportUiModel,
    val destinationAirport: AirportUiModel,
    val price: FlightPriceUiModel,
    val baggageInfo: List<BaggageInfoUiModel>,
    val departureTime: DateTimeUiModel,
    val arrivalTime: DateTimeUiModel,
    val displayArrivalDateTime: String,
    val availableSeats: Int,
    val differentAirlineCount: Int
) {

    val isDirect: Boolean
        get() = differentAirlineCount == 1

    val directionText: String
        get() = "${originAirport.code} > ${destinationAirport.code}"
}
