package com.example.apptravel.adapter.trip

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.TripItemBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.domain.room.Travel

class TripViewHolder(
    private val tripBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(tripBinding.root) {
    fun onBind(tripDataModel: AllTravelItem) {
        val binding = tripBinding as TripItemBinding

        binding.apply {

            setVariable(BR.allTripModel, tripDataModel)
            imageLabel.setOnClickListener {

            }


        }
    }
}