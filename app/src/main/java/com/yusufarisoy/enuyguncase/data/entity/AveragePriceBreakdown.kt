package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class AveragePriceBreakdown(
    @SerializedName("base")
    val base: Double,
    @SerializedName("tax")
    val tax: Double,
    @SerializedName("service")
    val service: Double,
    @SerializedName("reissue_service")
    val reissueService: Int,
    @SerializedName("total")
    val total: Double,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("displayed_currency")
    val displayedCurrency: String,
    @SerializedName("internal_assurance")
    val internalAssurance: Int,
    @SerializedName("extra_fee")
    val extraFee: Int,
    @SerializedName("penalty")
    val penalty: Int
)