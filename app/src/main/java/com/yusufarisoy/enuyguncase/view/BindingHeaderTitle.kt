package com.yusufarisoy.enuyguncase.view

import android.content.Context
import android.text.style.ImageSpan
import android.widget.TextView
import androidx.core.text.buildSpannedString
import androidx.core.text.inSpans
import androidx.databinding.BindingAdapter
import com.yusufarisoy.enuyguncase.R

@BindingAdapter("origin", "destination")
fun TextView.setTitleText(origin: String?, destination: String?) {
    if (origin != null && destination != null) {
        text = buildTitleText(context, origin, destination)
    }
}

private fun buildTitleText(context: Context, origin: String, destination: String) = buildSpannedString {
    append(origin)
    inSpans(ImageSpan(context, R.drawable.ic_arrow_right)) {
        append(" ")
    }
    append(destination)
}
