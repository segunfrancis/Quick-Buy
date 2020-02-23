package com.project.segunfrancis.quickbuy.database

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

    /*@Query("DELETE FROM shopping_cart_table where name is ")
    suspend fun deleteSingleItem(itemName: String)*/

    @Query("DELETE FROM shopping_cart_table")
    suspend fun clearShoppingCart()
}