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
    suspend fun getShoes(): LiveData<List<Item>>

    @Query("SELECT * from item_table where itemCategory is 'laptop'")
    suspend fun getLaptops(): LiveData<List<Item>>

    @Query("SELECT * from item_table where itemCategory is 'phone'")
    suspend fun getPhones(): LiveData<List<Item>>

    @Query("SELECT * from item_table where itemCategory is 'television'")
    suspend fun getTelevisions(): LiveData<List<Item>>

    @Query("SELECT * from item_table where itemCategory is 'camera'")
    suspend fun getCameras(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)
}