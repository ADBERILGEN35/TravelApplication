package com.example.apptravel.adapter.started

import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.BR
import com.example.apptravel.databinding.StartedRecyclerItemBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.travelguideapplication.view.StartedFragmentDirections


class TravelApiViewHolder(
    private val travelBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(travelBinding.root) {

    fun onBind(travelDataModel: AllTravelItem) {
        val binding = travelBinding as StartedRecyclerItemBinding

        binding.apply {
            setVariable(BR.allTravelModel, travelDataModel)
            startedRecycler.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(StartedFragmentDirections.startedToDetail(travelDataModel))

            }

        }
    }
}