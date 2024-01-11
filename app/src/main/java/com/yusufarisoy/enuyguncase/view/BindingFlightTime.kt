package com.yusufarisoy.enuyguncase.view

import android.content.Context
import android.text.style.ImageSpan
import android.text.style.RelativeSizeSpan
import android.view.Gravity
import android.widget.TextView
import androidx.core.text.buildSpannedString
import androidx.core.text.inSpans
import androidx.databinding.BindingAdapter
import com.yusufarisoy.enuyguncase.R

@BindingAdapter("departure", "arrival")
fun TextView.setFlightTimeText(departure: String?, arrival: String?) {
    if (departure != null && arrival != null) {
        text = buildFlightTimeText(context, departure, arrival)
    }
}

private fun buildFlightTimeText(context: Context, departureTime: String, arrivalTime: String) = buildSpannedString {
    inSpans(RelativeSizeSpan(1.1f)) {
        append(departureTime)
    }
    append(" ")
    inSpans(ImageSpan(context, R.drawable.ic_arrow_right)) {
        append(" ")
    }
    append(arrivalTime)
}
