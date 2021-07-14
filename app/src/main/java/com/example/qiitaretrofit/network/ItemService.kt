package com.example.qiitaretrofit.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://qiita.com/api/v2/ "
private val okHttpClient = OkHttpClient.Builder().build()
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()

interface ItemApiService {
    @GET("items")
    suspend fun getProperties(): List<ItemProperty>
}

object ItemApi {
    val retrofitService : ItemApiService by lazy { retrofit.create(ItemApiService::class.java) }
}