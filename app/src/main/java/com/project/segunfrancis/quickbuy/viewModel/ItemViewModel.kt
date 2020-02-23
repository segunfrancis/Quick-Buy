package com.project.segunfrancis.quickbuy.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.segunfrancis.quickbuy.database.ItemDao
import com.project.segunfrancis.quickbuy.database.ItemsRoomDatabase
import com.project.segunfrancis.quickbuy.model.Item
import com.project.segunfrancis.quickbuy.model.ShoppingCartItem
import com.project.segunfrancis.quickbuy.repository.ItemRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

/**
 * Created by SegunFrancis
 */
class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ItemRepository
    private val itemDao: ItemDao
    val shoes: LiveData<List<Item>>
    val cameras: LiveData<List<Item>>
    val televisions: LiveData<List<Item>>
    val phones: LiveData<List<Item>>
    val laptops: LiveData<List<Item>>
    var shoppingCartList: LiveData<List<ShoppingCartItem>> = MutableLiveData()

    init {
        itemDao = ItemsRoomDatabase.getDatabase(application, viewModelScope).itemDao()
        repository = ItemRepository(itemDao)
        shoes = repository.getShoes()
        cameras = repository.getCameras()
        televisions = repository.getTelevisions()
        phones = repository.getPhones()
        laptops = repository.getLaptops()
        shoppingCartList = repository.getShoppingCartItems()
    }

    fun insert(items: List<Item>) = viewModelScope.launch {
        repository.insert(items)
    }

    fun insertIntoShoppingCartItem(shoppingCartItem: ShoppingCartItem) = viewModelScope.launch {
        repository.insertIntoShoppingCartItem(shoppingCartItem)
    }

    /*fun deleteSingleItem(shoppingCartItem: ShoppingCartItem) = viewModelScope.launch {
        repository.deleteSingleItem(shoppingCartItem)
    }*/

    fun clearShoppingCart() = viewModelScope.launch {
        repository.clearShoppingCart()
    }
}