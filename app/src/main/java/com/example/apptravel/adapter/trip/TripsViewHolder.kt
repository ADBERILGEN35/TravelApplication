package com.example.apptravel.adapter.trip

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.TripItemBinding
import com.example.apptravel.domain.room.Travel
import com.example.apptravel.domain.room.TravelDatabase

class TripsViewHolder(
    private val tripsBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(tripsBinding.root) {
    fun onBind(tripsDataModel: Travel) {
        val binding = tripsBinding as TripItemBinding

        binding.apply {
            setVariable(BR.allTripModel, tripsDataModel)
            imageButtonDelete.setOnClickListener {
                val travelDatabase: TravelDatabase = TravelDatabase.getTravelDatabase(it.context)!!
                var travel: Travel? = allTripModel
                if (travel != null) {
                    travelDatabase.travelDao().delete(travel)
                }
            }
        }
    }
}
