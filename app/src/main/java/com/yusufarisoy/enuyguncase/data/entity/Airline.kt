package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class Airline(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("image")
    val image: String
)