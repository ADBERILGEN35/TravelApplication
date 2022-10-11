package com.example.apptravel.adapter.guide

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.R
import com.example.apptravel.domain.model.AllTravelItem

class GuideHoriAdapter(
    private var travelArrayList: ArrayList<AllTravelItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.guide_item_horizantal, parent, false
        )
        return GuideHoriViewHolder(travelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GuideHoriViewHolder).onBind(travelArrayList[position])
    }

    override fun getItemCount(): Int {
        return travelArrayList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTravelArrayList(travelArrayList: List<AllTravelItem>){
        this.travelArrayList.clear()
        this.travelArrayList.addAll(travelArrayList)
        notifyDataSetChanged()
    }
}