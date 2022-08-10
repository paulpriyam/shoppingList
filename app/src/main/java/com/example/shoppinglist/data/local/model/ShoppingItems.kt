package com.example.shoppinglist.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "shopping_item")
data class ShoppingItems(
    var name: String,
    var amount: String,
    @PrimaryKey(autoGenerate = false)
    var id: String = UUID.randomUUID().toString()
)
