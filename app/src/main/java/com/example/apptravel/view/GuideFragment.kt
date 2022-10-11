package com.example.apptravel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apptravel.R
import com.example.apptravel.adapter.guide.CategoryAdapter
import com.example.apptravel.adapter.guide.GuideHoriAdapter
import com.example.apptravel.adapter.guide.GuideVerticalAdapter
import com.example.apptravel.databinding.FragmentGuideBinding
import com.example.apptravel.viewmodel.GuideViewModel

class GuideFragment : Fragment() {
    private lateinit var binding: FragmentGuideBinding
    private val viewModel: GuideViewModel by viewModels()
    private var adapterVertical: GuideVerticalAdapter = GuideVerticalAdapter(arrayListOf())
    private var adapterHori: GuideHoriAdapter = GuideHoriAdapter(arrayListOf())
    private var adapterCategory: CategoryAdapter = CategoryAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_guide, container, false
        )
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
            getMight()
            getTopPick()
            getCategory()
        }

    }

    private fun getMight() {
        viewModel.getMightData().observe(viewLifecycleOwner) { mighList ->
            adapterVertical.setTravelArrayList(mighList)
            val gridLayoutManager =
                GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            binding.recyclerView.layoutManager = gridLayoutManager
            binding.recyclerView.adapter = adapterVertical
        }
    }

    private fun getTopPick() {
        viewModel.getTopPickData().observe(viewLifecycleOwner) { topPickList ->
            adapterHori.setTravelArrayList(topPickList)
            val gridLayoutManager =
                GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            binding.recyclerViewHori.layoutManager = gridLayoutManager
            binding.recyclerViewHori.adapter = adapterHori
        }
    }

    private fun getCategory() {
        viewModel.getCategory().observe(viewLifecycleOwner) { categoryList ->
            adapterCategory.setCategoryArrayList(categoryList)
            val gridLayoutManager =
                GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            binding.recyclerCategory.layoutManager = gridLayoutManager
            binding.recyclerCategory.adapter = adapterCategory

        }
    }

}