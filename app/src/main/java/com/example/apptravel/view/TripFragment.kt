package com.example.apptravel.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.apptravel.R
import com.example.apptravel.adapter.tabs.TripTabsAdapter
import com.example.apptravel.adapter.trip.TripAdapter
import com.example.apptravel.databinding.FragmentTripBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.domain.room.Travel
import com.example.apptravel.domain.room.TravelDatabase
import com.example.apptravel.viewmodel.TripViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator


class TripFragment : Fragment() {
    private lateinit var binding: FragmentTripBinding
    private val viewModel: TripViewModel by viewModels()
    private var adapter: TripAdapter = TripAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_trip,
            container,
            false
        )
        viewPager()
        binding.ellipse4.setOnClickListener {
            showBottomSheet()
        }

        return binding.root
    }

    private fun viewPager() {
        val titleList = arrayOf("Trip", "Bookmark")
        var pager = binding.viewPager
        val tl = binding.tabLayout
        pager.adapter = TripTabsAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(tl, pager) { tab, position ->
            tab.text = titleList[position]
            pager.isUserInputEnabled = false

        }.attach()
    }


    private fun showBottomSheet() {
        var listTrip: AllTravelItem
        val dialog = context?.let { BottomSheetDialog(it) }
        val view = layoutInflater.inflate(R.layout.fragment_new_trip_sheet, null)
        dialog?.setContentView(view)
        dialog?.show()
        viewModel.getTravelData().observe(viewLifecycleOwner) { topDestination ->
            adapter.setTripArrayList(topDestination)
            val arrayAdapter: ArrayAdapter<*>
            viewModel.getCity().let {
                it.apply {
                    arrayAdapter = ArrayAdapter(
                        requireContext(), android.R.layout.simple_list_item_1, topDestination
                    )
                    val spinner = view.findViewById<Spinner>(R.id.listview)
                    spinner.adapter = com.example.apptravel.adapter.spinner.SpinnerAdapter(
                        requireContext(),
                        topDestination
                    )
                    spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {
                            view.findViewById<Button>(R.id.buttonSheet).setOnClickListener {
                                val travelDatabase: TravelDatabase? =
                                    TravelDatabase.getTravelDatabase(requireContext())
                                listTrip = topDestination[p2]
                                val travel = Travel(
                                    listTrip.id,
                                    listTrip.title,
                                    listTrip.description,
                                    listTrip.category,
                                    listTrip.country,
                                    listTrip.city,
                                    listTrip.images[0].url,
                                    listTrip.isBookmark,
                                    view.findViewById<EditText>(R.id.editTextDay).text.toString()+" days"
                                )
                                travelDatabase?.travelDao()?.insert(travel)
                                dialog?.dismiss()

                            }

                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            Log.e("Error", "Error")
                        }
                    }
                }
            }
        }
    }
}