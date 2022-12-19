package com.example.listofshopping.domain

import androidx.lifecycle.LiveData

interface ListOfShoppingRepository {
    fun getItems(): LiveData<List<ListOfShoppingModel>>
    suspend fun addItem(item: ListOfShoppingModel)
    suspend fun deleteItem(item: ListOfShoppingModel)
    suspend fun editItem(item: ListOfShoppingModel)
}