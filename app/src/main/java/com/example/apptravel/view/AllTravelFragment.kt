package com.example.apptravel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apptravel.R
import com.example.apptravel.adapter.started.TravelApiAdapter
import com.example.apptravel.databinding.FragmentAllTravelBinding
import com.example.apptravel.viewmodel.AllTravelViewModel

class AllTravelFragment : Fragment() {
    private lateinit var binding: FragmentAllTravelBinding
    private val startedFragmentViewModel: AllTravelViewModel by viewModels()

    private var adapter: TravelApiAdapter = TravelApiAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_all_travel,
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

        }
        getTravelData()
    }

    /**
     * Get travel data
     * getAllTravelList()
     */
    private fun getTravelData() {
        startedFragmentViewModel.getTravelData().observe(viewLifecycleOwner) { travelValue ->
            adapter.setTravelArrayList(travelValue)
            val gridLayoutManager =
                GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            binding.recyclerView.layoutManager = gridLayoutManager
            binding.recyclerView.adapter = adapter
        }
    }


}