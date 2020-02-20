package com.project.segunfrancis.quickbuy.data

import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.database.ItemDao
import com.project.segunfrancis.quickbuy.model.Item
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * Created by SegunFrancis
 */

object ItemData {
    suspend fun populateDatabase(dao: ItemDao) {
        var item = Item("Adidas Dragon Ball", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$12,000", R.drawable.ic_shopping_cart)
        dao.insert(item)
        item = Item("Adidas Stan Smith", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$17,600", R.drawable.ic_shopping_cart)
        dao.insert(item)
        item = Item("Adidas Tennis Shoe", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$2,200", R.drawable.ic_shopping_cart)
        dao.insert(item)
        item = Item("Adidas Ultra Boost", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$7,300", R.drawable.ic_shopping_cart)
        dao.insert(item)
        item = Item("Adidas Ultra Boost 19", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$3,700", R.drawable.ic_shopping_cart)
        dao.insert(item)
        item = Item("Adidas Adizero pro", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$9,999", R.drawable.ic_shopping_cart)
        dao.insert(item)
        item = Item("Adidas Originals Dragon", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$6,500", R.drawable.ic_shopping_cart)
        dao.insert(item)
        item = Item("Adidas 1", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$1,000", R.drawable.ic_shopping_cart)
        dao.insert(item)
        item = Item("Adidas 2", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$2,000", R.drawable.ic_shopping_cart)
        dao.insert(item)
        item = Item("Adidas 3", "shoe", "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.", "$3,000", R.drawable.ic_shopping_cart)
        dao.insert(item)
    }
}