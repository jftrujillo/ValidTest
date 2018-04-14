package com.rhodar.mobile.codescrum.validtest.ui.mainActivity

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v7.app.AppCompatActivity
import com.rhodar.mobile.codescrum.validtest.BR
import com.rhodar.mobile.codescrum.validtest.ui.adapters.ViewPagerAdapter
import com.rhodar.mobile.codescrum.validtest.ui.mainActivity.fragments.ListElementFragment
import org.jetbrains.anko.bundleOf


class MainViewModel : BaseObservable() {
    lateinit var adapter: ViewPagerAdapter
    var context: AppCompatActivity? = null

    @Bindable
    fun getPagerAdapter(): ViewPagerAdapter {
        return adapter
    }

    fun createViewPager() {
        adapter = ViewPagerAdapter(context!!.supportFragmentManager)
        val fragmentTopTracks = ListElementFragment()
        fragmentTopTracks.arguments = bundleOf(ListElementFragment.TYPE_OF_FRAGMENT to ListElementFragment.TYPE_TRACKS)
        val fragmentArtist = ListElementFragment()
        fragmentArtist.arguments = bundleOf(ListElementFragment.TYPE_OF_FRAGMENT to ListElementFragment.TYPE_ARTIST)

        adapter.add(ListElementFragment(), "Top Tracks")
        adapter.add(ListElementFragment(), "Artist")
        notifyPropertyChanged(BR.pagerAdapter)
    }
}