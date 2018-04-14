package com.rhodar.mobile.codescrum.validtest.data.responseModels

import com.google.gson.annotations.SerializedName

data class TopArtistData(
        @SerializedName("topartists")
        val topArtist: Artists
)

data class Artists(
        @SerializedName("artist")
        val artists: List<ArtistData>)