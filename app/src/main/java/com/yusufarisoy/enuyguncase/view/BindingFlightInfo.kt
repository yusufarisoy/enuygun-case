package com.yusufarisoy.enuyguncase.view

import android.content.Context
import android.text.style.ImageSpan
import android.widget.TextView
import androidx.core.text.buildSpannedString
import androidx.core.text.inSpans
import androidx.databinding.BindingAdapter
import com.yusufarisoy.enuyguncase.R

@BindingAdapter("oneWay", "passengerCount")
fun TextView.setInfoText(oneWay: Boolean?, passengerCount: Int?) {
    if (oneWay != null && passengerCount != null) {
        text = buildInfoText(context, oneWay, passengerCount)
    }
}

private fun buildInfoText(context: Context, oneWay: Boolean, passengerCount: Int) = buildSpannedString {
    if (oneWay) append(context.resources.getString(R.string.text_one_way))
    inSpans(ImageSpan(context, R.drawable.ic_person)) {
        append(" ")
    }
    append(passengerCount.toString())
}
