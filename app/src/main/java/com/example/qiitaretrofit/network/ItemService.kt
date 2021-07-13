package com.example.qiitaretrofit.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ItemApiService {

    @GET("realestate")
    suspend fun getProperties(): List<ItemProperty>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object ItemApi {
    val retrofitService : ItemApiService by lazy { retrofit.create(ItemApiService::class.java) }
}