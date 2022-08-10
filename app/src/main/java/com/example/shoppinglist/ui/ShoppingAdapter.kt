package com.example.shoppinglist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.local.model.ShoppingItems
import com.example.shoppinglist.databinding.ShoppingItemBinding

class ShoppingAdapter(
    private var list: List<ShoppingItems>,
    private val viewModel: ShoppingViewModel
) :
    RecyclerView.Adapter<ShoppingAdapter.ShoppingItemViewHolder>() {

    inner class ShoppingItemViewHolder(val binding: ShoppingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ShoppingItems) {
            binding.tvItemName.text = data.name
            binding.tvAmount.text = "${data.amount}"

            binding.ivAdd.setOnClickListener {
                data.amount++
                viewModel.updateInsert(data)

            }
            binding.ivRemove.setOnClickListener {
                if (data.amount > 0) {
                    data.amount--
                    viewModel.updateInsert(data)
                }
            }
            binding.ivDelete.setOnClickListener {
                viewModel.deleteItem(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        return ShoppingItemViewHolder(
            ShoppingItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}