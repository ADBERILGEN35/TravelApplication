package com.example.apptravel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.domain.model.Image
import com.example.apptravel.service.TravelApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragmentViewModel : ViewModel() {
    private var _topDestinationValue = MutableLiveData<List<AllTravelItem>>()
    private var _nearbyValue = MutableLiveData<List<AllTravelItem>>()
    private var _searchList = MutableLiveData<List<AllTravelItem>>()
    val topDestinationValue: LiveData<List<AllTravelItem>> = _topDestinationValue
    val nearbyValue: LiveData<List<AllTravelItem>> = _nearbyValue
    val searchValue: LiveData<List<AllTravelItem>> = _searchList
    private var _images = MutableLiveData<List<List<Image>>>()
    val images: LiveData<List<List<Image>>> = _images


    fun getTopDestinationData(): LiveData<List<AllTravelItem>> {
        TravelApi.retrofitService.getAllList().enqueue(object : Callback<List<AllTravelItem>> {
            override fun onResponse(
                call: Call<List<AllTravelItem>>,
                response: Response<List<AllTravelItem>>
            ) {
                _topDestinationValue.value = response.body()
                    ?.filter { it.category == "topdestination" || it.category == "topdestinations" }
            }

            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                println(t.message)
            }

        })
        return topDestinationValue
    }

    fun getNearbyData(): LiveData<List<AllTravelItem>> {
        TravelApi.retrofitService.getAllList().enqueue(object : Callback<List<AllTravelItem>> {
            override fun onResponse(
                call: Call<List<AllTravelItem>>,
                response: Response<List<AllTravelItem>>
            ) {
                _nearbyValue.value = response.body()?.filter { it.category == "nearby" }
            }

            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                println(t.message)
            }
        })
        return nearbyValue
    }


    /**
     * Search data
     *
     * @param searchText
     * search to searchText title & description & category || lowercase
     * @return searchValue
     */
    fun searchData(searchText: String): LiveData<List<AllTravelItem>> {
        TravelApi.retrofitService.getAllList().enqueue(object : Callback<List<AllTravelItem>> {
            override fun onResponse(
                call: Call<List<AllTravelItem>>,
                response: Response<List<AllTravelItem>>
            ) {

                _searchList.value = response.body()?.filter {
                    it.title.lowercase()
                        .contains(searchText.lowercase()) || it.description.lowercase()
                        .contains(searchText.lowercase()) || it.category.lowercase()
                        .contains(searchText.lowercase())
                }
            }

            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                println(t.message)
            }

        })
        return searchValue
    }


}