package com.example.shoppinglist.repository

import com.example.shoppinglist.data.local.ShoppingDatabase
import com.example.shoppinglist.data.local.model.ShoppingItems

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun updateInsert(items: ShoppingItems) = db.getShoppingDao().updateInsert(items)

    suspend fun deleteItem(items: ShoppingItems) = db.getShoppingDao().deleteItem(items)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingList()
}