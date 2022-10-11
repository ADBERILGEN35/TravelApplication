package com.example.apptravel.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.apptravel.domain.model.Image

fun ImageView.loadUrl(image: String) {
    image.let {
        Glide.with(context)
            .load(image)
            .into(this)
    }
}

@BindingAdapter("android:downloadImage")
fun downloadImage(view: ImageView, image: List<Image>? = null) {
    image?.map {
        view.loadUrl(image.get(0).url)
    }
}

@BindingAdapter("android:downloadAll")
fun downloadAllImage(view: ImageView, images: List<Image>? = null) {
    images?.map {
        view.loadUrl(it.url)
    }
}


@BindingAdapter("android:downloadAll")
fun downloadTripImage(view: ImageView, images: List<Image>? = null) {
    images?.map {
        view.loadUrl(it.url)
    }
}