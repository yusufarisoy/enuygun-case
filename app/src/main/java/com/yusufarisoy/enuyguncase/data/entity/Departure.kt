package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class Departure(
    @SerializedName("enuid")
    val enuid: String,
    @SerializedName("price_breakdown")
    val priceBreakdown: PriceBreakdown,
    @SerializedName("average_price_breakdown")
    val averagePriceBreakdown: AveragePriceBreakdown,
    @SerializedName("infos")
    val infos: Infos,
    @SerializedName("provider_packages")
    val providerPackages: List<Any>,
    @SerializedName("segments")
    val segments: List<Segment>,
    @SerializedName("different_airline_count")
    val differentAirlineCount: Int
)