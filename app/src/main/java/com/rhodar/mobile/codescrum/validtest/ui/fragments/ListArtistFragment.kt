package com.rhodar.mobile.codescrum.validtest.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rhodar.mobile.codescrum.validtest.App
import com.rhodar.mobile.codescrum.validtest.R
import com.rhodar.mobile.codescrum.validtest.ui.adapters.ArtistElementAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.list_item_fragment.*

class ListArtistFragment : Fragment() {
    val adapter = ArtistElementAdapter()
    private lateinit var dis: CompositeDisposable

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.list_item_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dis = CompositeDisposable()
    }

    override fun onResume() {
        super.onResume()
        list.adapter = adapter
        loadItems()
    }

    private fun loadItems() {
        dis.add(App.db.artistDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.data = it
                }, { it.printStackTrace() })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        dis.dispose()
    }
}

