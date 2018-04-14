package com.rhodar.mobile.codescrum.validtest.data.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class LastFmApiClient {
    val retrofit = Retrofit.Builder()
            .baseUrl(LastFmService.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val lastFmService = retrofit.create(LastFmService::class.java)
    fun getTopArtist() = lastFmService.getTopArtist()
    fun getTopTracks() = lastFmService.getTopTracks()
}