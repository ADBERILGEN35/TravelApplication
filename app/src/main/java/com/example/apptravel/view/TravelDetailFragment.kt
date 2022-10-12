package com.example.apptravel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.apptravel.R
import com.example.apptravel.databinding.FragmentTravelDetailBinding
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.service.TravelApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TravelDetailFragment : Fragment() {
    private lateinit var binding: FragmentTravelDetailBinding

    private val navArgs: TravelDetailFragmentArgs? by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_travel_detail,
            container,
            false
        )
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
            dataTravel()
            putBookmark()

        }
    }

    private fun dataTravel() {
        navArgs?.let {
            binding.allTravelModel = it.travelItem
        }
    }


    /**
     * Put bookmark
     * @PUT isBookmark = true & false
     */
    private fun putBookmark() {
        val bookmark = view?.findViewById<ImageButton>(R.id.bookmark3)
        bookmark?.setOnClickListener {

            val id = navArgs?.travelItem?.id
            var isBookmark = navArgs?.travelItem?.isBookmark
            isBookmark = isBookmark != true
            if (id != null) {
                TravelApi.retrofitService.putBookmark(id, isBookmark)
                    .enqueue(object : Callback<List<AllTravelItem>> {
                        override fun onResponse(
                            call: Call<List<AllTravelItem>>,
                            response: Response<List<AllTravelItem>>
                        ) {
                            if (isBookmark == true) {
                                binding.bookmark3.setBackgroundColor(255)
                            }
                        }
                        override fun onFailure(call: Call<List<AllTravelItem>>, t: Throwable) {
                            println(t.message)
                        }
                    })
            }
        }
    }
}