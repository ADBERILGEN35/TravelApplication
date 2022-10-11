package com.example.apptravel.adapter.guide

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.GuideItemHorizantalBinding
import com.example.apptravel.domain.model.AllTravelItem

class GuideHoriViewHolder(
    private val travelBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelBinding.root) {

    fun onBind(travalDataModel: AllTravelItem) {
        val binding = travelBinding as GuideItemHorizantalBinding

        binding.apply {
            setVariable(BR.allTravelModel, travalDataModel)
        }
    }
}