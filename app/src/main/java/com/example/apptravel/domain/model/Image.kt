package com.example.apptravel.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val altText: String,
    val height: Int,
    val isHeroImage: Boolean,
    val url: String,
    val width: Int
) : Parcelable