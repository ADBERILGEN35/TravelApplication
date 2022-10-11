package com.example.apptravel.adapter.search

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.SearchItemHorizantalBinding
import com.example.apptravel.domain.model.AllTravelItem

class SearchHorizantalViewHolder(
    private val travelBinding: ViewDataBinding

) : RecyclerView.ViewHolder(travelBinding.root) {

    fun onBind(travalDataModel: AllTravelItem) {
        val binding = travelBinding as SearchItemHorizantalBinding
        binding.apply {
            setVariable(BR.allTravelModel, travalDataModel)
            setVariable(BR.searchHorizontalAdapter, travalDataModel)
            binding.bookmark.setOnClickListener {
/*
                sharedPreferenceManager.saveUSer(allTravelModel)
                println(sharedPreferenceManager.getUser())
*/
            }
        }
    }
}