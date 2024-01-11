package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class Infos(
    @SerializedName("is_reservable")
    val isReservable: Boolean,
    @SerializedName("is_promo")
    val isPromo: Boolean,
    @SerializedName("duration")
    val duration: Duration,
    @SerializedName("baggage_info")
    val baggageInfo: BaggageInfo,
    @SerializedName("is_virtual_interlining")
    val isVirtualInterlining: Boolean,
    @SerializedName("is_business")
    val isBusiness: Boolean,
    @SerializedName("active_warning")
    val activeWarning: Any?,
    @SerializedName("is_mask_required")
    val isMaskRequired: Boolean
)