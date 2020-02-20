package com.project.segunfrancis.quickbuy.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.adapter.CategoryPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), TabLayout.OnTabSelectedListener {
    /**
     * Called when a tab that is already selected is chosen again by the user. Some applications may
     * use this action to return to the top level of a category.
     *
     * @param tab The tab that was reselected.
     */
    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

    /**
     * Called when a tab exits the selected state.
     *
     * @param tab The tab that was unselected
     */
    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    /**
     * Called when a tab enters the selected state.
     *
     * @param tab The tab that was selected
     */
    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
        }
    }

    private lateinit var categoryPagerAdapter: CategoryPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val navOptions = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setPopUpTo(findNavController().graph.startDestination, false)
            .build()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shopping_cart_fab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_shoppingCartFragment)
        }
        tabLayout.addOnTabSelectedListener(this)
        categoryPagerAdapter = CategoryPagerAdapter(childFragmentManager)
        viewPager.adapter = categoryPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
