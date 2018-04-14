package com.rhodar.mobile.codescrum.validtest.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rhodar.mobile.codescrum.validtest.R
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Track
import com.rhodar.mobile.codescrum.validtest.databinding.TrackElementTemplateBinding

class TrackElementAdapter : RecyclerView.Adapter<ElementHolder>() {
    var data: List<Track> = emptyList()
    set(value){
        field =value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.track_element_template,
                parent, false)
        return ElementHolder(view)
    }
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ElementHolder, position: Int) {
        holder.binding.track = data[position]
    }

}

class ElementHolder(view : View) : RecyclerView.ViewHolder(view) {
    val binding: TrackElementTemplateBinding = DataBindingUtil.bind(view)!!

}
