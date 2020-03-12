package com.project.segunfrancis.quickbuy.repository

import androidx.lifecycle.LiveData
import com.project.segunfrancis.quickbuy.dataSource.local.ItemDao
import com.project.segunfrancis.quickbuy.dataSource.remote.ItemService
import com.project.segunfrancis.quickbuy.model.Error
import com.project.segunfrancis.quickbuy.model.Item
import com.project.segunfrancis.quickbuy.model.ProductBaseResponse
import com.project.segunfrancis.quickbuy.model.ShoppingCartItem
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by SegunFrancis
 */

class ItemRepository(private var itemDao: ItemDao) {

    fun product(
        service: ItemService,
        onSuccess: (repos: ProductBaseResponse) -> Unit,
        onError: (error: ResponseBody?) -> Unit,
        onFailure: (error: String?) -> Unit
    ) {
        service.products().enqueue(object : Callback<ProductBaseResponse?> {
            override fun onResponse(
                call: Call<ProductBaseResponse?>,
                response: Response<ProductBaseResponse?>
            ) {
                if (response.isSuccessful)
                    response.body()?.let { onSuccess(it) }
                else
                    onError(response.errorBody())
            }

            override fun onFailure(call: Call<ProductBaseResponse?>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
        })
    }
}