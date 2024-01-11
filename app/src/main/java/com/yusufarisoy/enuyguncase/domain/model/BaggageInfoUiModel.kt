package com.yusufarisoy.enuyguncase.domain.model

data class BaggageInfoUiModel(
    val type: BaggageType,
    val allowance: Int,
    val unit: String
)

enum class BaggageType{
    CARRY_ON,
    BAGGAGE
}
