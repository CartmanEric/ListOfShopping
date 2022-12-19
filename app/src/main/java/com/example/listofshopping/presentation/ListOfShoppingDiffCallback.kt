package com.example.listofshopping.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.listofshopping.domain.ListOfShoppingModel

class ListOfShoppingDiffCallback : DiffUtil.ItemCallback<ListOfShoppingModel>() {

    override fun areItemsTheSame(oldItem: ListOfShoppingModel, newItem: ListOfShoppingModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ListOfShoppingModel, newItem: ListOfShoppingModel): Boolean {
        return oldItem == newItem
    }
}
