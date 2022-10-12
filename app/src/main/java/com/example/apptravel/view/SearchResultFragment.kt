package com.example.apptravel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apptravel.R
import com.example.apptravel.adapter.search.SearchHorizontalAdapter
import com.example.apptravel.adapter.search.SearchResultAdapter
import com.example.apptravel.databinding.FragmentSearchResultBinding
import com.example.apptravel.viewmodel.SearchFragmentViewModel
import com.example.apptravel.view.SearchResultFragmentArgs

class SearchResultFragment : Fragment() {
    private lateinit var binding: FragmentSearchResultBinding
    private val searchViewModel: SearchFragmentViewModel by viewModels()
    private var adapterHori: SearchResultAdapter = SearchResultAdapter(arrayListOf())
    private val args: SearchResultFragmentArgs by navArgs()
    private lateinit var searchText: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_search_result, container, false)
        binding.buttonBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        context?.let {

        }
        getSearch()
    }

    /**
     * Get search
     * search to searchText for city & description
     */
    private fun getSearch() {
        searchText = args.searchText
        searchViewModel.searchData(searchText).observe(viewLifecycleOwner) { searchList ->
            adapterHori.setTravelArrayList(searchList)
            val gridLayoutManager =
                GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
            binding.recyclerViewResultHorizantal.layoutManager = gridLayoutManager
            binding.recyclerViewResultHorizantal.adapter = adapterHori

        }

    }

}
