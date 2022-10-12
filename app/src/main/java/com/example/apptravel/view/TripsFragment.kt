package com.example.apptravel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apptravel.R
import com.example.apptravel.adapter.trip.TripsAdapter
import com.example.apptravel.databinding.FragmentTripsBinding
import com.example.apptravel.domain.room.Travel
import com.example.apptravel.domain.room.TravelDatabase


class TripsFragment : Fragment() {
    private lateinit var binding: FragmentTripsBinding
    private var adapter: TripsAdapter = TripsAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_trips,
            container,
            false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        context?.let {

            getDatabaseData()

        }
    }

    private fun getDatabaseData() {
        val travelDatabase: TravelDatabase? =
            TravelDatabase.getTravelDatabase(requireContext())

        val list: ArrayList<Travel> = travelDatabase?.travelDao()
            ?.getAllTravel() as ArrayList<Travel>


        adapter.setDatabaseArrayList(list)
        val gridLayoutManager =
            GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
        binding.recyclerViewTrips.layoutManager = gridLayoutManager
        binding.recyclerViewTrips.adapter = adapter
        println(list)
    }
}


/*
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
                if (isBookmark == true) {
                }
            }

            override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                println(t.message)
            }
        })*/
