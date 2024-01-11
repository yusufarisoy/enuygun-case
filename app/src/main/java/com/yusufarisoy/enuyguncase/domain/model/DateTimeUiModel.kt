package com.yusufarisoy.enuyguncase.domain.model

data class DateTimeUiModel(
    val type: DateTimeType,
    val date: String,
    val time: String
)

enum class DateTimeType {
    DEPARTURE,
    ARRIVAL
}
