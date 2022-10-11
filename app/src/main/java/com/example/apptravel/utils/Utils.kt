package com.example.apptravel.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.apptravel.domain.model.GuideCategoryItem
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
        view.loadUrl(image[0].url)
    }
}


@BindingAdapter("android:downloadDrawble")
fun downloadDrawble(view: ImageView, image: GuideCategoryItem? = null) {

    if (image != null) {
        view.loadUrl(image.icon)
    }
}




