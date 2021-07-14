package com.example.qiitaretrofit.itemList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qiitaretrofit.network.ItemApi
import com.example.qiitaretrofit.network.ItemProperty
import kotlinx.coroutines.launch

class ItemListViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<ItemProperty>>()

    val properties: LiveData<List<ItemProperty>>
        get() = _properties

    init {
        getItemListProperties()
    }

    private fun getItemListProperties() {
        viewModelScope.launch {
            try {
                _properties.value = ItemApi.retrofitService.getProperties()
                Log.d("TAG", "成功")
            } catch (e: Exception) {
                _properties.value = ArrayList()
                Log.d("TAG", "失敗")
            }
        }
    }
}