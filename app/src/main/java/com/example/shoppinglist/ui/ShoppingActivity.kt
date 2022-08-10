package com.example.shoppinglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.R
import com.example.shoppinglist.data.local.ShoppingDatabase
import com.example.shoppinglist.data.local.model.ShoppingItems
import com.example.shoppinglist.repository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity() {
//    override val kodein by kodein()
//    private val factory: ShoppingViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val db = ShoppingDatabase(this)
        val repository = ShoppingRepository(db)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this, factory)[ShoppingViewModel::class.java]

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