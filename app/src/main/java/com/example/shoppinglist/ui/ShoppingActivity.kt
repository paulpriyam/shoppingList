package com.example.shoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.R
import com.example.shoppinglist.data.local.model.ShoppingItems
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_shopping.*

@AndroidEntryPoint
class ShoppingActivity : AppCompatActivity() {

    private lateinit var viewModel: ShoppingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        viewModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)
        val adapter = ShoppingAdapter(listOf(), viewModel)
        rvShopping.layoutManager = LinearLayoutManager(this)
        rvShopping.adapter = adapter
        viewModel.getAllShoppingItems().observe(this) {
            adapter.list = it
            adapter.notifyDataSetChanged()
        }
        fab.setOnClickListener {
            ShoppingDialog(this, object : DialogListener {
                override fun addItemListener(item: ShoppingItems) {
                    viewModel.updateInsert(item)
                }
            }).show()
        }
    }
}