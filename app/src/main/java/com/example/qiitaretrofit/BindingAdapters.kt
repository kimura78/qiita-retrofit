package com.example.qiitaretrofit

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaretrofit.itemList.ItemAdapter
import com.example.qiitaretrofit.network.ItemProperty

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ItemProperty>?) {
    val adapter = recyclerView.adapter as ItemAdapter
    adapter.submitList(data)
}
