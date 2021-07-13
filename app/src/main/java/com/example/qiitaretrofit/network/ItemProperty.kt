package com.example.qiitaretrofit.network

data class ItemProperty(
    val id: String,
    val type: String,
    val price: Double)  {
    val isRental
        get() = type == "rent"
}