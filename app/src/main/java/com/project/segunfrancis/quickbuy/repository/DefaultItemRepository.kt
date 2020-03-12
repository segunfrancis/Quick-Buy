package com.project.segunfrancis.quickbuy.repository

import com.project.segunfrancis.quickbuy.dataSource.local.ItemLocalCache
import com.project.segunfrancis.quickbuy.dataSource.remote.ItemService

/**
 * Created by SegunFrancis
 */

class DefaultItemRepository(
    private val service: ItemService,
    private val cache: ItemLocalCache
) {


    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }
}