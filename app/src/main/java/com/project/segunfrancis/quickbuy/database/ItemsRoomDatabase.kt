package com.project.segunfrancis.quickbuy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.project.segunfrancis.quickbuy.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by SegunFrancis
 */

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemsRoomDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: ItemsRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ItemsRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemsRoomDatabase::class.java,
                    "item_database"
                ).addCallback(ItemDatabaseCallback(scope))
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