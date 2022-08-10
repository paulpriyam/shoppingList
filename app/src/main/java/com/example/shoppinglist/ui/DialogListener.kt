package com.example.shoppinglist.ui

import com.example.shoppinglist.data.local.model.ShoppingItems

interface DialogListener {
    fun addItemListener(item:ShoppingItems)
}