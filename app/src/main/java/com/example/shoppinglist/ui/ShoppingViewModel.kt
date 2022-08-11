package com.example.shoppinglist.ui

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.local.model.ShoppingItems
import com.example.shoppinglist.repository.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(private val repository: ShoppingRepository) :
    ViewModel() {

    fun updateInsert(items: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch {
        repository.updateInsert(items)
    }

    fun deleteItem(item: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch {
        repository.deleteItem(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}