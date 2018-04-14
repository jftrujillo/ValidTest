package com.rhodar.mobile.codescrum.validtest.Util

import android.databinding.BindingAdapter
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log


class BindingUtil{
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
    }
}