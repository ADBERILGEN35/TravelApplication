package com.example.apptravel.adapter.spinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.apptravel.R
import com.example.apptravel.domain.model.AllTravelItem

class SpinnerAdapter(ctx: Context, list: List<AllTravelItem>) :
    ArrayAdapter<AllTravelItem>(ctx, 0, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return myView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return myView(position,convertView,parent)
    }

    private fun myView(position: Int, convertView: View?, parent: ViewGroup): View {
        val list = getItem(position)
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.spinner_item, parent, false)
        list?.let {
            val txt = view.findViewById<TextView>(R.id.textSpin)
            val img = view.findViewById<ImageView>(R.id.spinImage)

            if (list.images != null) {
                Glide.with(context).load(list.images[0].url!!).into(img)
                txt.text= list.city!!
            }
        }
        return view
    }
}