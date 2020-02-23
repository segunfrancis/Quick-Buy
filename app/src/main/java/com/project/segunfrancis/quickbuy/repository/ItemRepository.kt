package com.project.segunfrancis.quickbuy.repository

import androidx.lifecycle.LiveData
import com.project.segunfrancis.quickbuy.database.ItemDao
import com.project.segunfrancis.quickbuy.model.Item

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
   // suspend fun insertData() = ItemData.populateDatabase()
}