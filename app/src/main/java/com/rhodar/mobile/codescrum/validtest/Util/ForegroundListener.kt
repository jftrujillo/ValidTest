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
                    val tracks = mutableListOf<Track>()
                    App.db.trackDao().delete()
                    it.topTrack.track.forEach {
                        tracks.add(Track(
                                name = it.name,
                                duration = it.duration,
                                listeners = it.listeners,
                                trackUrl = it.url,
                                artist = it.artist.name,
                                imageUrl = it.image[1].imgUrl
                        ))
                    }
                    App.db.trackDao().insert(*tracks.toTypedArray())
                }, {
                    it.printStackTrace()
                })
        lastFmClient.getTopArtist()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    App.db.artistDao().delete()
                    val artist = mutableListOf<Artist>()
                    it.topArtist.artists.forEach {
                        artist.add(Artist(
                                name = it.name,
                                listeners = it.listeners,
                                artistUrl = it.url,
                                imageUrl = it.image[1].imgUrl
                        ))
                    }
                    App.db.artistDao().insert(*artist.toTypedArray())
                },
                        {
                            it.printStackTrace()
                        })
    }
}