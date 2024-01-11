package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("search_parameters")
    val searchParameters: SearchParameters,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("airlines")
    val airlines: List<Airline>,
    @SerializedName("airports")
    val airports: List<Airport>,
    @SerializedName("stop_counts")
    val stopCounts: List<Int>,
    @SerializedName("baggages")
    val baggages: List<Int>,
    @SerializedName("filter_boundaries")
    val filterBoundaries: FilterBoundaries,
    @SerializedName("has_vi_flight")
    val hasViFlight: Boolean,
    @SerializedName("info_message")
    val infoMessage: Any?,
    @SerializedName("search_url")
    val searchUrl: String,
    @SerializedName("short_search_url")
    val shortSearchUrl: String,
    @SerializedName("currencies")
    val currencies: Currencies,
    @SerializedName("bus_search_data_tab")
    val busSearchDataTab: Any?,
    @SerializedName("flights")
    val flights: Flights,
    @SerializedName("price_history")
    val priceHistory: PriceHistory
)