package com.example.apptravel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apptravel.R
import com.example.apptravel.adapter.started.TravelApiAdapter
import com.example.apptravel.databinding.FragmentFlightBinding
import com.example.apptravel.viewmodel.FlightViewModel

class FlightFragment : Fragment() {
    private lateinit var binding: FragmentFlightBinding
    private val viewModel: FlightViewModel by viewModels()
    private var adapter: TravelApiAdapter = TravelApiAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_flight,
            container, false
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        context?.let {

        }
        getFlightData()
    }


    private fun getFlightData() {
        viewModel.getTravelData().observe(viewLifecycleOwner) { travelValue ->
            adapter.setTravelArrayList(travelValue)
            val gridLayoutManager =
                GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            binding.recyclerView.layoutManager = gridLayoutManager
            binding.recyclerView.adapter = adapter
        }
    }


}

