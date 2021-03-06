package com.project.segunfrancis.quickbuy.dataSource

import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.model.Item

/**
 * Created by SegunFrancis
 */

object ItemData {
    fun populateDatabase(): ArrayList<Item> {
        val itemList = ArrayList<Item>()
        var item = Item(
            "Adidas Dragon Ball",
            "shoe",
            "Morbi mattis ullamcorper velit. Sed libero. Sed a libero. Phasellus volutpat, metus eget egestas mollis, lacus lacus blandit dui, id egestas quam mauris ut lacus. Ut tincidunt tincidunt erat." +
                    "\n" + "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            12_000,
            R.drawable.adidas_dragon_ball
        )
        itemList.add(item)
        item = Item(
            "Adidas Stan Smith",
            "shoe",
            "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            17_600,
            R.drawable.adidas_stan_smith
        )
        itemList.add(item)
        item = Item(
            "Adidas Tennis Shoe",
            "shoe",
            "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            2_200,
            R.drawable.adidas_tennis_shoe
        )
        itemList.add(item)
        item = Item(
            "Adidas Ultra Boost",
            "shoe",
            "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            7_300,
            R.drawable.adidas_ultraboost
        )
        itemList.add(item)
        item = Item(
            "Adidas Ultra Boost 19",
            "shoe",
            "Fusce egestas elit eget lorem. Vivamus consectetuer hendrerit lacus. Aliquam lobortis. Vivamus quis mi. Fusce commodo aliquam arcu." +
                    "\n" + "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            3_700,
            R.drawable.adidas_ultraboost_19
        )
        itemList.add(item)
        item = Item(
            "Adidas Adizero pro",
            "shoe",
            "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            9_999,
            R.drawable.adidas_adizero_pro
        )
        itemList.add(item)
        item = Item(
            "Adidas Originals Dragon",
            "shoe",
            "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            6_500,
            R.drawable.adidas_originals_dragon
        )
        itemList.add(item)
        item = Item(
            "Adidas 1",
            "shoe",
            "Cras varius. Praesent porttitor, nulla vitae posuere iaculis, arcu nisl dignissim dolor, a pretium mi sem ut ipsum. Etiam rhoncus. Vivamus euismod mauris.\n" +
                    "\n" + "Fusce egestas elit eget lorem. Vivamus consectetuer hendrerit lacus. Aliquam lobortis. Vivamus quis mi. Fusce commodo aliquam arcu.",
            1_000,
            R.drawable.adidas_1
        )
        itemList.add(item)
        item = Item(
            "Adidas 2",
            "shoe",
            "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            2_000,
            R.drawable.adidas_2
        )
        itemList.add(item)
        item = Item(
            "Adidas 3",
            "shoe",
            "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            3_000,
            R.drawable.adidas_3
        )
        itemList.add(item)
        item = Item(
            "Adidas 4",
            "shoe",
            "Cras varius. Praesent porttitor, nulla vitae posuere iaculis, arcu nisl dignissim dolor, a pretium mi sem ut ipsum. Etiam rhoncus. Vivamus euismod mauris.\n" +
                    "\n" + "Fusce egestas elit eget lorem. Vivamus consectetuer hendrerit lacus. Aliquam lobortis. Vivamus quis mi. Fusce commodo aliquam arcu.",
            3_000,
            R.drawable.adidas_4
        )
        itemList.add(item)
        item = Item(
            "Adidas 5",
            "shoe",
            "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Nam at tortor in tellus interdum sagittis. Aliquam eu nunc.",
            3_000,
            R.drawable.adidas_5
        )
        itemList.add(item)
        return itemList
    }
}