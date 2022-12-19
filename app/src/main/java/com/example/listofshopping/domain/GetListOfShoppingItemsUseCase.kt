package com.example.listofshopping.domain

import androidx.lifecycle.LiveData

class GetListOfShoppingItemsUseCase(private val listOfShoppingRepository: ListOfShoppingRepository) {
    fun getItems(): LiveData<List<ListOfShoppingModel>> {
        return listOfShoppingRepository.getItems()
    }
}