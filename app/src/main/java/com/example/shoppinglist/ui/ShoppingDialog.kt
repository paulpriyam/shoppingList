package com.example.shoppinglist.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.local.model.ShoppingItems
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class ShoppingDialog(context: Context, val listener: DialogListener):AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)
        btAdd.setOnClickListener {
            val name=etItemName.text.toString().trim()
            val amount=etItemAmount.text.toString().trim()
            if(name.isEmpty()|| amount.isEmpty()){
                Toast.makeText(context,"enter all information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item=ShoppingItems(name, amount.toInt())
            listener.addItemListener(item)
            dismiss()
        }
        btCancel.setOnClickListener {
            cancel()
        }
    }
}