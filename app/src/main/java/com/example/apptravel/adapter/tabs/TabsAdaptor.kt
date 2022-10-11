package com.example.apptravel.adapter.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.apptravel.view.AllTravelFragment
import com.example.apptravel.view.FlightFragment
import com.example.apptravel.view.HotelFragment
import com.example.apptravel.view.TransportationsFragment

class TabsAdaptor(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return AllTravelFragment()
            1 -> return FlightFragment()
            2 -> return HotelFragment()
            3 -> return TransportationsFragment()
            else -> return AllTravelFragment()
        }
    }


}