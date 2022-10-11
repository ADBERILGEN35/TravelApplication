package com.example.apptravel.adapter.search

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.SearchItemVerticalBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.view.SearchFragmentDirections

class SearchVerticalViewHolder(
    private val travelBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelBinding.root) {

    fun onBind(travalDataModel: AllTravelItem) {
        val binding = travelBinding as SearchItemVerticalBinding

        binding.apply {
            setVariable(BR.allTravelModel, travalDataModel)
            binding.searchVertical.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(SearchFragmentDirections.searchToDetail(travalDataModel))

            }
        }
    }
}