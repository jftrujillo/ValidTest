package com.rhodar.mobile.codescrum.validtest.data.api

import com.rhodar.mobile.codescrum.validtest.data.responseModels.TopArtistData
import com.rhodar.mobile.codescrum.validtest.data.responseModels.TopTracksData
import io.reactivex.Observable
import retrofit2.http.GET



// http://ws.audioscrobbler.com/2.0/  base

interface LastFmService {

    companion object {
        val BASE_URL = "http://ws.audioscrobbler.com/2.0/"
    }
    @GET("?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    fun getTopArtist(): Observable<TopArtistData>

    @GET("?method=geo.gettoptracks&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    fun getTopTracks(): Observable<TopTracksData>
}