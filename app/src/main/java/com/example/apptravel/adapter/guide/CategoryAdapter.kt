package com.example.apptravel.adapter.guide

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.R
import com.example.apptravel.domain.model.GuideCategoryItem

class CategoryAdapter(
    private val categoryArrayList: ArrayList<GuideCategoryItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val categoryBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.category_item, parent, false
        )
        return CategoryViewHolder(categoryBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CategoryViewHolder).onBind(categoryArrayList[position])
    }

    override fun getItemCount(): Int {
        return categoryArrayList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCategoryArrayList(categoryArrayList: List<GuideCategoryItem>) {
        this.categoryArrayList.clear()
        this.categoryArrayList.addAll(categoryArrayList)
        notifyDataSetChanged()
    }
}


