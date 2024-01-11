package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class BaggageInfo(
    @SerializedName("carryOn")
    val carryOn: CarryOn,
    @SerializedName("firstBaggageCollection")
    val firstBaggageCollection: List<FirstBaggageCollection>?
)