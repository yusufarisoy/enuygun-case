package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class SearchParameters(
    @SerializedName("request_id")
    val requestId: String,
    @SerializedName("provider")
    val provider: Any?,
    @SerializedName("origin")
    val origin: Origin,
    @SerializedName("destination")
    val destination: Destination,
    @SerializedName("origins")
    val origins: List<Origin>,
    @SerializedName("destinations")
    val destinations: List<Destination>,
    @SerializedName("departure_dates")
    val departureDates: List<String>,
    @SerializedName("departure_date")
    val departureDate: String,
    @SerializedName("display_departure_date")
    val displayDepartureDate: String,
    @SerializedName("display_departure_dates")
    val displayDepartureDates: List<String>,
    @SerializedName("return_date")
    val returnDate: String?,
    @SerializedName("display_return_date")
    val displayReturnDate: Any?,
    @SerializedName("adult")
    val adult: Int,
    @SerializedName("senior")
    val senior: Int,
    @SerializedName("student")
    val student: Int,
    @SerializedName("child")
    val child: Int,
    @SerializedName("infant")
    val infant: Int,
    @SerializedName("passenger_count")
    val passengerCount: Int,
    @SerializedName("passenger_servisable_count")
    val passengerServisableCount: Int,
    @SerializedName("version")
    val version: Int,
    @SerializedName("is_one_way")
    val isOneWay: Boolean,
    @SerializedName("is_domestic")
    val isDomestic: Boolean,
    @SerializedName("is_direct")
    val isDirect: Boolean,
    @SerializedName("is_refundable")
    val isRefundable: Boolean,
    @SerializedName("flight_class")
    val flightClass: String
)