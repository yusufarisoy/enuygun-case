package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class Flights(
    @SerializedName("departure")
    val departure: List<Departure>
)