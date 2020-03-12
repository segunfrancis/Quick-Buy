package com.project.segunfrancis.quickbuy.repository

import androidx.paging.PagedList
import com.project.segunfrancis.quickbuy.dataSource.local.ItemLocalCache
import com.project.segunfrancis.quickbuy.dataSource.remote.ItemService
import com.project.segunfrancis.quickbuy.model.Product

/**
 * Created by SegunFrancis
 */
class ResponseBoundaryCallback(
    private val service: ItemService,
    private val cache: ItemLocalCache,
    private val repository: ItemRepository
) : PagedList.BoundaryCallback<Product>() {

    // Avoid triggering multiple requests at the same time
    private var isRequestInProgress = false

    // Keep the last request page
    // WHen the request is successful, increment the page number
    private var lastRequestPage = 1

    private fun requestAndSaveData() {
        if (isRequestInProgress) return

        isRequestInProgress = true
        repository.product(service, { repos ->
            cache.insert()
        }, {}, {})
    }


    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }
}