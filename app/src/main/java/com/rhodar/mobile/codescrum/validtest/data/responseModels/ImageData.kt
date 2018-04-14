package com.rhodar.mobile.codescrum.validtest.data.responseModels

import com.google.gson.annotations.SerializedName

data class ImageData(
        @SerializedName("#text")
        val imgUrl : String,
        val size : String
)