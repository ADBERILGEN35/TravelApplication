package com.example.apptravel.service

import android.media.Image
import com.example.apptravel.domain.model.AllTravelItem
import retrofit2.Call
import retrofit2.http.*

interface TravelApiService {

    @GET("AllTravelList")
    fun getAllList(): Call<List<AllTravelItem>>

    @GET("AllPhotoList")
    fun getPhotos(): Call<List<Image>>


    @FormUrlEncoded
    @PUT("AllTravelList/{id}")
    fun putBookmark(
        @Path("id") id: String,
        @Field("isBookmark") isBookmark: Boolean
    ): Call<List<AllTravelItem>>
}