package com.example.qiitaretrofit.itemList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.qiitaretrofit.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {

    private val viewModel: ItemListViewModel by lazy {
        ViewModelProvider(this).get(ItemListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentItemListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.itemList.adapter = ItemAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }
}