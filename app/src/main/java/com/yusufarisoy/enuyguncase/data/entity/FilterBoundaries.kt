package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class FilterBoundaries(
    @SerializedName("departurePrice")
    val departurePrice: DeparturePrice,
    @SerializedName("returnPrice")
    val returnPrice: ReturnPrice,
    @SerializedName("departureMaxDuration")
    val departureMaxDuration: Int,
    @SerializedName("returnMaxDuration")
    val returnMaxDuration: Int
)