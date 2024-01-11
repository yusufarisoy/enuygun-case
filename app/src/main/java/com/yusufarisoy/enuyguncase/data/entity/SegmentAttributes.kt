package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class SegmentAttributes(
    @SerializedName("free_meal")
    val freeMeal: Boolean,
    @SerializedName("seat_pitch")
    val seatPitch: String?,
    @SerializedName("airplane_brand")
    val airplaneBrand: String?,
    @SerializedName("entertainment")
    val entertainment: String?,
    @SerializedName("wifi")
    val wifi: Int?,
    @SerializedName("seat_plan")
    val seatPlan: String?
)