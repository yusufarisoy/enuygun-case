package com.yusufarisoy.enuyguncase.domain.mapper

import com.yusufarisoy.enuyguncase.core.Mapper
import com.yusufarisoy.enuyguncase.core.orZero
import com.yusufarisoy.enuyguncase.data.entity.Airport
import com.yusufarisoy.enuyguncase.data.entity.CarryOn
import com.yusufarisoy.enuyguncase.data.entity.Data
import com.yusufarisoy.enuyguncase.data.entity.FirstBaggageCollection
import com.yusufarisoy.enuyguncase.data.entity.PriceBreakdown
import com.yusufarisoy.enuyguncase.data.entity.Segment
import com.yusufarisoy.enuyguncase.domain.model.AirlineUiModel
import com.yusufarisoy.enuyguncase.domain.model.AirportUiModel
import com.yusufarisoy.enuyguncase.domain.model.BaggageInfoUiModel
import com.yusufarisoy.enuyguncase.domain.model.BaggageType
import com.yusufarisoy.enuyguncase.domain.model.DateTimeType
import com.yusufarisoy.enuyguncase.domain.model.DateTimeUiModel
import com.yusufarisoy.enuyguncase.domain.model.FlightPriceUiModel
import com.yusufarisoy.enuyguncase.domain.model.FlightUiModel
import javax.inject.Inject

class SearchResponseToFlightUiModelMapper @Inject constructor() : Mapper<Data, List<FlightUiModel>> {

    override fun map(input: Data): List<FlightUiModel> {
        val flights = input.flights.departure.map { flight ->
            val segment = flight.segments.firstOrNull()
            val airline = input.airlines.find { airline ->
                airline.code == segment?.operatingAirline
            }
            val originAirport = input.airports.find { it.id == segment?.origin }
            val destinationAirport = input.airports.find { it.id == segment?.destination }
            val baggage = flight.infos.baggageInfo.firstBaggageCollection?.first()
            val departureTime = segment.getDepartureDateTimeUiModel()
            val arrivalTime = segment.getArrivalDateTimeUiModel()
            flight.infos.baggageInfo.carryOn

            FlightUiModel(
                enuid = flight.enuid,
                airline = AirlineUiModel(
                    code = airline?.code.orEmpty(),
                    name = airline?.name.orEmpty(),
                    image = airline?.image.orEmpty()
                ),
                originAirport = originAirport.toAirportUiModel(isOrigin = true),
                destinationAirport = destinationAirport.toAirportUiModel(),
                price = flight.priceBreakdown.toFlightPriceUiModel(),
                baggageInfo = getBaggageInfoUiModels(flight.infos.baggageInfo.carryOn, baggage),
                departureTime = departureTime,
                arrivalTime = arrivalTime,
                displayArrivalDateTime = segment?.displayArrivalDatetime.orEmpty(),
                availableSeats = segment?.availableSeats.orZero(),
                differentAirlineCount = flight.differentAirlineCount
            )
        }

        return flights
    }

    private fun PriceBreakdown.toFlightPriceUiModel(): FlightPriceUiModel {
        return FlightPriceUiModel(
            total = total,
            base = base,
            tax = tax,
            service = service,
            discount = discount,
            currency = currency // TODO: Can match with the currencies and convert if needed
        )
    }

    private fun getBaggageInfoUiModels(
        carryOn: CarryOn,
        baggage: FirstBaggageCollection?
    ): List<BaggageInfoUiModel> {
        val items = mutableListOf(
            BaggageInfoUiModel(
                type = BaggageType.CARRY_ON,
                allowance = carryOn.allowance,
                unit = carryOn.unit
            )
        )
        if (baggage != null) {
            items.add(
                BaggageInfoUiModel(
                    type = BaggageType.BAGGAGE,
                    allowance = baggage.allowance,
                    unit = baggage.unit
                )
            )
        }

        return items
    }

    private fun Airport?.toAirportUiModel(isOrigin: Boolean = false): AirportUiModel {
        return AirportUiModel(
            code = this?.id.orEmpty(),
            isOrigin = isOrigin,
            name = this?.airportName.orEmpty(),
            cityName = this?.cityName.orEmpty(),
            countryCode = this?.countryCode.orEmpty()
        )
    }

    private fun Segment?.getDepartureDateTimeUiModel(): DateTimeUiModel {
        return DateTimeUiModel(
            type = DateTimeType.DEPARTURE,
            date = this?.departureDatetime?.date.orEmpty(),
            time = this?.departureDatetime?.time.orEmpty()
        )
    }

    private fun Segment?.getArrivalDateTimeUiModel(): DateTimeUiModel {
        return DateTimeUiModel(
            type = DateTimeType.ARRIVAL,
            date = this?.arrivalDatetime?.date.orEmpty(),
            time = this?.arrivalDatetime?.time.orEmpty()
        )
    }
}
