package com.project.segunfrancis.quickbuy.dataSource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.project.segunfrancis.quickbuy.model.Item
import com.project.segunfrancis.quickbuy.model.ShoppingCartItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by SegunFrancis
 */

@Database(entities = [Item::class, ShoppingCartItem::class], version = 1, exportSchema = false)
abstract class ItemsRoomDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: ItemsRoomDatabase? = null

        fun getDatabase(context: Context): ItemsRoomDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemsRoomDatabase::class.java,
                    "item_database"
                )/*.addCallback(ItemDatabaseCallback(scope))*/
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    // Populate database
    private class ItemDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    //ItemData.populateDatabase(database.itemDao())
                }
            }
        }
    }
}