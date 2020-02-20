package com.project.segunfrancis.quickbuy.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.project.segunfrancis.quickbuy.ui.*

/**
 * Created by SegunFrancis
 */
class CategoryPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    /**
     * Return the Fragment associated with a specified position.
     */
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ShoeFragment()
            1 -> LaptopFragment()
            2 -> PhoneFragment()
            3 -> TelevisionFragment()
            4 -> CameraFragment()
            else -> ShoeFragment()
        }
    }

    /**
     * Return the number of views available.
     */
    override fun getCount() = 5

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Shoes"
            1 -> "Laptops"
            2 -> "Phones"
            3 -> "Televisions"
            4 -> "Cameras"
            else -> "Shoes"
        }
    }
}