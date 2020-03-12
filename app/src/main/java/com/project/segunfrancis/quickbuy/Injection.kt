package com.project.segunfrancis.quickbuy

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.project.segunfrancis.quickbuy.dataSource.local.ItemLocalCache
import com.project.segunfrancis.quickbuy.dataSource.local.ItemsRoomDatabase
import com.project.segunfrancis.quickbuy.dataSource.remote.ItemApiBuilder
import com.project.segunfrancis.quickbuy.dataSource.remote.ItemService
import com.project.segunfrancis.quickbuy.repository.DefaultItemRepository
import com.project.segunfrancis.quickbuy.viewModel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope

/**
 * Created by SegunFrancis
 *
 * Class that handles object creation.
 * Like this, objects can be passed as parameters in the constructors and then replaced for
 * testing, where needed.
*/

object Injection {

    /**
     * Creates an instance of [ItemLocalCache] based on the database DAO.
     */
    private fun provideCache(context: Context, scope: CoroutineScope): ItemLocalCache {
        val database = ItemsRoomDatabase.getDatabase(context)
        return ItemLocalCache(database.itemDao(), scope)
    }

    /**
     * Creates an instance of [DefaultItemRepository] based on the [ItemService] and a
     * [ItemLocalCache]
     */
    private fun provideItemRepository(context: Context, scope: CoroutineScope): DefaultItemRepository {
        return DefaultItemRepository(ItemApiBuilder.create(), provideCache(context, scope))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference
     * to [ViewModel] objects.
     */
    fun provideViewModelFactory(context: Context, scope: CoroutineScope): ViewModelProvider.Factory {
        return ViewModelFactory(provideItemRepository(context, scope))
    }
}