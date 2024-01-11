package com.yusufarisoy.enuyguncase.domain.mapper

import com.yusufarisoy.enuyguncase.core.Mapper
import com.yusufarisoy.enuyguncase.data.entity.Data
import com.yusufarisoy.enuyguncase.data.entity.Destination
import com.yusufarisoy.enuyguncase.data.entity.Origin
import com.yusufarisoy.enuyguncase.domain.model.PlaceType
import com.yusufarisoy.enuyguncase.domain.model.PlaceUiModel
import com.yusufarisoy.enuyguncase.domain.model.SearchHeaderUiModel
import com.yusufarisoy.enuyguncase.ui.flightsearch.FlightSearchUiState
import javax.inject.Inject

class SearchResponseToUiStateMapper @Inject constructor(
    private val searchResponseToFlightUiModelMapper: SearchResponseToFlightUiModelMapper
) : Mapper<Data, FlightSearchUiState> {

    override fun map(input: Data): FlightSearchUiState {
        val headerUiModel = input.getSearchHeaderUiModel()
        val flights = searchResponseToFlightUiModelMapper.map(input)

        return FlightSearchUiState(headerUiModel, flights)
    }

    private fun Data.getSearchHeaderUiModel(): SearchHeaderUiModel {
        return SearchHeaderUiModel(
            origin = searchParameters.origin.toPlaceUiModel(),
            destination = searchParameters.destination.toPlaceUiModel(),
            departureDate = searchParameters.departureDate,
            passengerCount = searchParameters.passengerCount,
            isOneWay = searchParameters.isOneWay,
            returnDate = searchParameters.returnDate
        )
    }

    private fun Origin.toPlaceUiModel(): PlaceUiModel {
        return PlaceUiModel(
            type = PlaceType.ORIGIN,
            id = id,
            isCity = isCity,
            cityName = cityName,
            airportName = airportName,
            countryName = countryName
        )
    }

    private fun Destination.toPlaceUiModel(): PlaceUiModel {
        return PlaceUiModel(
            type = PlaceType.DESTINATION,
            id = id,
            isCity = isCity,
            cityName = cityName,
            airportName = airportName,
            countryName = countryName
        )
    }
}
