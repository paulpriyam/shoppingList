package com.example.shoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.shoppinglist.R
import com.example.shoppinglist.data.local.ShoppingDatabase
import com.example.shoppinglist.repository.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {

    private lateinit var viewModel: ShoppingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val db = ShoppingDatabase(this)
        val repository = ShoppingRepository(db)
        val factory = ShoppingViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory)[ShoppingViewModel::class.java]
    }
}