package com.project.segunfrancis.quickbuy.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.segunfrancis.quickbuy.repository.DefaultItemRepository
import java.lang.IllegalArgumentException

/**
 * Created by SegunFrancis
 *
 * Factory for ViewModels
 */
class ViewModelFactory(private val repository: DefaultItemRepository) : ViewModelProvider.Factory {

    /**
     * Creates a new instance of the given `Class`.
     *
     * @param modelClass a `Class` whose instance is requested
     * @param <T>        The type parameter for the ViewModel.
     * @return a newly created ViewModel
    </T> */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}