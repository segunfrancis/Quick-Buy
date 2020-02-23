package com.project.segunfrancis.quickbuy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.segunfrancis.quickbuy.model.Item

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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(items: List<Item>)
}