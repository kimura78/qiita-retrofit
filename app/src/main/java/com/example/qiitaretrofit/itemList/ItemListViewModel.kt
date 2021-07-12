package com.example.qiitaretrofit.itemList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qiitaretrofit.network.ItemApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemListViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getItemListProperties()
    }

    private fun getItemListProperties() {
        ItemApi.retrofitService.getProperties().enqueue(
            object: Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    _response.value = "Failure: " + t.message
                }

                override fun onResponse(call: Call<String>,
                                        response: Response<String>
                ) {
                    _response.value = response.body()
                }
            })
    }

}