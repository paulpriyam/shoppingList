package com.example.shoppinglist.repository

import com.example.shoppinglist.data.local.ShoppingDatabase
import com.example.shoppinglist.data.local.dao.ShoppingDao
import com.example.shoppinglist.data.local.model.ShoppingItems
import javax.inject.Inject

class ShoppingRepository @Inject constructor (private val dao: ShoppingDao) {

    suspend fun updateInsert(items: ShoppingItems) = dao.updateInsert(items)

    suspend fun deleteItem(items: ShoppingItems) = dao.deleteItem(items)

    fun getAllShoppingItems() = dao.getAllShoppingList()
}