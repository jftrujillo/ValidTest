package com.rhodar.mobile.codescrum.validtest.ui.mainActivity

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v7.app.AppCompatActivity
import com.rhodar.mobile.codescrum.validtest.BR
import com.rhodar.mobile.codescrum.validtest.ui.adapters.ViewPagerAdapter
import com.rhodar.mobile.codescrum.validtest.ui.fragments.ListArtistFragment
import com.rhodar.mobile.codescrum.validtest.ui.fragments.ListTrackFragment


class MainViewModel : BaseObservable() {
    lateinit var adapter: ViewPagerAdapter
    var context: AppCompatActivity? = null

    @Bindable
    fun getPagerAdapter(): ViewPagerAdapter {
        return adapter
    }

    fun createViewPager() {
        adapter = ViewPagerAdapter(context!!.supportFragmentManager)
        val fragmentTopTracks = ListTrackFragment()
        val fragmentArtist = ListArtistFragment()
        adapter.add(fragmentArtist, "Artist")
        adapter.add(fragmentTopTracks, "Top Tracks")
        notifyPropertyChanged(BR.pagerAdapter)
    }
}