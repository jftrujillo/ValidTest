package com.rhodar.mobile.codescrum.validtest.data.responseModels

import android.media.Image
import java.time.Duration


data class TrackData(
        val name: String,
        val duration: String,
        val listeners: Long,
        val url: String,
        val artist : ArtistData,
        val image: List<ImageData>
)