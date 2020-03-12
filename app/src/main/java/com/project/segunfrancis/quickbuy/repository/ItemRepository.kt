package com.project.segunfrancis.quickbuy.repository

import androidx.lifecycle.LiveData
import com.project.segunfrancis.quickbuy.dataSource.local.ItemDao
import com.project.segunfrancis.quickbuy.model.Item
import com.project.segunfrancis.quickbuy.model.ShoppingCartItem

/**
 * Created by SegunFrancis
 */

class ItemRepository(private var itemDao: ItemDao) {

    fun getShoes(): LiveData<List<Item>> = itemDao.getShoes()
    fun getLaptops(): LiveData<List<Item>> = itemDao.getLaptops()
    fun getCameras(): LiveData<List<Item>> = itemDao.getCameras()
    fun getPhones(): LiveData<List<Item>> = itemDao.getPhones()
    fun getTelevisions(): LiveData<List<Item>> = itemDao.getTelevisions()
    suspend fun insert(items: List<Item>) = itemDao.insert(items)

    // Shopping Cart items
    fun getShoppingCartItems(): LiveData<List<ShoppingCartItem>> = itemDao.getShoppingCartItems()

    suspend fun insertIntoShoppingCartItem(shoppingCartItem: ShoppingCartItem) =
        itemDao.insertIntoShoppingCartItem(shoppingCartItem)

    suspend fun deleteSingleItem(shoppingCartItem: ShoppingCartItem) =
        itemDao.deleteSingleItem(shoppingCartItem)

    suspend fun clearShoppingCart() = itemDao.clearShoppingCart()

    suspend fun changeQuantity(shoppingCartItem: ShoppingCartItem) = itemDao.changeQuantity(shoppingCartItem)
}