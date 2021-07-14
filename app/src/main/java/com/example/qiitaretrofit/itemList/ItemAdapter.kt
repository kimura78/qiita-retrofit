package com.example.qiitaretrofit.itemList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaretrofit.databinding.CardItemBinding
import com.example.qiitaretrofit.network.ItemProperty

class ItemAdapter() : ListAdapter<ItemProperty, ItemAdapter.ItemViewHolder>(DiffCallback) {

    class ItemViewHolder(private var binding: CardItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemProperty) {
            binding.property = item
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ItemProperty>() {
        override fun areItemsTheSame(oldItem: ItemProperty, newItem: ItemProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ItemProperty, newItem: ItemProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ItemViewHolder {
        return ItemViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemProperty = getItem(position)
        holder.bind(itemProperty)
    }
}