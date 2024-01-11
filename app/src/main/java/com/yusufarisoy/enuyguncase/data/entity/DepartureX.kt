package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class DepartureX(
    @SerializedName("previous_day_price")
    val previousDayPrice: Int,
    @SerializedName("next_day_price")
    val nextDayPrice: Int
)