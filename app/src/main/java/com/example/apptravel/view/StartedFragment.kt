package com.example.travelguideapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.travelguideapplication.R
import com.example.travelguideapplication.adapter.TabsAdaptor
import com.example.travelguideapplication.adapter.TravelApiAdapter
import com.example.travelguideapplication.databinding.FragmentStartedBinding
import com.example.travelguideapplication.viewmodel.StartedFragmentViewModel
import com.google.android.material.tabs.TabLayoutMediator


class StartedFragment : Fragment() {
    private lateinit var binding: FragmentStartedBinding
    private val startedFragmentViewModel: StartedFragmentViewModel by viewModels()

    private var adapter: TravelApiAdapter = TravelApiAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_started,
            container,
            false
        )
        viewPager()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        context?.let {

        }
    }

    private fun viewPager() {
        val titleList = arrayOf("All", "Flights", "Hotels", "Transportations")
        var pager = binding.viewPager
        val tl = binding.tabsApp
        pager.adapter = TabsAdaptor(childFragmentManager, lifecycle)
        TabLayoutMediator(tl, pager) { tab, position ->
            tab.text = titleList[position]
            pager.isUserInputEnabled = false

        }.attach()
    }


}

