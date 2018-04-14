package com.rhodar.mobile.codescrum.validtest.ui.mainActivity.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rhodar.mobile.codescrum.validtest.R

class ListElementFragment : Fragment() {

    companion object {
        val TYPE_OF_FRAGMENT = "type_of_fragment"
        val TYPE_TRACKS = 0
        val TYPE_ARTIST = 1
    }




    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.list_item_fragment, container, false)
    }
}