package com.example.apptravel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apptravel.R
import com.example.apptravel.adapter.search.SearchHorizontalAdapter
import com.example.apptravel.adapter.search.SearchVerticalAdapter
import com.example.apptravel.databinding.FragmentSearchBinding
import com.example.apptravel.viewmodel.SearchFragmentViewModel
import com.example.travelguideapplication.view.SearchFragmentDirections

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    private val searchViewModel: SearchFragmentViewModel by viewModels()
    private var adapterVertical: SearchVerticalAdapter = SearchVerticalAdapter(arrayListOf())
    private var adapterHori: SearchHorizontalAdapter = SearchHorizontalAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search,
            container,
            false
        )
        binding.textInputEditTextSearch.setOnClickListener {
            var text = binding.textInputEditTextSearch.text
            val action = SearchFragmentDirections.searchToResult(text.toString())
            binding.textInputEditTextSearch.text.clear()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
        }
        init()
    }

    private fun init() {
        context?.let {

        }
        getTopDestination()
        getNearby()
    }


    private fun getTopDestination() {
        searchViewModel.getTopDestinationData().observe(viewLifecycleOwner) { topDestination ->
            adapterVertical.setTravelArrayList(topDestination)
            val gridLayoutManager =
                GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            binding.recyclerView.layoutManager = gridLayoutManager
            binding.recyclerView.adapter = adapterVertical
        }
    }

    private fun getNearby() {
        searchViewModel.getNearbyData().observe(viewLifecycleOwner) { nearbyData ->
            adapterHori.setTravelArrayList(nearbyData)
            val gridLayoutManager =
                GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            binding.recyclerViewHorizantal.layoutManager = gridLayoutManager
            binding.recyclerViewHorizantal.adapter = adapterHori
        }
    }


}

