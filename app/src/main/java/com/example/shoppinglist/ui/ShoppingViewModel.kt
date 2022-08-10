package com.example.shoppinglist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglist.data.local.model.ShoppingItems
import com.example.shoppinglist.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel() {

    fun updateInsert(items: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch {
        repository.updateInsert(items)
    }

    fun deleteItem(item: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch {
        repository.deleteItem(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}