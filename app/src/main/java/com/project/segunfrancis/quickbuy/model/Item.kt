package com.project.segunfrancis.quickbuy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by SegunFrancis
 */

@Entity(tableName = "item_table")
data class Item(
    @PrimaryKey @ColumnInfo(name = "itemName") val name: String,
    @ColumnInfo(name = "itemCategory") val category: String,
    @ColumnInfo(name = "itemDescription") val description: String,
    @ColumnInfo(name = "itemPrice") val price: String,
    @ColumnInfo(name = "itemImage") val imageResource: Int
) : Serializable