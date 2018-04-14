package com.rhodar.mobile.codescrum.validtest.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


class ViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val fragments = mutableListOf<Fragment>()
    private val titles = mutableListOf<String>()

    fun add(fragment: Fragment , title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}