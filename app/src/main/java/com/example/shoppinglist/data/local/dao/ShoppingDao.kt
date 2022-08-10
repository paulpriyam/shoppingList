package com.example.shoppinglist.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.local.model.ShoppingItems

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateInsert(item: ShoppingItems)

    @Delete
    suspend fun deleteItem(item: ShoppingItems)

    @Query("SELECT * FROM shopping_item")
    suspend fun getAllShoppingList(): LiveData<List<ShoppingItems>>
}