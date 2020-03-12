package com.project.segunfrancis.quickbuy.dataSource.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.segunfrancis.quickbuy.model.Item
import com.project.segunfrancis.quickbuy.model.ShoppingCartItem

/**
 * Created by SegunFrancis
 */

@Dao
interface ItemDao {
    @Query("SELECT * from item_table where itemCategory is 'shoe'")
    fun getShoes(): LiveData<List<Item>>

    @Query("SELECT * from item_table where itemCategory is 'laptop'")
    fun getLaptops(): LiveData<List<Item>>

    @Query("SELECT * from item_table where itemCategory is 'phone'")
    fun getPhones(): LiveData<List<Item>>

    @Query("SELECT * from item_table where itemCategory is 'television'")
    fun getTelevisions(): LiveData<List<Item>>

    @Query("SELECT * from item_table where itemCategory is 'camera'")
    fun getCameras(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<Item>)


    // Shopping Cart
    @Query("SELECT * FROM shopping_cart_table")
    fun getShoppingCartItems(): LiveData<List<ShoppingCartItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIntoShoppingCartItem(shoppingCartItem: ShoppingCartItem)

    @Delete
    suspend fun deleteSingleItem(shoppingCartItem: ShoppingCartItem)

    @Query("DELETE FROM shopping_cart_table")
    suspend fun clearShoppingCart()

    @Insert(entity = ShoppingCartItem::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun changeQuantity(shoppingCartItem: ShoppingCartItem)
}