package com.project.segunfrancis.quickbuy.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by SegunFrancis
 */

@Entity(tableName = "shopping_cart_table")
data class ShoppingCartItem(
    @PrimaryKey val name: String,
    var price: Int,
    var quantity: Int
) : Serializable