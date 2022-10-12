package com.example.apptravel.adapter.search

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.SearchItemHorizantalBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.view.SearchResultFragmentDirections

class SearchResultViewHolder(
    private val travelBinding: ViewDataBinding
) : RecyclerView.ViewHolder(travelBinding.root) {


    fun onBind(travalDataModel: AllTravelItem) {
        val binding = travelBinding as SearchItemHorizantalBinding

        binding.apply {
            setVariable(BR.allTravelModel, travalDataModel)
            imageLabel.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(SearchResultFragmentDirections.resultToDetail(travalDataModel))
            }
        }
    }

}