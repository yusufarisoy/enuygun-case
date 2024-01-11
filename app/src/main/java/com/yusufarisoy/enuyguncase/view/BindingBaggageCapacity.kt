package com.yusufarisoy.enuyguncase.view

import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.yusufarisoy.enuyguncase.R
import com.yusufarisoy.enuyguncase.domain.model.BaggageInfoUiModel
import com.yusufarisoy.enuyguncase.domain.model.BaggageType

@BindingAdapter("baggageInfoList")
fun TextView.setBaggageCapacityText(baggageInfoList: List<BaggageInfoUiModel>?) {
    if (!baggageInfoList.isNullOrEmpty()) {
        val baggage = baggageInfoList.last()
        val baggageCapacityText = if (baggage.type == BaggageType.CARRY_ON) {
            context.resources.getString(R.string.text_carry_on)
        } else {
            context.resources.getString(R.string.text_baggage, baggage.allowance, baggage.unit)
        }
        val icon = if (baggage.type == BaggageType.CARRY_ON) {
            ResourcesCompat.getDrawable(context.resources, R.drawable.ic_handbag, null)
        } else {
            ResourcesCompat.getDrawable(context.resources, R.drawable.ic_baggage, null)
        }

        text = baggageCapacityText
        setCompoundDrawablesRelativeWithIntrinsicBounds(icon, null, null, null)
    }
}
