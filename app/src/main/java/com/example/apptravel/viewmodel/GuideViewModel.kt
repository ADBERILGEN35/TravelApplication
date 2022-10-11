package com.example.apptravel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.domain.model.GuideCategoryItem
import com.example.apptravel.service.TravelApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuideViewModel : ViewModel() {
    private var _mightValue = MutableLiveData<List<AllTravelItem>>()
    private var _topPickValue = MutableLiveData<List<AllTravelItem>>()
    private var _categoryItem = MutableLiveData<List<GuideCategoryItem>>()
    val mightValue: LiveData<List<AllTravelItem>> = _mightValue
    val topPickValue: LiveData<List<AllTravelItem>> = _topPickValue
    val categoryItem: LiveData<List<GuideCategoryItem>> = _categoryItem

    fun getMightData(): LiveData<List<AllTravelItem>> {
        TravelApi.retrofitService.getAllList().enqueue(object : Callback<List<AllTravelItem>> {
            override fun onResponse(
                call: Call<List<AllTravelItem>>,
                response: Response<List<AllTravelItem>>
            ) {
                _mightValue.value = response.body()?.filter { it.category == "mightneed" }
            }

            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mightValue
    }

    fun getTopPickData(): LiveData<List<AllTravelItem>> {
        TravelApi.retrofitService.getAllList().enqueue(object : Callback<List<AllTravelItem>> {
            override fun onResponse(
                call: Call<List<AllTravelItem>>,
                response: Response<List<AllTravelItem>>
            ) {
                _topPickValue.value = response.body()?.filter { it.category == "toppick" }
            }

            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return topPickValue
    }

    fun getCategory(): LiveData<List<GuideCategoryItem>> {
        TravelApi.retrofitService.getCategories()
            .enqueue(object : Callback<List<GuideCategoryItem>> {
                override fun onResponse(
                    call: Call<List<GuideCategoryItem>>,
                    response: Response<List<GuideCategoryItem>>
                ) {
                    _categoryItem.value = response.body()
                }

                override fun onFailure(call: Call<List<GuideCategoryItem>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        return categoryItem
    }


}