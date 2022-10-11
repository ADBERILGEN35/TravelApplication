package com.example.apptravel.adapter.guide

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.apptravel.databinding.CategoryItemBinding
import com.example.apptravel.domain.model.GuideCategoryItem

class CategoryViewHolder(
    private val categoryBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(categoryBinding.root) {

    fun onBind(categoryItem: GuideCategoryItem) {
        val binding = categoryBinding as CategoryItemBinding
        binding.apply {
            setVariable(BR.allCategoryModel, categoryItem)
        }
    }
}

