package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class Airport(
    @SerializedName("id")
    val id: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("airport_name")
    val airportName: String,
    @SerializedName("city_code")
    val cityCode: String,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("city_slug")
    val citySlug: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("country_name")
    val countryName: String
)