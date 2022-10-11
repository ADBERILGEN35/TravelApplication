package com.example.apptravel.adapter.guide

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.GuideItemHorizantalBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.service.TravelApi
import com.example.apptravel.view.GuideFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuideHoriViewHolder(
    private val travelBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelBinding.root) {

    fun onBind(travalDataModel: AllTravelItem) {
        val binding = travelBinding as GuideItemHorizantalBinding

        binding.apply {
            setVariable(BR.allTravelModel, travalDataModel)
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
            guideHoriImg.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(GuideFragmentDirections.guideToDetail(travalDataModel))
            }
        }
    }
}