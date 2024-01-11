package com.yusufarisoy.enuyguncase.data.entity

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data")
    val `data`: Data
)