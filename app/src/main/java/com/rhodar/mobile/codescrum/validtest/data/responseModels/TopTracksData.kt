package com.rhodar.mobile.codescrum.validtest.data.responseModels

import com.google.gson.annotations.SerializedName

data class TopTracksData(
        @SerializedName("tracks")
        val topTrack: TopTrack)

data class TopTrack(val track : List<TrackData>)