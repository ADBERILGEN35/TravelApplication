package com.example.apptravel.service

import com.example.apptravel.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TravelApi {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: TravelApiService by lazy {
        retrofit.create(TravelApiService::class.java)
    }
}