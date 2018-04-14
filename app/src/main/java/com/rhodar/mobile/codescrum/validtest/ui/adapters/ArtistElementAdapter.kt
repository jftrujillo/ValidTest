package com.rhodar.mobile.codescrum.validtest.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rhodar.mobile.codescrum.validtest.R
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Artist
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Track
import com.rhodar.mobile.codescrum.validtest.databinding.ArtistElementTemplateBinding


class ArtistElementAdapter : RecyclerView.Adapter<ArtistHolder>() {
    var data: List<Artist> = emptyList()
        set(value){
            field =value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.artist_element_template,
                parent, false)
        return ArtistHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ArtistHolder, position: Int) {
        holder.binding.artist = data[position]
}

}

class ArtistHolder(view : View) : RecyclerView.ViewHolder(view)  {
    val binding : ArtistElementTemplateBinding = DataBindingUtil.bind(view)!!

}
