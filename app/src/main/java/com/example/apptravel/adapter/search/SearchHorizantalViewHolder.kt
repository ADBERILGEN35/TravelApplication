package com.example.apptravel.adapter.search

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.SearchItemHorizantalBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.service.TravelApi
import com.example.apptravel.view.SearchFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchHorizantalViewHolder(
    private val travelBinding: ViewDataBinding

) : RecyclerView.ViewHolder(travelBinding.root) {

    fun onBind(travalDataModel: AllTravelItem) {
        val binding = travelBinding as SearchItemHorizantalBinding
        binding.apply {
            setVariable(BR.allTravelModel, travalDataModel)
            setVariable(BR.searchHorizontalAdapter, travalDataModel)
            bookmark.setOnClickListener {
                val id = allTravelModel?.id
                var isBookmark = allTravelModel?.isBookmark
                isBookmark = isBookmark != true
                if (id != null) {
                    TravelApi.retrofitService.putBookmark(id, isBookmark)
                        .enqueue(object : Callback<List<AllTravelItem>> {
                            override fun onResponse(
                                call: Call<List<AllTravelItem>>,
                                response: Response<List<AllTravelItem>>
                            ) {
                                if (isBookmark == true) {
                                }
                            }

                            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                                println(t.message)
                            }
                        })
                }
            }
            imageLabel.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(SearchFragmentDirections.searchToDetail(travalDataModel))
            }
        }

    }
}

