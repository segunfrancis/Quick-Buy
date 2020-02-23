package com.project.segunfrancis.quickbuy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.adapter.CategoryPagerAdapter
import com.project.segunfrancis.quickbuy.dataSource.ItemData
import com.project.segunfrancis.quickbuy.viewModel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var categoryPagerAdapter: CategoryPagerAdapter
    private lateinit var itemViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shopping_cart_fab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_shoppingCartFragment)
        }
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        itemViewModel.insert(ItemData.populateDatabase())
        categoryPagerAdapter = CategoryPagerAdapter(childFragmentManager)
        viewPager.adapter = categoryPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
