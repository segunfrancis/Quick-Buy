package com.project.segunfrancis.quickbuy.viewModel

import androidx.lifecycle.*
import com.project.segunfrancis.quickbuy.dataSource.local.ItemDao
import com.project.segunfrancis.quickbuy.dataSource.local.ItemsRoomDatabase
import com.project.segunfrancis.quickbuy.model.Item
import com.project.segunfrancis.quickbuy.model.ShoppingCartItem
import com.project.segunfrancis.quickbuy.repository.DefaultItemRepository
import com.project.segunfrancis.quickbuy.repository.ItemRepository
import kotlinx.coroutines.launch

/**
 * Created by SegunFrancis
 */
class ItemViewModel(private var repository: DefaultItemRepository) : ViewModel() {
    //private val itemDao: ItemDao
    /*val shoes: LiveData<List<Item>>
    val cameras: LiveData<List<Item>>
    val televisions: LiveData<List<Item>>
    val phones: LiveData<List<Item>>
    val laptops: LiveData<List<Item>>*/
    var shoppingCartList: LiveData<List<ShoppingCartItem>> = MutableLiveData()

    init {
        /*itemDao = ItemsRoomDatabase.getDatabase().itemDao()
        repository = ItemRepository(itemDao)
        shoes = repository.getShoes()
        cameras = repository.getCameras()
        televisions = repository.getTelevisions()
        phones = repository.getPhones()
        laptops = repository.getLaptops()
        shoppingCartList = repository.getShoppingCartItems()*/
    }

    /*fun insert(items: List<Item>) = viewModelScope.launch {
        repository.insert(items)
    }

    fun insertIntoShoppingCartItem(shoppingCartItem: ShoppingCartItem) = viewModelScope.launch {
        repository.insertIntoShoppingCartItem(shoppingCartItem)
    }

    *//*fun deleteSingleItem(shoppingCartItem: ShoppingCartItem) = viewModelScope.launch {
        repository.deleteSingleItem(shoppingCartItem)
    }*//*

    fun clearShoppingCart() = viewModelScope.launch {
        repository.clearShoppingCart()
    }*/
}