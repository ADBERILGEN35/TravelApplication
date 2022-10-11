package com.example.apptravel.adapter.started

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.R
import com.example.apptravel.domain.model.AllTravelItem
import com.example.apptravel.domain.model.Image
import com.example.apptravel.domain.room.Travel

class TravelApiAdapter(
    private var travelArrayList: ArrayList<AllTravelItem> = ArrayList(),
    private var photoArrayList: ArrayList<List<Image>> = ArrayList(),
    private var tripList: ArrayList<Travel> = ArrayList(),
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.started_recycler_item, parent, false
        )

        return TravelApiViewHolder(travelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TravelApiViewHolder).onBind(travelArrayList[position])
    }

    override fun getItemCount(): Int {
        return travelArrayList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setTravelArrayList(travelArrayList: List<AllTravelItem>) {
        this.travelArrayList.clear()
        this.travelArrayList.addAll(travelArrayList)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTripArrayList(travelArrayList: ArrayList<Travel>) {
        this.tripList.clear()
        this.tripList.addAll(travelArrayList)
        notifyDataSetChanged()
    }



    @SuppressLint("NotifyDataSetChanged")
    fun setPhotoList(photoArrayList: List<List<Image>>) {
        this.photoArrayList.clear()
        this.photoArrayList.addAll(photoArrayList)
        notifyDataSetChanged()
    }


}