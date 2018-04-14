package com.rhodar.mobile.codescrum.validtest.Util

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import com.rhodar.mobile.codescrum.validtest.App
import com.rhodar.mobile.codescrum.validtest.data.api.LastFmApiClient
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Artist
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Track
import io.reactivex.schedulers.Schedulers

class ForegroundListener(val context: Context) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startSync() {
        val lastFmClient = LastFmApiClient()
        lastFmClient.getTopTracks()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    App.db.trackDao().delete()
                    it.topTrack.track.forEach {
                        val currentTrack = Track(
                                name = it.name,
                                duration = it.duration,
                                listeners = it.listeners,
                                trackUrl = it.url,
                                artist = it.artist.name,
                                imageUrl = it.image[1].imgUrl
                        )
                        App.db.trackDao().insert(currentTrack)
                    }
                }, {
                    it.printStackTrace()
                })
        lastFmClient.getTopArtist()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    App.db.artistDao().delete()
                    it.topArtist.artists.forEach {
                        val currentArtist = Artist(
                                name = it.name,
                                listeners = it.listeners,
                                artistUrl = it.url,
                                imageUrl = it.image[1].imgUrl
                        )
                        App.db.artistDao().insert(currentArtist)
                    }
                },
                        {
                            it.printStackTrace()
                        })
    }
}