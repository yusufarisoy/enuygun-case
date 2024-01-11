package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class PriceHistory(
    @SerializedName("departure")
    val departure: DepartureX
)