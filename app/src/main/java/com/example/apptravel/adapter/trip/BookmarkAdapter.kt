package com.example.apptravel.adapter.trip

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.R
import com.example.apptravel.domain.model.AllTravelItem

class BookmarkAdapter(
    private var bookmarkArrayList: ArrayList<AllTravelItem> = ArrayList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bookmarkBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.bookmark_item, parent, false
        )
        return BookmarkViewHolder(bookmarkBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BookmarkViewHolder).onBind(bookmarkArrayList[position])
    }

    override fun getItemCount(): Int {
        return bookmarkArrayList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setBookmarkArrayList(bookmarkArrayList: List<AllTravelItem>) {
        this.bookmarkArrayList.clear()
        this.bookmarkArrayList.addAll(bookmarkArrayList)
        notifyDataSetChanged()
    }

}