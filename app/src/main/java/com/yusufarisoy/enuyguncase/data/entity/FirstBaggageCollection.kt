package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class FirstBaggageCollection(
    @SerializedName("paxType")
    val paxType: String,
    @SerializedName("allowance")
    val allowance: Int,
    @SerializedName("part")
    val part: Int,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("small")
    val small: Boolean
)