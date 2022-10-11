package com.example.apptravel.adapter.trip

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.R
import com.example.apptravel.domain.room.Travel


class TripAdapter(
    private var tripArrayList: ArrayList<Travel> = ArrayList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val tripBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.trip_item, parent, false
        )
        return TripViewHolder(tripBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TripViewHolder).onBind(tripArrayList[position])
    }

    override fun getItemCount(): Int {
        return tripArrayList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTripArrayList(tripArrayList: List<Travel>) {
        this.tripArrayList.clear()
        this.tripArrayList.addAll(tripArrayList)
        notifyDataSetChanged()
    }
}