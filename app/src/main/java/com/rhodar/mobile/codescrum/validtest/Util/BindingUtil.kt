package com.rhodar.mobile.codescrum.validtest.Util

import android.databinding.BindingAdapter
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class BindingUtil {
    companion object {
        @JvmStatic
        @BindingAdapter("setUpWithViewpager")
        fun setUpWithViewpager(tabLayout: TabLayout, viewPager: ViewPager) {
            viewPager.addOnAdapterChangeListener(ViewPager.OnAdapterChangeListener { viewPager, oldAdapter, newAdapter ->
                if (oldAdapter == null && newAdapter == null) {
                    return@OnAdapterChangeListener
                }
                Log.i("TAG", "onAdapterChanged")
                tabLayout.setupWithViewPager(viewPager)
            })
        }

        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(view: ImageView, url: String) {
            Picasso.with(view.context).load(url).into(view)
        }

        @JvmStatic
        @BindingAdapter("formatText")
        fun loadImage(view: TextView, number: Long) {
            view.text = "listeners: $number"
        }

        @JvmStatic
        @BindingAdapter("app:formatDuration")
        fun formatDuration(view: TextView, duration: String) {
            val seconds = duration.toInt()
            view.text =  String.format("%02d:%02d", (seconds % 3600) / 60, seconds % 60)
        }
    }
}