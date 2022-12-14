package com.example.apptravel.adapter.guide

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.GuideItemVerticalBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.view.GuideFragmentDirections

class GuideVerticalViewHolder(
    private val travelBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelBinding.root) {

    fun onBind(travalDataModel: AllTravelItem) {
        val binding = travelBinding as GuideItemVerticalBinding

        binding.apply {
            setVariable(BR.allTravelModel, travalDataModel)
            guideVertiImg.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(GuideFragmentDirections.guideToDetail(travalDataModel))

            }
        }
    }
}