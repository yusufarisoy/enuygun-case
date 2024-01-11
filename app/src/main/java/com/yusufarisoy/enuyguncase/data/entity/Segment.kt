package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class Segment(
    @SerializedName("departure_datetime")
    val departureDatetime: DepartureDatetime,
    @SerializedName("display_departure_datetime")
    val displayDepartureDatetime: String,
    @SerializedName("arrival_datetime")
    val arrivalDatetime: ArrivalDatetime,
    @SerializedName("display_arrival_datetime")
    val displayArrivalDatetime: String,
    @SerializedName("class")
    val classX: String,
    @SerializedName("flight_number")
    val flightNumber: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("destination")
    val destination: String,
    @SerializedName("marketing_airline")
    val marketingAirline: String,
    @SerializedName("operating_airline")
    val operatingAirline: String,
    @SerializedName("available_seats")
    val availableSeats: Int,
    @SerializedName("origin_terminal")
    val originTerminal: String?,
    @SerializedName("destination_terminal")
    val destinationTerminal: String?,
    @SerializedName("segment_delay")
    val segmentDelay: SegmentDelay?,
    @SerializedName("duration")
    val duration: Duration,
    @SerializedName("is_train")
    val isTrain: Boolean,
    @SerializedName("segment_attributes")
    val segmentAttributes: SegmentAttributes,
    @SerializedName("is_virtual_interlining")
    val isVirtualInterlining: Boolean
)