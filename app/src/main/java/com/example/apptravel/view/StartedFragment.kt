package com.example.travelguideapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.apptravel.R
import com.example.apptravel.adapter.tabs.TabsAdapter
import com.example.apptravel.databinding.FragmentStartedBinding
import com.google.android.material.tabs.TabLayoutMediator


class StartedFragment : Fragment() {
    private lateinit var binding: FragmentStartedBinding

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

    /**
     * View pager
     * All,Flight,Hotels,Transportations pages viewer
     */
    private fun viewPager() {
        val titleList = arrayOf("All", "Flights", "Hotels", "Transportations")
        var pager = binding.viewPager
        val tl = binding.tabsApp
        pager.adapter = TabsAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(tl, pager) { tab, position ->
            tab.text = titleList[position]
            pager.isUserInputEnabled = false

        }.attach()
    }




}

