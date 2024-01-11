package com.yusufarisoy.enuyguncase.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("url")
fun ImageView.loadImage(url: String?) {
    url?.let {
        val formattedUrl = fixUrlFormat(it)
        Glide.with(context).load(formattedUrl).into(this)
    }
}

private fun fixUrlFormat(originalUrl: String): String {
    return originalUrl.replace("\\/", "/")
}
