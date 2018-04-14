package com.rhodar.mobile.codescrum.validtest.ui.mainActivity.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rhodar.mobile.codescrum.validtest.App
import com.rhodar.mobile.codescrum.validtest.R
import com.rhodar.mobile.codescrum.validtest.Util.addDivider
import com.rhodar.mobile.codescrum.validtest.ui.adapters.TrackElementAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.list_item_fragment.*

class ListTrackFragment : Fragment() {
    val adapter = TrackElementAdapter()
    private lateinit var dis : CompositeDisposable

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dis = CompositeDisposable()
    }

    override fun onResume() {
        super.onResume()
        list.adapter = adapter
        list.addDivider(activity,LinearLayoutManager.VERTICAL)
        loadItems()
    }

    private fun loadItems() {
        dis.add(App.db.trackDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.data = it
                },{it.printStackTrace()})
                )
    }

    override fun onDestroy() {
        super.onDestroy()
        dis.dispose()
    }
}