package com.example.qiitaretrofit.network

import com.squareup.moshi.Json

data class ItemProperty(
    val id: String,
    // used to map img_src from the JSON to imgSrcUrl in our class
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
)