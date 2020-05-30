package com.contest.moviex.base

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Manish Kumar
 */

@BindingAdapter("app:imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(imageView.context).load(imageUrl).into(imageView)
    }
}
@BindingAdapter("app:imageUrl", "app:placeholder")
fun loadImage(imageView: ImageView, imageUrl: String?, placeholder: Drawable) {
        Glide.with(imageView.context).load(imageUrl).placeholder(placeholder).error(placeholder)
            .into(imageView)
}