package com.example.apptravel.adapter.trip

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.R
import com.example.apptravel.domain.room.Travel

class TripsAdapter(
    private var databaseArrayList: ArrayList<Travel> = ArrayList(),
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val tripsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.trip_item, parent, false
        )
        return TripsViewHolder(tripsBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TripsViewHolder).onBind(databaseArrayList[position])

    }

    override fun getItemCount(): Int {
        return databaseArrayList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDatabaseArrayList(tripArrayList: ArrayList<Travel>) {
        this.databaseArrayList.clear()
        this.databaseArrayList.addAll(tripArrayList)
        notifyDataSetChanged()
    }
}

