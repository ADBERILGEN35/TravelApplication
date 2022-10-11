package com.example.apptravel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.service.TravelApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookmarkViewModel : ViewModel() {
    private var _bookmarkValue = MutableLiveData<List<AllTravelItem>>()
    val bookmarkValue: LiveData<List<AllTravelItem>> = _bookmarkValue

    fun getBookmarkData(): LiveData<List<AllTravelItem>> {
        TravelApi.retrofitService.getAllList().enqueue(object : Callback<List<AllTravelItem>> {
            override fun onResponse(
                call: Call<List<AllTravelItem>>,
                response: Response<List<AllTravelItem>>
            ) {
                _bookmarkValue.value = response.body()?.filter { it.isBookmark == true }
            }

            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                println(t.message)
            }
        })
        return bookmarkValue
    }
}