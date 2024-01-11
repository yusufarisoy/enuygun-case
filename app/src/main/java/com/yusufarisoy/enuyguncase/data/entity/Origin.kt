package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class Origin(
    @SerializedName("label")
    val label: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_city")
    val isCity: Boolean,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("airport_name")
    val airportName: String,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("country_code")
    val countryCode: String
)