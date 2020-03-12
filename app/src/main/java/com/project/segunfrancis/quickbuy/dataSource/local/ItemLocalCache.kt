package com.project.segunfrancis.quickbuy.dataSource.local

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by SegunFrancis
 */
class ItemLocalCache(private val itemDao: ItemDao, private val scope: CoroutineScope) {

    /**
    * Insert a list of items in the database, on a background thread
    */
    fun insert() {
        scope.launch {
            //TODO: Insert item into list for caching

        }
    }
}