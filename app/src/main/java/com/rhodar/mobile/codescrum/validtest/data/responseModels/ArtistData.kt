package com.rhodar.mobile.codescrum.validtest.data.responseModels

import com.google.gson.annotations.SerializedName

data class ArtistData (
        val name: String,
        val listeners : Long,
        val mbid: String,
        val url : String,
        val streamable : Int,
        val image : List<ImageData>
)