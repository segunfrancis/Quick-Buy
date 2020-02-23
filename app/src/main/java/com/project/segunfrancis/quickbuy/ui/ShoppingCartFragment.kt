package com.project.segunfrancis.quickbuy.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.adapter.ShoppingCartAdapter
import com.project.segunfrancis.quickbuy.viewModel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_shopping_cart.*

/**
 * A simple [Fragment] subclass.
 */
class ShoppingCartFragment : Fragment() {

    lateinit var itemViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ShoppingCartAdapter()
        shopping_cart_recyclerView.adapter = adapter
        itemViewModel.shoppingCartList.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
    }
}
