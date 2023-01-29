package com.example.listofshopping.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.listofshopping.databinding.ListItemBinding
import com.example.listofshopping.domain.ListOfShoppingModel

class ListOfShoppingAdapter : ListAdapter<ListOfShoppingModel,
        ListOfShoppingViewHolder>(ListOfShoppingDiffCallback()) {
    var onItemClickListener: ((ListOfShoppingModel) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfShoppingViewHolder {
        return ListOfShoppingViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ListOfShoppingViewHolder, position: Int) {
        val currentItem = getItem(position)
        with(holder.itemBinding) {
            tvLcd.text = currentItem.lcd
            tvOthers.text = currentItem.data
            root.setOnClickListener {
                onItemClickListener?.invoke(currentItem)
            }
        }
    }


}