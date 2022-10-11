package com.example.apptravel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.service.TravelApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransportationsViewModel: ViewModel() {
    private var _travalValue = MutableLiveData<List<AllTravelItem>>()
    val travelValue: LiveData<List<AllTravelItem>> = _travalValue

    fun getTravelData(): LiveData<List<AllTravelItem>> {
        TravelApi.retrofitService.getAllList().enqueue(object : Callback<List<AllTravelItem>> {
            override fun onResponse(
                call: Call<List<AllTravelItem>>,
                response: Response<List<AllTravelItem>>
            ) {
                _travalValue.value = response.body()
                    ?.filter { it.category == "transportations" || it.category == "transportation"}

            }

            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                println(t.message)
            }
        })
        return travelValue
    }
}