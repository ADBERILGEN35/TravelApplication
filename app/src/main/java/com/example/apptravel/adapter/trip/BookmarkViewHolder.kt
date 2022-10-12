package com.example.apptravel.adapter.trip

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.BookmarkItemBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.service.TravelApi
import com.example.apptravel.view.BookmarksFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookmarkViewHolder(
    private val bookmarkBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(bookmarkBinding.root) {
    fun onBind(bookmarkDataModel: AllTravelItem) {
        val binding = bookmarkBinding as BookmarkItemBinding

        binding.apply {
            setVariable(BR.allTravelModel, bookmarkDataModel)
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
                            }
                            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                                println(t.message)
                            }
                        })
                }
            }

        }
    }
}