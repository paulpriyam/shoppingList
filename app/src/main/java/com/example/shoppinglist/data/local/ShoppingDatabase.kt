package com.example.shoppinglist.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist.data.local.dao.ShoppingDao
import com.example.shoppinglist.data.local.model.ShoppingItems

@Database(
    entities = [ShoppingItems::class],
    version = 1,
    exportSchema = false
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao
}